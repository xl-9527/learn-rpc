package com.rpc.grpc.client;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import com.rpc.grpc.client.retry.RetryConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author xl-9527
 * @since 2024/11/23
 **/
public class GrpcRetryClient {

    public static void main(String[] args) throws InterruptedException {
        final ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext().defaultServiceConfig(RetryConfig.getRetryConfig()).enableRetry()
                .build();

        try {
            final BiRpcServiceGrpc.BiRpcServiceStub serviceStub = BiRpcServiceGrpc.newStub(managedChannel);
            serviceStub.getOnceMessage(
                    BiService.OnceMessageRequest.newBuilder().setContent("你好").build(),
                    new CustomStreamObserverReq()
            );
        } finally {
            managedChannel.awaitTermination(60, TimeUnit.SECONDS);
            managedChannel.shutdown();
        }
    }

    @Slf4j
    private static class CustomStreamObserverReq implements StreamObserver<BiService.OnceMessageResponse> {

        @Override
        public void onNext(final BiService.OnceMessageResponse value) {
            log.info("receive server message -> {}", value.getContent());
        }

        @Override
        public void onError(final Throwable t) {
            log.error("发生异常", t);
        }

        @Override
        public void onCompleted() {
            log.info("server handler finish");
        }
    }
}
