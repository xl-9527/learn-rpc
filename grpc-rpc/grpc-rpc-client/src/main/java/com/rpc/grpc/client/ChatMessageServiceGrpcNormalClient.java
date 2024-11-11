package com.rpc.grpc.client;

import com.rpc.grpc.UserInfoChatGrpc;
import com.rpc.grpc.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * @author xl-9527
 * @since 2024/11/11
 **/
public class ChatMessageServiceGrpcNormalClient {

    public static void main(String[] args) {
        // channel
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext().build();
        // 获取 stub
        final UserInfoChatGrpc.UserInfoChatStub infoChatStub = UserInfoChatGrpc.newStub(channel);
        final StreamObserver<UserService.ChatMessage> messageStreamObserver = infoChatStub.startChat(new StreamObserver<>() {
            @Override
            public void onNext(final UserService.ChatMessage value) {
                System.out.println("接受到消息" + value.getContent());
            }

            @Override
            public void onError(final Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });

        // 客户端发送消息
        messageStreamObserver.onNext(
                UserService.ChatMessage.newBuilder()
                        .setCcId(Random.from(RandomGenerator.getDefault()).nextInt())
                        .setContent("hello")
                        .build()
        );
        messageStreamObserver.onCompleted();
    }
}
