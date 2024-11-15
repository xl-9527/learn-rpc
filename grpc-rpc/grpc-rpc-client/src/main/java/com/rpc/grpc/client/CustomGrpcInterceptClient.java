package com.rpc.grpc.client;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import com.rpc.grpc.client.intercept.CustomGrpcIntercept;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author xl-9527
 * @since 2024/11/14
 **/
public class CustomGrpcInterceptClient {

    public static void main(String[] args) {
        handler();
    }

    private static void handler() {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .intercept(new CustomGrpcIntercept())
                .build();

        BiRpcServiceGrpc.BiRpcServiceBlockingStub biRpcServiceBlockingStub = BiRpcServiceGrpc.newBlockingStub(channel);
        BiService.OnceMessageResponse messageResponse = biRpcServiceBlockingStub.getOnceMessage(
                BiService.OnceMessageRequest.newBuilder().setContent("你好").build()
        );
        System.out.println(messageResponse.getContent());
    }
}
