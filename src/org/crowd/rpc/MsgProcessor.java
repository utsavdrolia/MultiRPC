package org.crowd.rpc;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import org.zeromq.ZThread;

/**
 * Created by utsav on 6/14/16.
 */
public abstract class MsgProcessor implements ZThread.IAttachedRunnable
{
    private static final long SLEEP_TIME = 1000l;
    private ZMQ.Socket serverSocket;


    public MsgProcessor(ZMQ.Socket serverSocket)
    {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run(Object[] objects, ZContext zContext, ZMQ.Socket pipe)
    {
        ZMQ.Poller poller = new ZMQ.Poller(1);
        poller.register(serverSocket, ZMQ.Poller.POLLIN);
        poller.register(pipe, ZMQ.Poller.POLLIN);
        while (!Thread.currentThread().isInterrupted())
        {
            long available = poller.poll(SLEEP_TIME);
            if (available == -1)
            {
                //Context/Thread terminated
                break;
            }
            else if (available > 0)
            {
                // Check pipe to send out stuff
                ZMsg outgoing;
                while ((outgoing = ZMsg.recvMsg(pipe, ZMQ.DONTWAIT)) != null)
                {
                    outgoing.send(serverSocket);
                }

                // Check serversocket for incoming messages
                ZMsg incoming;
                while ((incoming = ZMsg.recvMsg(serverSocket, ZMQ.DONTWAIT)) != null)
                {
                    recv(incoming);
                }
            }
        }
    }

    public abstract void recv(ZMsg incoming);
}
