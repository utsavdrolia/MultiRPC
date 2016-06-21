package org.crowd.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.crowd.multirpc.MultiRPCRequester;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by utsav on 6/18/15.
 * Simple class to handle Callbacks in a separate thread
 */
public class CallbackHandler
{
    private Map<Integer, _RPCCallback> mCallbacks;
    private ExecutorService mExecutorService;
    public CallbackHandler()
    {
        mCallbacks = new Hashtable<>();
        mExecutorService = Executors.newFixedThreadPool(4);
    }


    /**
     * Register call back
     * @param id the key for which this callback
     * @param cb The {@link _RPCCallback}
     */
    public void putCallback(Integer id, _RPCCallback cb)
    {
        mCallbacks.put(id, cb);
    }

    /**
     * Call the callback for given key
     * @param id
     * @param message
     */
    public void callCallback(final Integer id, final ByteString message)
    {
        if(mCallbacks.containsKey(id))
        {
            mExecutorService.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    _RPCCallback cb = mCallbacks.get(id);
                    try
                    {
                        cb._run(message);
                    } catch (InvalidProtocolBufferException e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * Stop this CallBack Handler
     */
    public void stop()
    {
        mExecutorService.shutdown();
    }

}
