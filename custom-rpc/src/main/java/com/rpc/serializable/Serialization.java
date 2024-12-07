package com.rpc.serializable;

/**
 * 方法设计五要素
 * - 修饰符
 * - 方法名
 * - 返回值
 * - 参数
 * - 异常
 *
 * @author xl-9527
 * @since 2024/12/7
 **/
public interface Serialization<T> {

    /**
     * 序列化
     */
    byte[] serialization(T obj) throws Exception;

    /**
     * 反序列化
     */
    <E extends T> E deserialization(byte[] bytes, Class<E> objectClass) throws Exception;
}
