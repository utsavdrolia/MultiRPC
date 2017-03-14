package org.crowd.rpc;

import com.google.protobuf.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import org.zeromq.ZThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

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
    private final static Logger logger = LoggerFactory.getLogger(RPCServer.class);

    // To track queued request times
    private Map<Integer, Long> enqueued;

    private final AtomicLong send_counter = new AtomicLong(0L);
    private final AtomicLong recv_counter = new AtomicLong(0L);

    public RPCServer(String myServiceAddress, Service service, Integer threads)
    {
        this.myServiceAddress = myServiceAddress;
        executorService = Executors.newFixedThreadPool(threads);
        enqueued = new ConcurrentHashMap<>();
        mServices = new HashMap<>();
        mServices.put(service.getDescriptorForType().getName(), service);
        zContext = new ZContext(1);
        stopped = false;
        // Create local server
        serverSock = zContext.createSocket(ZMQ.ROUTER);
        serverSock.bind("tcp://" + this.myServiceAddress);
        System.out.println("Bound to " + this.myServiceAddress);
        msgProcPipe = ZThread.fork(zContext, new MyMsgProcessor(serverSock));
    }

    public RPCServer(String myServiceAddress, Service service)
    {
        this(myServiceAddress, service, 8);
    }

    public RPCServer(String myServiceAddress, Service... services)
    {
        this(myServiceAddress, services[0], 8);
        for (int i = 1; i < services.length; i++)
        {
            mServices.put(services[i].getDescriptorForType().getName(), services[i]);
        }
    }

    /**
     * Get the time this request was received
     * @param msgHash
     * @return
     */
    public Long getRequestRxTime(int msgHash)
    {
        return enqueued.remove(msgHash);
    }
    /**
    * Forward message to client
    *
    * @param msg
    */
    private synchronized void send(ZMsg msg)
    {
        logger.debug("Sending Request Number:" + send_counter.incrementAndGet());
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
            logger.debug("Received Request Number:" + recv_counter.incrementAndGet());
            Long req_rx = System.currentTimeMillis();
            final byte[] cookie = incoming.pop().getData();
            byte[] data = incoming.pop().getData();
            try
            {
                final RPCProto.RPCReq msg = RPCProto.RPCReq.parseFrom(data);
                final Service service = mServices.get(msg.getServiceName());
                final Descriptors.MethodDescriptor calledmethod = getCalledMethod(service, msg.getMethodID());
                if (calledmethod != null)
                {
                    final Message appmsg = service.getRequestPrototype(calledmethod).getParserForType().parseFrom(msg.getArgs());
                    int hash = appmsg.hashCode();
                    logger.debug("Received Hash:" + hash);
                    enqueued.put(hash, req_rx);
                    executorService.submit(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                processRequest(service, calledmethod, appmsg, msg.getReqID(), cookie);
                            } catch (InvalidProtocolBufferException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InvalidProtocolBufferException e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     * Find the called method in the service directory
     * @param service
     * @param methodID
     * @return
     */
    private Descriptors.MethodDescriptor getCalledMethod(Service service, int methodID)
    {
        if (service != null)
        {
            Descriptors.ServiceDescriptor serviceDescriptor = service.getDescriptorForType();
            for (Descriptors.MethodDescriptor method : serviceDescriptor.getMethods())
            {
                if (method.getIndex() == methodID)
                {
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * Process the service request
     * @param cookie
     */
    private void processRequest(Service service, Descriptors.MethodDescriptor calledmethod, Message appmsg, int reqID, byte[] cookie) throws InvalidProtocolBufferException
    {
            service.callMethod(calledmethod, this, appmsg, new LocalServiceCompletedCallback(reqID, cookie));
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
            final RPCProto.RPCResp msg = RPCProto.RPCResp.newBuilder().
                    setReqID(reqID).
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
