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

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.PathResolver;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.ServerService;
import org.apache.dubbo.rpc.TriRpcStatus;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.ServiceDescriptor;
import org.apache.dubbo.rpc.model.StubMethodDescriptor;
import org.apache.dubbo.rpc.model.StubServiceDescriptor;
import org.apache.dubbo.rpc.stub.BiStreamMethodHandler;
import org.apache.dubbo.rpc.stub.ServerStreamMethodHandler;
import org.apache.dubbo.rpc.stub.StubInvocationUtil;
import org.apache.dubbo.rpc.stub.StubInvoker;
import org.apache.dubbo.rpc.stub.StubMethodHandler;
import org.apache.dubbo.rpc.stub.StubSuppliers;
import org.apache.dubbo.rpc.stub.UnaryStubMethodHandler;

import com.google.protobuf.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;

public final class DubboUserServiceTriple {

    public static final String SERVICE_NAME = UserService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,UserService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,UserServiceProto.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboUserServiceTriple::newStub);
        StubSuppliers.addSupplier(UserService.JAVA_SERVICE_NAME,  DubboUserServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(UserService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static UserService newStub(Invoker<?> invoker) {
        return new UserServiceStub((Invoker<UserService>)invoker);
    }

    private static final StubMethodDescriptor queryUserByIdMethod = new StubMethodDescriptor("queryUserById",
    com.rpc.dubbo.api.grpc.UserRequest.class, com.rpc.dubbo.api.grpc.User.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.grpc.UserRequest::parseFrom,
    com.rpc.dubbo.api.grpc.User::parseFrom);

    private static final StubMethodDescriptor queryUserByIdAsyncMethod = new StubMethodDescriptor("queryUserById",
    com.rpc.dubbo.api.grpc.UserRequest.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.grpc.UserRequest::parseFrom,
    com.rpc.dubbo.api.grpc.User::parseFrom);

    private static final StubMethodDescriptor queryUserByIdProxyAsyncMethod = new StubMethodDescriptor("queryUserByIdAsync",
    com.rpc.dubbo.api.grpc.UserRequest.class, com.rpc.dubbo.api.grpc.User.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.grpc.UserRequest::parseFrom,
    com.rpc.dubbo.api.grpc.User::parseFrom);




    static{
        serviceDescriptor.addMethod(queryUserByIdMethod);
        serviceDescriptor.addMethod(queryUserByIdProxyAsyncMethod);
    }

    public static class UserServiceStub implements UserService{
        private final Invoker<UserService> invoker;

        public UserServiceStub(Invoker<UserService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.rpc.dubbo.api.grpc.User queryUserById(com.rpc.dubbo.api.grpc.UserRequest request){
            return StubInvocationUtil.unaryCall(invoker, queryUserByIdMethod, request);
        }

        public CompletableFuture<com.rpc.dubbo.api.grpc.User> queryUserByIdAsync(com.rpc.dubbo.api.grpc.UserRequest request){
            return StubInvocationUtil.unaryCall(invoker, queryUserByIdAsyncMethod, request);
        }

        public void queryUserById(com.rpc.dubbo.api.grpc.UserRequest request, StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver){
            StubInvocationUtil.unaryCall(invoker, queryUserByIdMethod , request, responseObserver);
        }



    }

    public static abstract class UserServiceImplBase implements UserService, ServerService<UserService> {

        private <T, R> BiConsumer<T, StreamObserver<R>> syncToAsync(java.util.function.Function<T, R> syncFun) {
            return new BiConsumer<T, StreamObserver<R>>() {
                @Override
                public void accept(T t, StreamObserver<R> observer) {
                    try {
                        R ret = syncFun.apply(t);
                        observer.onNext(ret);
                        observer.onCompleted();
                    } catch (Throwable e) {
                        observer.onError(e);
                    }
                }
            };
        }

        @Override
        public CompletableFuture<com.rpc.dubbo.api.grpc.User> queryUserByIdAsync(com.rpc.dubbo.api.grpc.UserRequest request){
                return CompletableFuture.completedFuture(queryUserById(request));
        }

        /**
        * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
        * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
        */
        public void queryUserById(com.rpc.dubbo.api.grpc.UserRequest request, StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver){
            queryUserByIdAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }

        @Override
        public final Invoker<UserService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/queryUserById" );
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/queryUserByIdAsync" );

            BiConsumer<com.rpc.dubbo.api.grpc.UserRequest, StreamObserver<com.rpc.dubbo.api.grpc.User>> queryUserByIdFunc = this::queryUserById;
            handlers.put(queryUserByIdMethod.getMethodName(), new UnaryStubMethodHandler<>(queryUserByIdFunc));
            BiConsumer<com.rpc.dubbo.api.grpc.UserRequest, StreamObserver<com.rpc.dubbo.api.grpc.User>> queryUserByIdAsyncFunc = syncToAsync(this::queryUserById);
            handlers.put(queryUserByIdProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(queryUserByIdAsyncFunc));




            return new StubInvoker<>(this, url, UserService.class, handlers);
        }


        @Override
        public com.rpc.dubbo.api.grpc.User queryUserById(com.rpc.dubbo.api.grpc.UserRequest request){
            throw unimplementedMethodException(queryUserByIdMethod);
        }





        @Override
        public final ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }
        private RpcException unimplementedMethodException(StubMethodDescriptor methodDescriptor) {
            return TriRpcStatus.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented",
                "/" + serviceDescriptor.getInterfaceName() + "/" + methodDescriptor.getMethodName())).asException();
        }
    }

}
