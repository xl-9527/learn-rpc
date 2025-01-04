package com.rpc.dubbo.api.triple;

import org.apache.dubbo.common.stream.StreamObserver;

/**
 * 通过 java 接口定义 triple 协议（也可以使用 proto 的 idl）
 *
 * @author xl-9527
 * @since 2025/1/4
 **/
public interface GreeterService {

    /**
     * 一元
     */
    String greet(String request);

    /**
     * 双向流式
     */
    StreamObserver<String> biGreet(StreamObserver<String> response);
}
