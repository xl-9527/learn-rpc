package com.rpc.grpc.service.trace;

import io.grpc.*;

/**
 * @author xl-9527
 * @since 2024/11/17
 **/
public class CustomStreamingServerTrace implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(final ServerCall<ReqT, RespT> call, final Metadata headers, final ServerCallHandler<ReqT, RespT> next) {
        return next.startCall(
                call,
                headers
        );
    }

    public static class CustomForwardingServerCallListener<ReqT> extends ForwardingServerCallListener<ReqT> {

        @Override
        protected ServerCall.Listener<ReqT> delegate() {
            return null;
        }
    }

    /**
     * 他需要一个工厂
     */
    static class CustomServerStreamingTrace extends ServerStreamTracer {

    }

    /**
     * 工厂对于 server streaming trace
     */
    public static class CustomSeverStreamingTraceFactory extends ServerStreamTracer.Factory {

        @Override
        public ServerStreamTracer newServerStreamTracer(final String fullMethodName, final Metadata headers) {
            return new CustomServerStreamingTrace();
        }
    }
}
