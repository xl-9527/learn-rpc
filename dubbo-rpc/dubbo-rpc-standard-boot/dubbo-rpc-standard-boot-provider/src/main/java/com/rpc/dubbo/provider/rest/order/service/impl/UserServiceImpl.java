package com.rpc.dubbo.provider.rest.order.service.impl;

import com.rpc.dubbo.api.grpc.DubboUserServiceTriple;
import com.rpc.dubbo.api.grpc.User;
import com.rpc.dubbo.api.grpc.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.context.annotation.Profile;

/**
 * @author xl-9527
 * @since 2025/1/2
 **/
@Slf4j
@DubboService
@Profile({"grpc", "triple"})
public class UserServiceImpl extends DubboUserServiceTriple.UserServiceImplBase {

    /**
     * single rpc
     */
    @Override
    public void queryUserById(final UserRequest request, final StreamObserver<User> responseObserver) {
        log.info("queryUserById request user id -> {}", request.getUserId());
        try {
            responseObserver.onNext(User.newBuilder().setUserId(request.getUserId()).setUsername("xl-9527").build());
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<UserRequest> userLocalInfo(final StreamObserver<User> responseObserver) {
        responseObserver.onNext(User.newBuilder().setUserId(1).setUsername("xl-9527").build());
        responseObserver.onNext(User.newBuilder().setUserId(2).setUsername("linus").build());
        responseObserver.onNext(User.newBuilder().setUserId(3).setUsername("trump").build());
        responseObserver.onCompleted();
        return new StreamObserver<>() {
            @Override
            public void onNext(final UserRequest data) {
                log.info("userLocalInfo request user id -> {}", data.getUserId());
            }

            @Override
            public void onError(final Throwable throwable) {
                log.error("has exception", throwable);
            }

            @Override
            public void onCompleted() {
                log.info("userLocalInfo request completed");
            }
        };
    }
}
