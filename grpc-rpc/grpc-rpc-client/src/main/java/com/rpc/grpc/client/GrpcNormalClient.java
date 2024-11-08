package com.rpc.grpc.client;

import com.rpc.grpc.UserInfoServiceGrpc;
import com.rpc.grpc.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * @author xl-9527
 * @since 2024/11/7
 **/
public class GrpcNormalClient {
    public static void main(String[] args) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext().build();
        try {
            final UserInfoServiceGrpc.UserInfoServiceBlockingStub infoServiceBlockingStub = UserInfoServiceGrpc.newBlockingStub(channel);
            final UserService.UserInfoResponse stubUserInfo = infoServiceBlockingStub.getUserInfo(UserService.UserInfo.newBuilder().setUsername("hh").setUserInfoId(987).build());

            System.out.println(stubUserInfo);

            handlerServerStreaming(infoServiceBlockingStub);
        } finally {
            channel.shutdown();
        }
    }

    private static void handlerServerStreaming(final UserInfoServiceGrpc.UserInfoServiceBlockingStub infoServiceBlockingStub) {
        final Iterator<UserService.UserInfoResponse> responseWithUserInfo = infoServiceBlockingStub.getStreamingResponseWIthUserInfo(
                UserService.UserInfo.newBuilder().setUsername("hello").setUserInfoId(-1).build()
        );
        while (responseWithUserInfo.hasNext()) {
            System.out.println(responseWithUserInfo.next());
        }
    }
}