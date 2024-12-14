package com.rpc.pre.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
public class HessianSerializationImpl implements Serialization<Object> {

    @Override
    public byte[] serialization(final Object obj) throws Exception {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final Hessian2Output output = new Hessian2Output(outputStream);
        output.writeObject(obj);
        output.flush();
        return outputStream.toByteArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E deserialization(final byte[] bytes, Class<E> clazz) throws Exception {
        final ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        return (E) new Hessian2Input(stream).readObject(clazz);
    }
}
