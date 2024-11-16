package com.rpc.grpc.service;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
public class BiServiceImpl extends BiRpcServiceGrpc.BiRpcServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(BiServiceImpl.class);

    @Override
    public void getOnceMessage(final BiService.OnceMessageRequest request, final StreamObserver<BiService.OnceMessageResponse> responseObserver) {
        log.warn("receive client msg, content -> {}", request.getContent());
        // 响应客户端消息
        try {
            responseObserver.onNext(
                    BiService.OnceMessageResponse.newBuilder()
                            .setContent(UUID.randomUUID().toString())
                            .build()
            );
        } finally {
            responseObserver.onCompleted();
        }
    }
}
