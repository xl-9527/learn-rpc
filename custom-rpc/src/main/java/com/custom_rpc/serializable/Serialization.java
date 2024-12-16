package com.custom_rpc.serializable;

import com.custom_rpc.protocol.Protocol;

/**
 * @author xl-9527
 * @since 2024/12/16
 **/
public interface Serialization {

    /**
     * 序列化
     *
     * @param protocol 协议
     * @return 序列化以后的字节数组
     */
    byte[] serialization(Protocol protocol);

    /**
     * 反序列化
     *
     * @param bytes 字节数组
     * @return 反序列化以后的数据
     */
    Protocol deserialization(byte[] bytes);
}
