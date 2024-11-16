package com.rpc.grpc.service.intercept;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/11/16
 **/
public class CustomServerIntercept implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(final ServerCall<ReqT, RespT> serverCall, final Metadata metadata, final ServerCallHandler<ReqT, RespT> serverCallHandler) {
        return new CustomServerCallListenerReqT<>(
                serverCallHandler.startCall(new CustomServerCall<>(serverCall), metadata)
        );
    }

    @Slf4j
    static class CustomServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {

        protected CustomServerCall(final ServerCall<ReqT, RespT> delegate) {
            super(delegate);
        }

        @Override
        public void request(final int numMessages) {
            log.info("指定发送消息的数量 -> {}", numMessages);
            super.request(numMessages);
        }

        @Override
        public void sendHeaders(final Metadata headers) {
            log.info("设置响应头");
            super.sendHeaders(headers);
        }

        @Override
        public void sendMessage(final RespT message) {
            log.info("发送响应消息 -> {}", message);
            super.sendMessage(message);
        }

        @Override
        public void close(final Status status, final Metadata trailers) {
            log.info("关闭链接");
            super.close(status, trailers);
        }
    }

    /**
     * 服务端的拦截，这个只会处理请求的拦截，不会处理响应的拦截
     */
    @Slf4j
    static class CustomServerCallListenerReqT<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {

        protected CustomServerCallListenerReqT(final ServerCall.Listener<ReqT> delegate) {
            super(delegate);
        }

        @Override
        public void onReady() {
            log.info("他调用时机是在服务准备接受数据的时候");
            super.onReady();
        }

        @Override
        public void onHalfClose() {
            log.info("他调用时机是在服务接收到半关闭请求的时候");
            super.onHalfClose();
        }

        @Override
        public void onComplete() {
            log.info("他调用时机是在服务接收到完整请求的时候, 服务器调用 onComplete 的时候");
            super.onComplete();
        }

        @Override
        public void onCancel() {
            log.info("他调用时机是在客户端和服务端链接异常关闭的时候，可以用来做资源的释放");
            super.onCancel();
        }
    }
}
