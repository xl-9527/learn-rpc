package com.rpc.grpc.service;

import com.rpc.grpc.bi.BiService;
import com.rpc.grpc.bi.NewBiRpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
public class NewBiServiceImpl extends NewBiRpcServiceGrpc.NewBiRpcServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(NewBiServiceImpl.class);

    @Override
    public void newGetOnceMessage(final BiService.OnceMessageRequest request,
                                  final StreamObserver<BiService.OnceMessageResponse> responseObserver) {
        log.info("receive server info from client -> {}", request.getContent());

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
