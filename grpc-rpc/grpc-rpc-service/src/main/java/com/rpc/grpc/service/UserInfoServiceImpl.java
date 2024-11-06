package com.rpc.grpc.service;

import com.rpc.grpc.UserInfoServiceGrpc;
import com.rpc.grpc.UserService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author xl-9527
 * @since 2024/11/7
 **/
public class UserInfoServiceImpl extends UserInfoServiceGrpc.UserInfoServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public void getUserInfo(final UserService.UserInfo request, final StreamObserver<UserService.UserInfoResponse> responseObserver) {
        final int userInfoId = request.getUserInfoId();
        final String username = request.getUsername();
        log.info("userInfoId is {}, username is {}", userInfoId, username);

        // 封装响应
        final UserService.UserInfoResponse.Builder builder = UserService.UserInfoResponse.newBuilder();
        builder.setUserInfoId(1)
                .addAllUserInfoRole(
                        List.of(
                                UserService.UserInfoResponse.UserInfoRole.newBuilder().setRoleId(0).setRoleName("队长").build(),
                                UserService.UserInfoResponse.UserInfoRole.newBuilder().setRoleId(0).setRoleName("bi队长").build(),
                                UserService.UserInfoResponse.UserInfoRole.newBuilder().setRoleId(0).setRoleName("秘书处处长").build()
                        )
                )
                .setUsername("hhhh");

        // 响应封装的数据
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
