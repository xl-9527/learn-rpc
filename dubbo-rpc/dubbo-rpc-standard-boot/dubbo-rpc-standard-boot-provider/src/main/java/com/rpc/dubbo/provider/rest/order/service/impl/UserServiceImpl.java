package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.grpc.DubboUserServiceGrpc;
import com.rpc.dubbo.api.grpc.UserServiceProto;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xl-9527
 * @since 2025/1/2
 **/
@Slf4j
@DubboService
public class UserServiceImpl extends DubboUserServiceGrpc.UserServiceImplBase {

    @Override
    public void queryUserById(final UserServiceProto.UserRequest request, final StreamObserver<UserServiceProto.User> responseObserver) {
        log.info("queryUserById request user id -> {}", request.getUserId());
        responseObserver.onNext(UserServiceProto.User.newBuilder().setUsername("xl-9527").setUserId(request.getUserId()).build());
        responseObserver.onCompleted();
    }
}
