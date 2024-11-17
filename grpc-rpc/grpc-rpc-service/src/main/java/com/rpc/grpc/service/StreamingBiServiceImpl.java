package com.rpc.grpc.service;

import com.rpc.grpc.bi.StreamBiServerGrpc;
import com.rpc.grpc.bi.StreamingBiServiceProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xl-9527
 * @since 2024/11/17
 **/
public class StreamingBiServiceImpl extends StreamBiServerGrpc.StreamBiServerImplBase {

    @Override
    public StreamObserver<StreamingBiServiceProto.StreamingBiMessageReq> getMessages(final StreamObserver<StreamingBiServiceProto.StreamingBiMessageResp> responseObserver) {
        return new CustomStreamObserverReq(responseObserver);
    }

    @Slf4j
    static class CustomStreamObserverReq implements StreamObserver<StreamingBiServiceProto.StreamingBiMessageReq> {

        private final StreamObserver<StreamingBiServiceProto.StreamingBiMessageResp> responseObserver;

        public CustomStreamObserverReq(final StreamObserver<StreamingBiServiceProto.StreamingBiMessageResp> responseObserver) {
            this.responseObserver = responseObserver;
        }

        @Override
        public void onNext(final StreamingBiServiceProto.StreamingBiMessageReq value) {
            log.info("收到客户端的消息 -> {}", value.getContent());
            responseObserver.onNext(
                    StreamingBiServiceProto.StreamingBiMessageResp.newBuilder().setContent("我收到了你的消息 -> 【" + value.getContent() + "】").build()
            );
        }

        @Override
        public void onError(final Throwable t) {

        }

        @Override
        public void onCompleted() {
            log.warn("客户端关闭连接");
            responseObserver.onCompleted();
        }
    }
}
