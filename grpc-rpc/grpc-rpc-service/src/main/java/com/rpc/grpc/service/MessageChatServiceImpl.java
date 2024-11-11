package com.rpc.grpc.service;

import com.rpc.grpc.UserInfoChatGrpc;
import com.rpc.grpc.UserService;
import io.grpc.stub.StreamObserver;

/**
 * @author xl-9527
 * @since 2024/11/11
 **/
public class MessageChatServiceImpl extends UserInfoChatGrpc.UserInfoChatImplBase {

    @Override
    public StreamObserver<UserService.ChatMessage> startChat(final StreamObserver<UserService.ChatMessage> responseObserver) {
        responseObserver.onNext(UserService.ChatMessage.newBuilder().setContent("你好").build());
        responseObserver.onCompleted();
        return new StreamObserver<>() {
            @Override
            public void onNext(final UserService.ChatMessage value) {
                System.out.println("收到客户端" + value.getContent());
            }

            @Override
            public void onError(final Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("客户端响应完毕");
            }
        };
    }
}
