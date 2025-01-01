/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

    package com.rpc.dubbo.api.grpc;

import org.apache.dubbo.common.URL;

import java.util.concurrent.TimeUnit;

import static org.apache.dubbo.common.constants.CommonConstants.DEFAULT_TIMEOUT;
import static org.apache.dubbo.common.constants.CommonConstants.TIMEOUT_KEY;

import static com.rpc.dubbo.api.grpc.UserServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public final class DubboUserServiceGrpc {
private DubboUserServiceGrpc() {}

public static class DubboUserServiceStub implements IUserService {

protected URL url;

protected UserServiceGrpc.UserServiceBlockingStub blockingStub;
protected UserServiceGrpc.UserServiceFutureStub futureStub;
protected UserServiceGrpc.UserServiceStub stub;

public DubboUserServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url) {
this.url = url;

blockingStub = UserServiceGrpc.newBlockingStub(channel).build(channel, callOptions);
futureStub = UserServiceGrpc.newFutureStub(channel).build(channel, callOptions);
stub = UserServiceGrpc.newStub(channel).build(channel, callOptions);
}

    public com.rpc.dubbo.api.grpc.UserServiceProto.User queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    return blockingStub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .queryUserById(request);
    }

    public com.google.common.util.concurrent.ListenableFuture<com.rpc.dubbo.api.grpc.UserServiceProto.User> queryUserByIdAsync(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    return futureStub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .queryUserById(request);
    }

    public void queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request, io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserServiceProto.User> responseObserver){
    stub
    .withDeadlineAfter(url.getParameter(TIMEOUT_KEY, DEFAULT_TIMEOUT), TimeUnit.MILLISECONDS)
    .queryUserById(request, responseObserver);
    }

}

public static DubboUserServiceStub getDubboStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions, URL url) {
return new DubboUserServiceStub(channel, callOptions, url);
}

public interface IUserService {
    default public com.rpc.dubbo.api.grpc.UserServiceProto.User queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

    default public com.google.common.util.concurrent.ListenableFuture<com.rpc.dubbo.api.grpc.UserServiceProto.User> queryUserByIdAsync(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

    public void queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request, io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserServiceProto.User> responseObserver);

}

public static abstract class UserServiceImplBase implements IUserService, io.grpc.BindableService {

private IUserService proxiedImpl;

public final void setProxiedImpl(IUserService proxiedImpl) {
this.proxiedImpl = proxiedImpl;
}

    @java.lang.Override
    public final com.rpc.dubbo.api.grpc.UserServiceProto.User queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

    @java.lang.Override
    public final com.google.common.util.concurrent.ListenableFuture<com.rpc.dubbo.api.grpc.UserServiceProto.User> queryUserByIdAsync(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request) {
    throw new UnsupportedOperationException("No need to override this method, extend XxxImplBase and override all methods it allows.");
    }

        public void queryUserById(com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest request,
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserServiceProto.User> responseObserver) {
        asyncUnimplementedUnaryCall(com.rpc.dubbo.api.grpc.UserServiceGrpc.getQueryUserByIdMethod(), responseObserver);
        }

@java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
    .addMethod(
    com.rpc.dubbo.api.grpc.UserServiceGrpc.getQueryUserByIdMethod(),
    asyncUnaryCall(
    new MethodHandlers<
    com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest,
    com.rpc.dubbo.api.grpc.UserServiceProto.User>(
    proxiedImpl, METHODID_QUERY_USER_BY_ID)))
.build();
}
}
    private static final int METHODID_QUERY_USER_BY_ID = 0;

private static final class MethodHandlers
<Req, Resp> implements
io.grpc.stub.ServerCalls.UnaryMethod
<Req, Resp>,
io.grpc.stub.ServerCalls.ServerStreamingMethod
<Req, Resp>,
io.grpc.stub.ServerCalls.ClientStreamingMethod
<Req, Resp>,
io.grpc.stub.ServerCalls.BidiStreamingMethod
<Req, Resp> {
private final IUserService serviceImpl;
private final int methodId;

MethodHandlers(IUserService serviceImpl, int methodId) {
this.serviceImpl = serviceImpl;
this.methodId = methodId;
}

@java.lang.Override
@java.lang.SuppressWarnings("unchecked")
public void invoke(Req request, io.grpc.stub.StreamObserver
<Resp> responseObserver) {
    switch (methodId) {
            case METHODID_QUERY_USER_BY_ID:
            serviceImpl.queryUserById((com.rpc.dubbo.api.grpc.UserServiceProto.UserRequest) request,
            (io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserServiceProto.User>) responseObserver);
            break;
    default:
    throw new java.lang.AssertionError();
    }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver
    <Req> invoke(io.grpc.stub.StreamObserver
        <Resp> responseObserver) {
            switch (methodId) {
            default:
            throw new java.lang.AssertionError();
            }
            }
            }

            }
