package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.grpc.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xl-9527
 * @since 2025/1/3
 **/
@Slf4j
class NativeGrpcInvokeRemoteStubTest {

    private final NativeGrpcInvokeRemoteStub stub = new NativeGrpcInvokeRemoteStub(50051);

    @Test
    void getUserById() {
        final User user = stub.getUserById(1);
        log.info("username: {}", user.getUsername());
        log.info("userId: {}", user.getUserId());
    }

    @Test
    void userLocalInfo() throws InterruptedException {
        stub.userLocalInfo(1).forEach(user -> log.info("username is: {}", user));
    }
}