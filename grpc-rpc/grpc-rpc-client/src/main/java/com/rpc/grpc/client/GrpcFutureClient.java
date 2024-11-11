package com.rpc.grpc.client;

import com.rpc.grpc.UserInfoServiceGrpc;
import com.rpc.grpc.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

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
            invokeClientStreaming(channel);
        } finally {
            channel.awaitTermination(11, TimeUnit.SECONDS);
            channel.shutdown();
        }
    }

    private static void invokeClientStreaming(final ManagedChannel channel) {
        final UserInfoServiceGrpc.UserInfoServiceStub newStub = UserInfoServiceGrpc.newStub(channel);

        final StreamObserver<UserService.UserInfo> streamObserver = newStub.batchGetUserInfo(new StreamObserver<>() {
            @Override
            public void onNext(final UserService.UserInfoResponse userInfoResponse) {
                log.info("receive server response -> [userId -> {}. username -> {}]", userInfoResponse.getUserInfoId(), userInfoResponse.getUsername());
            }

            @Override
            public void onError(final Throwable throwable) {
                log.info("an exception occurred from server", throwable);
            }

            @Override
            public void onCompleted() {
                log.info("server handler finish");
            }
        });

        for (int i = 0; i < 10; i++) {
            streamObserver.onNext(
                    UserService.UserInfo.newBuilder()
                            .setUsername(UUID.randomUUID().toString())
                            .setUserInfoId(Random.from(RandomGenerator.getDefault()).nextInt(100))
                            .build()
            );
        }
        streamObserver.onCompleted();
    }

    private static void invokeServerStreaming(final ManagedChannel channel) {
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
    }
}
