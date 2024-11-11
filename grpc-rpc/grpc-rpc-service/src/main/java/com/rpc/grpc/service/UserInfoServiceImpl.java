package com.rpc.grpc.service;

import com.rpc.grpc.UserInfoServiceGrpc;
import com.rpc.grpc.UserService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author xl-9527
 * @since 2024/11/7
 **/
public class UserInfoServiceImpl extends UserInfoServiceGrpc.UserInfoServiceImplBase {

    private final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public StreamObserver<UserService.UserInfo> batchGetUserInfo(final StreamObserver<UserService.UserInfoResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(final UserService.UserInfo userInfo) {
                log.info("accept data from client [username -> {}, user_id -> {}]", userInfo.getUsername(), userInfo.getUserInfoId());
            }

            @Override
            public void onError(final Throwable throwable) {
                log.error("an exception occurred during client and server interaction", throwable);
            }

            @Override
            public void onCompleted() {
                log.info("请求端 stream 结束");
                responseObserver.onNext(
                        UserService.UserInfoResponse.newBuilder()
                                .setUsername("Tom")
                                .setUserInfoId(9)
                                .build()
                );
                responseObserver.onCompleted();
            }
        };
    }

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

    @Override
    public void getStreamingResponseWIthUserInfo(final UserService.UserInfo request, final StreamObserver<UserService.UserInfoResponse> responseObserver) {
        final String username = request.getUsername();
        final int userInfoId = request.getUserInfoId();
        log.info("streaming 服务方法收到客户端的消息 username -> {}, userInfoId -> {}", username, userInfoId);

        // 开始分批分期的响应数据给哦客户端
        try {
            responseObserver.onNext(UserService.UserInfoResponse.newBuilder().setUserInfoId(1).setUsername(UUID.randomUUID().toString()).build());
            TimeUnit.SECONDS.sleep(1);
            log.info("开始发送第 [{}] 批", 2);
            responseObserver.onNext(UserService.UserInfoResponse.newBuilder().setUserInfoId(2).setUsername(UUID.randomUUID().toString()).build());
            TimeUnit.SECONDS.sleep(10);
            log.info("开始发送第 [{}] 批", 3);
            responseObserver.onNext(UserService.UserInfoResponse.newBuilder().setUserInfoId(3).setUsername(UUID.randomUUID().toString()).build());
            TimeUnit.SECONDS.sleep(1);
            log.info("开始发送第 [{}] 批", 4);
            responseObserver.onNext(UserService.UserInfoResponse.newBuilder().setUserInfoId(4).setUsername(UUID.randomUUID().toString()).build());
            TimeUnit.SECONDS.sleep(1);
            log.info("开始发送第 [{}] 批", 5);
            responseObserver.onNext(UserService.UserInfoResponse.newBuilder().setUserInfoId(5).setUsername(UUID.randomUUID().toString()).build());
        } catch (Exception e) {
            log.error("", e);
        } finally {
            responseObserver.onCompleted();
        }
    }
}
