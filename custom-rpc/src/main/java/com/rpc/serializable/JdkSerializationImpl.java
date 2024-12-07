package com.rpc.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/**
 * @author xl-9527
 * @since 2024/12/7
 **/
public class JdkSerializationImpl implements Serialization<Object> {

    @Override
    public byte[] serialization(final Object obj) throws Exception {
        if (Objects.isNull(obj)) {
            return new byte[0];
        }

        final ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(byteArrayStream)) {
            stream.writeObject(obj);
            return byteArrayStream.toByteArray();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E deserialization(final byte[] bytes, Class<E> clazz) throws Exception {
        if (Objects.isNull(bytes) || bytes.length == 0) {
            return null;
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return (E) inputStream.readObject();
        }
    }
}
