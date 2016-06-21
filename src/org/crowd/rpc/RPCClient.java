package org.crowd.rpc;

import com.google.protobuf.*;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import org.zeromq.ZThread;

/**
 * Creates the client side of the RPC channel. The server-side of this would first register with this Requester,
 * then whenever the app makes a call, it gets forwarded to all registered servers
 * Created by utsav on 3/10/16.
 */
public class RPCClient implements RpcChannel, RpcController
{
    private ZMQ.Socket serverSocket;
    protected ZContext ctx;
    private boolean stop = false;
    private static final String SERVER_ACK = "OK";
    private ZMQ.Socket msgProcessorPipe;
    private int msgID = 0;
    private CallbackHandler mCallbackHandler = new CallbackHandler();

    /**
     * @param servAddress server's IP address
     */
    public RPCClient(String servAddress)
    {
        ctx = new ZContext(1);
        serverSocket = ctx.createSocket(ZMQ.DEALER);
        serverSocket.connect("tcp://" + servAddress);
        msgProcessorPipe = ZThread.fork(ctx, new MyMsgProcessor(serverSocket));
    }

    @Override
    public synchronized void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message respMessageProto, RpcCallback<Message> rpcCallback)
    {
        // Get new ID
        Integer id = getnextid();
        // Construct request
        final RPCProto.RPCReq msg = RPCProto.RPCReq.newBuilder().
                setReqID(id).
                setServiceName(methodDescriptor.getService().getName()).
                setMethodID(methodDescriptor.getIndex()).
                setArgs(message.toByteString()).build();
        // Wrap callback
        _RPCCallback cb = new _RPCCallback(respMessageProto, rpcCallback);
        // Broadcast query
        send(msg.toByteArray());
        // Put callback
        mCallbackHandler.putCallback(id, cb);
        //System.out.println("Called Method:" + methodDescriptor.getFullName());
    }

    /**
     * Forward message to server
     *
     * @param msg
     */
    private synchronized void send(byte[] msg)
    {
        msgProcessorPipe.send(msg);
    }

    // Implements the receive function
    private class MyMsgProcessor extends MsgProcessor
    {

        public MyMsgProcessor(ZMQ.Socket serverSocket)
        {
            super(serverSocket);
        }

        /**
         * Parse incoming message and call appropriate callback
         * @param incoming
         */
        @Override
        public void recv(ZMsg incoming)
        {
            try
            {
                byte[] data = incoming.pop().getData();
                RPCProto.RPCResp msg = RPCProto.RPCResp.parseFrom(data);
                mCallbackHandler.callCallback(msg.getReqID(), msg.getResults());
            } catch (InvalidProtocolBufferException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return Keys to be used to track requests
     */
    private synchronized Integer getnextid()
    {
        return this.msgID++;
    }


    /**
     * Wrapper around {@link RpcCallback} for multiple replies
     *
     * @param <T>
     */
    public static abstract class MultiRPCCallback<T extends Message> implements RpcCallback<T>
    {
        private int numberOfQueries;
        private int numReplies = 0;

        /**
         * @return Total number of peers queried
         */
        public int getNumberOfQueries()
        {
            return numberOfQueries;
        }

        public void setNumberOfQueries(int numberOfQueries)
        {
            this.numberOfQueries = numberOfQueries;
        }

        /**
         * @return The number of replies seen uptil now
         */
        public int getNumReplies()
        {
            return numReplies;
        }

        protected void incNumReplies()
        {
            this.numReplies += 1;
        }

    }

    @Override
    public void reset()
    {

    }

    @Override
    public boolean failed()
    {
        return false;
    }

    @Override
    public String errorText()
    {
        return null;
    }

    @Override
    public void startCancel()
    {

    }

    @Override
    public void setFailed(String s)
    {

    }

    @Override
    public boolean isCanceled()
    {
        return false;
    }

    @Override
    public void notifyOnCancel(RpcCallback<Object> rpcCallback)
    {

    }
}
