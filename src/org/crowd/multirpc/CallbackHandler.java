package org.crowd.multirpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by utsav on 6/18/15.
 * Simple class to handle Callbacks in a separate thread
 */
class CallbackHandler
{
    private Map<Integer, MultiRPCRequester._RPCCallback> mCallbacks;
    private ExecutorService mExecutorService;
    CallbackHandler()
    {
        mCallbacks = new Hashtable<>();
        mExecutorService = Executors.newSingleThreadExecutor();
    }


    /**
     * Register call back
     * @param id the key for which this callback
     * @param cb The {@link MultiRPCRequester._RPCCallback}
     */
    void putCallback(Integer id, MultiRPCRequester._RPCCallback cb)
    {
        mCallbacks.put(id, cb);
    }

    /**
     * Call the callback for given key
     * @param id
     * @param message
     */
    void callCallback(final Integer id, final ByteString message)
    {
        if(mCallbacks.containsKey(id))
        {
            mExecutorService.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    MultiRPCRequester._RPCCallback cb = mCallbacks.get(id);
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
    void stop()
    {
        mExecutorService.shutdown();
    }

}
