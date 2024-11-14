package com.rpc.grpc.rpc.service;

import com.rpc.grpc.bi.BiRpcServiceGrpc;
import com.rpc.grpc.bi.BiService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xl-9527
 * @since 2024/11/12
 **/
@GrpcService
public class OnceMessageServiceImpl extends BiRpcServiceGrpc.BiRpcServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(OnceMessageServiceImpl.class);

    @Override
    public void getOnceMessage(final BiService.OnceMessageRequest request, final StreamObserver<BiService.OnceMessageResponse> responseObserver) {
        log.info("receive client request msg -> {}", request.getContent());
        responseObserver.onNext(
                BiService.OnceMessageResponse.newBuilder().setContent("我收到了你的消息 -> 【" + request.getContent() + "】").build()
        );
        responseObserver.onCompleted();
    }
}
