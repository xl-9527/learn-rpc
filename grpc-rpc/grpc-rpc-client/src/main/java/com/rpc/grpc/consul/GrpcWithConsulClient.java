package com.rpc.grpc.consul;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import com.rpc.grpc.client.retry.RetryConfig;
import com.rpc.grpc.consul.resolver.CustomConsulNamingResolverProvider;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolverRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author xl-9527
 * @since 2024/11/24
 **/
@Slf4j
public class GrpcWithConsulClient {

    public static void main(String[] args) throws InterruptedException {
        NameResolverRegistry.getDefaultRegistry().register(new CustomConsulNamingResolverProvider());

        // 引入自定义的命名解析器
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("bi-server")
                .usePlaintext().defaultLoadBalancingPolicy("round_robin")
                .defaultServiceConfig(RetryConfig.getRetryConfig()).enableRetry()
                .build();

        BiRpcServiceGrpc.BiRpcServiceBlockingStub biRpcServiceBlockingStub = BiRpcServiceGrpc.newBlockingStub(channel);

        for (int i = 0; i < 100; i++) {
            try {
                final BiService.OnceMessageResponse onceMessage = biRpcServiceBlockingStub.getOnceMessage(BiService.OnceMessageRequest.newBuilder().setContent("你好").build());
                System.out.println(onceMessage.getContent());
            } catch (Exception e) {
                log.error("", e);
            }
        }

        channel.awaitTermination(100, TimeUnit.SECONDS);
    }
}
