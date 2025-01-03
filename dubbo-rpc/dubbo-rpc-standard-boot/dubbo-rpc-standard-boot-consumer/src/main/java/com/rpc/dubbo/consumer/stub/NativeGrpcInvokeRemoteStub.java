package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.grpc.User;
import com.rpc.dubbo.api.grpc.UserRequest;
import com.rpc.dubbo.api.grpc.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author xl-9527
 * @since 2025/1/3
 **/
public class NativeGrpcInvokeRemoteStub {

    private final ManagedChannel managedChannel;

    public NativeGrpcInvokeRemoteStub(final int port) {
        this.managedChannel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext().build();
    }

    public User getUserById(int id) {
        return UserServiceGrpc.newBlockingStub(managedChannel)
                .queryUserById(
                        UserRequest.newBuilder().setUserId(id).build()
                );
    }
}
