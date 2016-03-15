package org.crowd.multirpc;

import com.google.protobuf.*;
import org.zeromq.ZContext;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Registers with a single RPC requester and then serves each request as it comes in
 * Created by utsav on 3/10/16.
 */
public class SingleRPCResponder extends Thread implements RpcController
{
    private final ZContext zContext;
    private boolean stopped;
    private static final String SERVER_ACK = "OK";
    private String myServiceAddress;
    private String registrationAddress;
    private ExecutorService requestExecutor = Executors.newSingleThreadExecutor();
    private final Map<String, Service> mServices;
    ZMQ.Socket serverSock;

    public SingleRPCResponder(String myServiceAddress, String registrationAddress, Service service)
    {
        this.myServiceAddress = myServiceAddress;
        this.registrationAddress = registrationAddress;
        mServices = new HashMap<>();
        mServices.put(service.getDescriptorForType().getName(), service);
        zContext = new ZContext(1);
        stopped = false;
        // Create local server
        serverSock = zContext.createSocket(ZMQ.ROUTER);
        serverSock.bind("tcp://" + myServiceAddress);
    }

    @Override
    public void run()
    {
        // Connect to remote server, register, recv ack, disconnect
        ZMQ.Socket clientSock = zContext.createSocket(ZMQ.REQ);
        clientSock.connect("tcp://" + registrationAddress);
        clientSock.send(myServiceAddress);
        String reply = clientSock.recvStr();

        if(reply.equals(SERVER_ACK))
        {
            // wait for message from remote server/client to tell you what to do
            while (!this.isStopped() && !this.isInterrupted())
            {
                ZMsg zMsg = ZMsg.recvMsg(serverSock);
                if (zMsg != null)
                {
                    System.out.println("Received ZMQ Message");
                    // Senders ID
                    final byte[] cookie = zMsg.pop().getData();
                    byte[] data = zMsg.pop().getData();
                    try
                    {

                        final MultiRPCProto.MultiRPCReq msg = MultiRPCProto.MultiRPCReq.parseFrom(data);
                        requestExecutor.submit(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                processRequest(msg.getServiceName(), msg.getMethodID(), msg.getArgs(), msg.getReqID(), cookie);
                            }
                        });

                    } catch (InvalidProtocolBufferException e)
                    {
                        e.printStackTrace();
                    }
                }
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
    private void processRequest(String serviceName, int methodID, ByteString args, int reqID, byte[] cookie)
    {
        try
        {
            System.out.println("Received request for:" + serviceName + ":" + methodID);
            Service service = mServices.get(serviceName);
            if (service != null)
            {
                Descriptors.ServiceDescriptor serviceDescriptor = service.getDescriptorForType();
                Descriptors.MethodDescriptor calledmethod = null;
                for (Descriptors.MethodDescriptor method : serviceDescriptor.getMethods())
                {
                    if (method.getIndex() == methodID)
                        calledmethod = method;
                }
                if (calledmethod != null)
                {
                    Message msg = service.getRequestPrototype(calledmethod).getParserForType().parseFrom(args);
                    service.callMethod(calledmethod, this, msg, new LocalServiceCompletedCallback(reqID, cookie));
                }
            }
        } catch (InvalidProtocolBufferException e)
        {
            e.printStackTrace();
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

        public LocalServiceCompletedCallback(int reqID, byte[] replyTo)
        {
            this.reqID = reqID;
            this.replyTo = replyTo;
        }

        @Override
        public void run(Message message)
        {
            final MultiRPCProto.MultiRPCResp msg = MultiRPCProto.MultiRPCResp.newBuilder().
                    setReqID(reqID).
                    setResults(message.toByteString()).build();
            ZMsg zMsg = new ZMsg();
            // Add the address to send message
            zMsg.addLast(replyTo);
            // Add content
            zMsg.addLast(msg.toByteArray());
            // Send
            zMsg.send(serverSock);
        }
    }
}
