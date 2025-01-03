package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.grpc.DubboUserServiceTriple;
import com.rpc.dubbo.api.grpc.User;
import com.rpc.dubbo.api.grpc.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xl-9527
 * @since 2025/1/2
 **/
@Slf4j
@DubboService
public class UserServiceImpl extends DubboUserServiceTriple.UserServiceImplBase {

    @Override
    public void queryUserById(final UserRequest request, final StreamObserver<User> responseObserver) {
        log.info("queryUserById request user id -> {}", request.getUserId());
        try {
            responseObserver.onNext(User.newBuilder().setUserId(request.getUserId()).setUsername("xl-9527").build());
        } finally {
            responseObserver.onCompleted();
        }
    }
}
