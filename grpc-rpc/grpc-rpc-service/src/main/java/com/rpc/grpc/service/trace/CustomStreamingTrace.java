package com.rpc.grpc.service.trace;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/11/17
 **/
public class CustomStreamingTrace implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> method, final CallOptions callOptions, final Channel next) {
        return next.newCall(
                method,
                // 这里虽然返回依然是 callOptions 但是已经不是原来的了，这是一个 new 的新的对象
                callOptions.withStreamTracerFactory(new CustomClientStreamingTraceFactory())
        );
    }

    /**
     * 客户端的流式拦截
     */
    @Slf4j
    static class CustomClientStreamingTrace extends ClientStreamTracer {

        @Override
        public void outboundMessage(final int seqNo) {
            log.info("客户端：监控请求操作消息号：{}，这里是单独的消息号的设置", seqNo);

        }

        @Override
        public void outboundUncompressedSize(final long bytes) {
            log.info("未压缩的消息大小 -> {}", bytes);
            super.outboundUncompressedSize(bytes);
        }

        @Override
        public void outboundWireSize(final long bytes) {
            log.info("获取输出消息的大小 -> {}", bytes);
            super.outboundWireSize(bytes);
        }

        /**
         * 这个相当于把上面的三个方法做了一个汇总的行为，他可以获得上面三个方法的参数值
         */
        @Override
        public void outboundMessageSent(final int seqNo, final long optionalWireSize, final long optionalUncompressedSize) {
            log.info("客户端：监控请求操作消息号：{}", seqNo);
            super.outboundMessageSent(seqNo, optionalWireSize, optionalUncompressedSize);
        }

        @Override
        public void outboundHeaders() {
            log.info("客户端：发送请求头");
            super.outboundHeaders();
        }
    }

    /**
     * trace factory for client streaming
     */
    static class CustomClientStreamingTraceFactory extends ClientStreamTracer.Factory {

        @Override
        public ClientStreamTracer newClientStreamTracer(final ClientStreamTracer.StreamInfo info, final Metadata headers) {
            return new CustomClientStreamingTrace();
        }
    }
}