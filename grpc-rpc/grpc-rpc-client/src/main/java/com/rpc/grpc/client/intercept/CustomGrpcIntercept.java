package com.rpc.grpc.client.intercept;

import io.grpc.*;

/**
 * @author xl-9527
 * @since 2024/11/14
 **/
public class CustomGrpcIntercept implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, final CallOptions callOptions, final Channel channel) {
        return new CustomClientCall<>(channel.newCall(methodDescriptor, callOptions));
    }


    public static class CustomClientCall<ReqT, RespT> extends ClientInterceptors.CheckedForwardingClientCall<ReqT, RespT> {

        protected CustomClientCall(final ClientCall<ReqT, RespT> delegate) {
            super(delegate);
        }

        @Override
        protected void checkedStart(final Listener<RespT> responseListener, final Metadata headers) throws Exception {
            delegate().start(responseListener, headers);
        }
    }
}
