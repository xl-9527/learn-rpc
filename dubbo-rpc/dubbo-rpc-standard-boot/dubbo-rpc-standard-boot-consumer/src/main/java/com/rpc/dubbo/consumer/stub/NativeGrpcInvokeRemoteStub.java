package com.rpc.dubbo.consumer.stub;

import com.rpc.dubbo.api.grpc.User;
import com.rpc.dubbo.api.grpc.UserRequest;
import com.rpc.dubbo.api.grpc.UserServiceGrpc;
import com.rpc.dubbo.consumer.stub.adaper.StreamObserverAdapter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author xl-9527
 * @since 2025/1/3
 **/
@Slf4j
public class NativeGrpcInvokeRemoteStub {

    private final ManagedChannel managedChannel;

    public NativeGrpcInvokeRemoteStub(final int port) {
        this.managedChannel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext().build();
    }

    public User getUserById(int id) {
        final User user = UserServiceGrpc.newBlockingStub(managedChannel)
                .queryUserById(
                        UserRequest.newBuilder().setUserId(id).build()
                );
        shutdown();
        return user;
    }

    public List<String> userLocalInfo(int userId) throws InterruptedException {
        final List<String> userNames = new ArrayList<>();
        final CountDownLatch downLatch = new CountDownLatch(1);
        final StreamObserver<UserRequest> userRequestStreamObserver = UserServiceGrpc.newStub(managedChannel)
                .userLocalInfo(new StreamObserver<>() {
                    final List<String> userName = new ArrayList<>();
                    @Override
                    public void onNext(final User value) {
                        userName.add(value.getUsername());
                        if (log.isInfoEnabled()) {
                            log.info("userLocalInfo response user name -> {}", value.getUsername());
                        }
                    }

                    @Override
                    public void onError(final Throwable t) {
                        if (log.isErrorEnabled()) {
                            log.error("userLocalInfo has exception", t);
                        }
                        downLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        userNames.addAll(userName);
                        downLatch.countDown();
                    }
                });

        // 发送请求
        userRequestStreamObserver.onNext(UserRequest.newBuilder().setUserId(userId).build());
        downLatch.await();
        shutdown();
        return userNames;
    }

    private void shutdown() {
        managedChannel.shutdown();
    }
}
