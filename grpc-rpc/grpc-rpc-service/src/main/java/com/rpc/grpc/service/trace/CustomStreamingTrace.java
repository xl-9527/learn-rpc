package com.rpc.grpc.service.trace;

import io.grpc.ClientStreamTracer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/11/17
 **/
public class CustomStreamingTrace {


    /**
     * 客户端的流式拦截
     */
    @Slf4j
    static class CustomClientStreamingTrace extends ClientStreamTracer {

    }
}