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

    static class CustomClientCall<ReqT, RespT> extends ClientInterceptors.CheckedForwardingClientCall<ReqT, RespT> {

        protected CustomClientCall(final ClientCall<ReqT, RespT> delegate) {
            super(delegate);
        }

        @Override
        protected void checkedStart(final Listener<RespT> listener, final Metadata metadata) throws Exception {
            // do invoke request
            delegate().start(listener, metadata);
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
}
