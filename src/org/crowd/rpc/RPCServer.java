package org.crowd.rpc;

import com.google.protobuf.*;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import org.zeromq.ZThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Registers with a single RPC requester and then serves each request as it comes in
 * Created by utsav on 3/10/16.
 */
public class RPCServer implements RpcController
{
    private final ZContext zContext;
    private boolean stopped;
    private static final String SERVER_ACK = "OK";
    private String myServiceAddress;
    private final Map<String, Service> mServices;
    private ZMQ.Socket serverSock;
    private ZMQ.Socket msgProcPipe;
    private ExecutorService executorService;

    public RPCServer(String myServiceAddress, Service service, Integer threads)
    {
        System.out.println("Bound to " + this.myServiceAddress);
        this.myServiceAddress = myServiceAddress;
        executorService = Executors.newFixedThreadPool(threads);
        mServices = new HashMap<>();
        mServices.put(service.getDescriptorForType().getName(), service);
        zContext = new ZContext(1);
        stopped = false;
        // Create local server
        serverSock = zContext.createSocket(ZMQ.ROUTER);
        serverSock.bind("tcp://" + this.myServiceAddress);
        msgProcPipe = ZThread.fork(zContext, new MyMsgProcessor(serverSock));
    }

    public RPCServer(String myServiceAddress, Service service)
    {
        this(myServiceAddress, service, 8);
    }


                     /**
                      * Forward message to client
                      *
                      * @param msg
                      */
    private synchronized void send(ZMsg msg)
    {
        msg.send(msgProcPipe);
    }


    // Implements the receive function
    private class MyMsgProcessor extends MsgProcessor
    {

        public MyMsgProcessor(ZMQ.Socket serverSocket)
        {
            super(serverSocket);
        }

        /**
         * Parse incoming message and call appropriate procedure
         * @param incoming
         */
        @Override
        public void recv(ZMsg incoming)
        {
//            System.out.println("Received ZMQ Message");
            // Senders ID
            byte[] cookie = incoming.pop().getData();
            byte[] data = incoming.pop().getData();
            try
            {
                RPCProto.RPCReq msg = RPCProto.RPCReq.parseFrom(data);
                executorService.submit(() -> {
                    try
                    {
                        processRequest(msg.getServiceName(), msg.getMethodID(), msg.getArgs(), msg.getReqID(), cookie);
                    } catch (InvalidProtocolBufferException e)
                    {
                        e.printStackTrace();
                    }
                });
            } catch (InvalidProtocolBufferException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Process the service request
     * @param serviceName
     * @param methodID
     * @param args
     * @param cookie
     */
    private void processRequest(String serviceName, int methodID, ByteString args, int reqID, byte[] cookie) throws InvalidProtocolBufferException
    {
//        System.out.println("Received request for:" + serviceName + ":" + methodID);
        Service service = mServices.get(serviceName);
        if (service != null)
        {
            Descriptors.ServiceDescriptor serviceDescriptor = service.getDescriptorForType();
            Descriptors.MethodDescriptor calledmethod = null;
            for (Descriptors.MethodDescriptor method : serviceDescriptor.getMethods())
            {
                if (method.getIndex() == methodID)
                {
                    calledmethod = method;
                    break;
                }
            }
            if (calledmethod != null)
            {
                Message msg = service.getRequestPrototype(calledmethod).getParserForType().parseFrom(args);
                service.callMethod(calledmethod, this, msg, new LocalServiceCompletedCallback(reqID, cookie));
            }
        }
    }

    public boolean isStopped()
    {
        return stopped;
    }

    public void stopRunner()
    {
        this.stopped = true;
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

    /**
     * Sends the result of a RPC call back to requester
     */
    private class LocalServiceCompletedCallback implements RpcCallback<Message>
    {
        private final int reqID;
        private final byte[] replyTo;
        private long start;
        public LocalServiceCompletedCallback(int reqID, byte[] replyTo)
        {
            this.reqID = reqID;
            this.replyTo = replyTo;
            this.start = System.currentTimeMillis();
        }

        @Override
        public void run(Message message)
        {
            final RPCProto.RPCResp msg = RPCProto.RPCResp.newBuilder().
                    setReqID(reqID).
                    setDuration((int) (System.currentTimeMillis() - start)).
                    setResults(message.toByteString()).build();
            ZMsg zMsg = new ZMsg();
            // Add the address to send message
            zMsg.addLast(replyTo);
            // Add content
            zMsg.addLast(msg.toByteArray());
            // Send
            send(zMsg);
        }
    }
}
