package com.rpc.grpc.client.intercept;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/11/14
 **/
@Slf4j
public class CustomGrpcIntercept implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, final CallOptions callOptions, final Channel channel) {
        return new CustomClientCall<>(channel.newCall(methodDescriptor, callOptions));
    }

    /**
     * 自定义 GRPC 客户端拦截器
     *
     * @param <ReqT>  请求的参数范型
     * @param <RespT> 响应的参数范型
     */
    static class CustomClientCall<ReqT, RespT> extends ClientInterceptors.CheckedForwardingClientCall<ReqT, RespT> {

        protected CustomClientCall(final ClientCall<ReqT, RespT> delegate) {
            super(delegate);
        }

        @Override
        protected void checkedStart(final Listener<RespT> listener, final Metadata metadata) throws Exception {
            // do invoke request
            delegate().start(new CustomClientCallListener<>(listener), metadata);
        }

        /**
         * 设置要发送消息的数量
         */
        @Override
        public void request(final int numMessages) {
            log.info("request in intercept invoke");
            super.request(numMessages);
        }

        /**
         * 发送消息
         */
        @Override
        public void sendMessage(final ReqT message) {
            log.info("sendMessage in intercept invoke");
            super.sendMessage(message);
        }

        /**
         * 半链接，所谓半链接就是消息发送成功以后，设置的的一个状态，证明可以接受服务端的响应，但是不可以再发送消息了
         */
        @Override
        public void halfClose() {
            log.info("halfClose in intercept invoke");
            super.halfClose();
        }
    }

    /**
     * 自定义 GRPC 客户端拦截器监听器
     */
    static class CustomClientCallListener<RespT> extends ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT> {

        protected CustomClientCallListener(final ClientCall.Listener<RespT> delegate) {
            super(delegate);
        }

        @Override
        public void onReady() {
            log.info("onRead is invoke");
            super.onReady();
        }

        /**
         * 服务端收到消息机会调用，具体的执行时机是服务端调用 onComplete 以后这个 onMessage 就会执行，服务端的 onComplete 对应的就是 netty 中的 writeAndFlush 方法
         */
        @Override
        public void onMessage(final RespT message) {
            super.onMessage(message);
        }

        /**
         * 当服务端执行完成以后 onNext 客户端拦截器这个 onHead 就会被调用
         */
        @Override
        public void onHeaders(final Metadata headers) {
            super.onHeaders(headers);
        }
    }
}
