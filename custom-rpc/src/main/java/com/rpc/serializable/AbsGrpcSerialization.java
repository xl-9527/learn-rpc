package com.rpc.serializable;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author xl-9527
 * @since 2024/12/8
 **/
public abstract class AbsGrpcSerialization<T> implements Serialization<T> {

    @Override
    public byte[] serialization(final T obj) throws Exception {
        return transferToByteArray().apply(obj);
    }

    public abstract Function<T, byte[]> transferToByteArray();

    @Override
    @SuppressWarnings("unchecked")
    public <E extends T> E deserialization(final byte[] bytes, final Class<E> objectClass) throws Exception {
        return (E) this.transferToObj().apply(bytes, (Class<T>) objectClass);
    }

    public abstract BiFunction<byte[], Class<T>, T> transferToObj();
}
