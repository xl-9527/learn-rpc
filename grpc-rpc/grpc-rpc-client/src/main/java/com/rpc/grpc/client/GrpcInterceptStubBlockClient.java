package com.rpc.grpc.client;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import com.rpc.grpc.client.intercept.CustomGrpcIntercept;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2024/11/14
 **/
public class GrpcInterceptStubBlockClient {

    public static void main(String[] args) {
        final ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8888).usePlaintext().intercept(new CustomGrpcIntercept())
                .build();

        final BiRpcServiceGrpc.BiRpcServiceBlockingStub stub = BiRpcServiceGrpc.newBlockingStub(managedChannel);
        final BiService.OnceMessageResponse messageResponse = stub.getOnceMessage(
                BiService.OnceMessageRequest.newBuilder()
                        .setContent(UUID.randomUUID().toString()).build()
        );

        System.out.printf("%s\n", messageResponse.getContent());
    }
}
