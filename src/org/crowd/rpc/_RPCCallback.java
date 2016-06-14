package org.crowd.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;

/**
 * Created by utsav on 6/14/16.
 */
public class _RPCCallback<T extends Message>
{
    private T returnMessagePrototype = null;
    private RpcCallback<T> cb;

    public _RPCCallback(T returnMessagePrototype, RpcCallback<T> cb)
    {
        this.returnMessagePrototype = returnMessagePrototype;
        this.cb = cb;
    }

    public void _run(ByteString msg) throws InvalidProtocolBufferException
    {
        cb.run((T) returnMessagePrototype.getParserForType().parseFrom(msg));
    }
}
