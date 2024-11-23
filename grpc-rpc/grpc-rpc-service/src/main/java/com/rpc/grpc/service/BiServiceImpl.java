package com.rpc.grpc.service;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
public class BiServiceImpl extends BiRpcServiceGrpc.BiRpcServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(BiServiceImpl.class);

    @Override
    public void getOnceMessage(final BiService.OnceMessageRequest request, final StreamObserver<BiService.OnceMessageResponse> responseObserver) {
        log.info("receive client msg, content -> {}", request.getContent());
        // 响应客户端消息
        final int nextInt = Random.from(RandomGenerator.getDefault()).nextInt(100);
        log.info("随机数 -> {}", nextInt);
        if (nextInt > 50) {
            log.error("虽残志坚");
            responseObserver.onError(Status.UNAVAILABLE.withDescription("发生了异常但是我是会重新尝试的").asRuntimeException());
        } else {
            log.info("响应成功了");
            responseObserver.onNext(
                    BiService.OnceMessageResponse.newBuilder()
                            .setContent(UUID.randomUUID().toString())
                            .build()
            );
        }
        responseObserver.onCompleted();
    }
}
