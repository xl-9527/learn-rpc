package com.rpc.grpc.client;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
public class GrpcFutureStubClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext().build();

        final BiRpcServiceGrpc.BiRpcServiceFutureStub futureStub = BiRpcServiceGrpc.newFutureStub(channel);
        final ListenableFuture<BiService.OnceMessageResponse> onceMessageResponse
                = futureStub.getOnceMessage(BiService.OnceMessageRequest.newBuilder().setContent(UUID.randomUUID().toString()).build());

        Futures.addCallback(onceMessageResponse, new FutureCallback<>() {
            @Override
            public void onSuccess(final BiService.OnceMessageResponse result) {
                System.out.println(result.getContent());
            }

            @Override
            public void onFailure(final Throwable t) {

            }
        }, Executors.newFixedThreadPool(1));

        System.out.println("i am is first running");
        Thread.sleep(30000);
    }
}
