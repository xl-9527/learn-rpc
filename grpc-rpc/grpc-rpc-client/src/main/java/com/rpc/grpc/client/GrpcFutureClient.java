package com.rpc.grpc.client;

import com.rpc.grpc.UserInfoServiceGrpc;
import com.rpc.grpc.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author xl-9527
 * @since 2024/11/9
 **/
@Slf4j
public class GrpcFutureClient {

    public static void main(String[] args) throws InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext().build();
        try {
            final UserInfoServiceGrpc.UserInfoServiceStub userInfoServiceStub = UserInfoServiceGrpc.newStub(channel);
            final UserService.UserInfo request = UserService.UserInfo.newBuilder().setUserInfoId(1).setUsername("server streaming and client is non blocking").build();
            final StreamObserver<UserService.UserInfoResponse> streamObserver = new StreamObserver<>() {
                @Override
                public void onNext(final UserService.UserInfoResponse userInfoResponse) {
                    log.info("接收到的数据 {}", userInfoResponse);
                }

                @Override
                public void onError(final Throwable throwable) {
                    log.error("", throwable);
                }

                @Override
                public void onCompleted() {
                    log.info("完成");
                }
            };
            userInfoServiceStub.getStreamingResponseWIthUserInfo(request, streamObserver);
        } finally {
            channel.awaitTermination(11, TimeUnit.SECONDS);
            channel.shutdown();
        }
    }
}
