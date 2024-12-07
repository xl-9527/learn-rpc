package com.rpc.serializable;

import org.apache.thrift.TSerializable;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
public class ThriftSerializationImpl implements Serialization<TSerializable> {

    @Override
    public byte[] serialization(final TSerializable obj) throws Exception {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        final TBinaryProtocol protocol = new TBinaryProtocol(new TIOStreamTransport(stream));
        obj.write(protocol);
        return stream.toByteArray();
    }

    @Override
    public <E extends TSerializable> E deserialization(final byte[] bytes, final Class<E> objectClass) throws Exception {
        final TBinaryProtocol protocol = new TBinaryProtocol(new TIOStreamTransport(new ByteArrayInputStream(bytes)));
        final E e = objectClass.getDeclaredConstructor().newInstance();
        e.read(protocol);
        return e;
    }
}
