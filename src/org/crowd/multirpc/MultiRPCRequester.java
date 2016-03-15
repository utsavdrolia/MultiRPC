package org.crowd.multirpc;

import com.google.protobuf.*;
import org.zeromq.ZMQ;
import java.util.HashMap;

/**
 * Creates the client side of the RPC channel. The server-side of this would first register with this Requester,
 * then whenever the app makes a call, it gets forwarded to all registered servers
 * Created by utsav on 3/10/16.
 */
public class MultiRPCRequester extends Thread implements RpcChannel, RpcController
{
    private static final long SLEEP_TIME = 1000l;
    private final HashMap<String, ZMQ.Socket> deviceMap = new HashMap<>();
    private ZMQ.Socket registerSocket;
    protected ZMQ.Context ctx;
    private boolean stop = false;
    private static final String SERVER_ACK = "OK";
    private int msgID = 0;
    private CallbackHandler mCallbackHandler = new CallbackHandler();

    /**
     *
     * @param myAddress This server's IP address
     */
    public MultiRPCRequester(String myAddress)
    {
        ctx = ZMQ.context(1);
        registerSocket = ctx.socket(ZMQ.REP);
        registerSocket.bind("tcp://" + myAddress);
    }

    @Override
    public void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message respMessageProto, RpcCallback<Message> rpcCallback)
    {
        // Get new ID
        Integer id = getnextid();
        // Construct request
        final MultiRPCProto.MultiRPCReq msg = MultiRPCProto.MultiRPCReq.newBuilder().
                setReqID(id).
                setServiceName(methodDescriptor.getService().getName()).
                setMethodID(methodDescriptor.getIndex()).
                setArgs(message.toByteString()).build();
        // Wrap callback
        _RPCCallback cb = new _RPCCallback(respMessageProto, rpcCallback);
        // Broadcast query
        sendToAll(msg.toByteArray());
        // Put callback
        mCallbackHandler.putCallback(id, cb);
        System.out.println("Called Method:" + methodDescriptor.getFullName());
    }

    /**
     * Forward message to each connected device
     * @param msg
     */
    private synchronized void sendToAll(byte[] msg)
    {
        for (ZMQ.Socket sock:deviceMap.values())
        {
            sock.send(msg);
        }
    }

    /**
     *
     * @return Keys to be used to track requests
     */
    private synchronized Integer getnextid()
    {
        return this.msgID++;
    }

    public int getNumberOfRegisteredDevs()
    {
        return deviceMap.size();
    }

    public void run()
    {
        ZMQ.Poller poller = ctx.poller();
        poller.register(registerSocket, ZMQ.Poller.POLLIN);
        while (!stop && !this.isInterrupted())
        {
            long available = poller.poll(SLEEP_TIME);
            if (available == -1)
            {
                //Context/Thread terminated
                break;
            } else while (available > 0)
            {
                if (poller.pollin(0))
                {
                    //  Received from registerSocket

                    String endpoint = registerSocket.recvStr();
                    if (endpoint != null)
                    {
                        // Check if we already have an entry for this device
                        synchronized (deviceMap)
                        {
                            deviceMap.put(endpoint, ctx.socket(ZMQ.DEALER));
                            // Connect to device
                            deviceMap.get(endpoint).connect("tcp://" + endpoint);
                            // Register socket in poller
                            poller.register(deviceMap.get(endpoint), ZMQ.Poller.POLLIN);
                        }
                        System.out.println("Registered: " + endpoint);
                        registerSocket.send(SERVER_ACK);
                    }
                    available--;
                }
                // Check for dealersockets
                if(poller.getSize() > 1)
                {
                    for (int i = 1; i < poller.getSize(); i++)
                    {
                        if(poller.pollin(i))
                        {
                            ZMQ.Socket sock = poller.getSocket(i);
                            byte[] data = sock.recv();

                            try
                            {
                                MultiRPCProto.MultiRPCResp msg = MultiRPCProto.MultiRPCResp.parseFrom(data);
                                mCallbackHandler.callCallback(msg.getReqID(), msg.getResults());
                            } catch (InvalidProtocolBufferException e)
                            {
                                e.printStackTrace();
                            }
                            available--;
                        }
                    }
                }
            }
        }
    }

    /**
     * Wrapper around {@link RpcCallback} for multiple replies
     * @param <T>
     */
    public static abstract class MultiRPCCallback<T extends Message> implements RpcCallback<T>
    {
        private int numberOfQueries;
        private int numReplies = 0;

        /**
         *
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
         *
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

    public class _RPCCallback<T extends Message>
    {
        private T returnMessagePrototype = null;
        private RpcCallback<T> cb;

        public _RPCCallback(T returnMessagePrototype, RpcCallback<T> cb)
        {
            this.returnMessagePrototype = returnMessagePrototype;
            this.cb = cb;
        }

        protected void _run(ByteString msg) throws InvalidProtocolBufferException
        {
            cb.run((T) returnMessagePrototype.getParserForType().parseFrom(msg));
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
