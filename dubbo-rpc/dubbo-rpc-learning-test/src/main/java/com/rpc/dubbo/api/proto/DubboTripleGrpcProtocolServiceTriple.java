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

package com.rpc.dubbo.api.proto;

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

public final class DubboTripleGrpcProtocolServiceTriple {

    public static final String SERVICE_NAME = TripleGrpcProtocolService.SERVICE_NAME;

    private static final StubServiceDescriptor serviceDescriptor = new StubServiceDescriptor(SERVICE_NAME,TripleGrpcProtocolService.class);

    static {
        org.apache.dubbo.rpc.protocol.tri.service.SchemaDescriptorRegistry.addSchemaDescriptor(SERVICE_NAME,TripleGrpcProtocol.getDescriptor());
        StubSuppliers.addSupplier(SERVICE_NAME, DubboTripleGrpcProtocolServiceTriple::newStub);
        StubSuppliers.addSupplier(TripleGrpcProtocolService.JAVA_SERVICE_NAME,  DubboTripleGrpcProtocolServiceTriple::newStub);
        StubSuppliers.addDescriptor(SERVICE_NAME, serviceDescriptor);
        StubSuppliers.addDescriptor(TripleGrpcProtocolService.JAVA_SERVICE_NAME, serviceDescriptor);
    }

    @SuppressWarnings("all")
    public static TripleGrpcProtocolService newStub(Invoker<?> invoker) {
        return new TripleGrpcProtocolServiceStub((Invoker<TripleGrpcProtocolService>)invoker);
    }

    private static final StubMethodDescriptor testTripleGrpcProtocolServiceMethod = new StubMethodDescriptor("testTripleGrpcProtocolService",
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO.class, com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO::parseFrom,
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO::parseFrom);

    private static final StubMethodDescriptor testTripleGrpcProtocolServiceAsyncMethod = new StubMethodDescriptor("testTripleGrpcProtocolService",
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO.class, java.util.concurrent.CompletableFuture.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO::parseFrom,
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO::parseFrom);

    private static final StubMethodDescriptor testTripleGrpcProtocolServiceProxyAsyncMethod = new StubMethodDescriptor("testTripleGrpcProtocolServiceAsync",
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO.class, com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO.class, MethodDescriptor.RpcType.UNARY,
    obj -> ((Message) obj).toByteArray(), obj -> ((Message) obj).toByteArray(), com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO::parseFrom,
    com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO::parseFrom);




    static{
        serviceDescriptor.addMethod(testTripleGrpcProtocolServiceMethod);
        serviceDescriptor.addMethod(testTripleGrpcProtocolServiceProxyAsyncMethod);
    }

    public static class TripleGrpcProtocolServiceStub implements TripleGrpcProtocolService{
        private final Invoker<TripleGrpcProtocolService> invoker;

        public TripleGrpcProtocolServiceStub(Invoker<TripleGrpcProtocolService> invoker) {
            this.invoker = invoker;
        }

        @Override
        public com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request){
            return StubInvocationUtil.unaryCall(invoker, testTripleGrpcProtocolServiceMethod, request);
        }

        public CompletableFuture<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> testTripleGrpcProtocolServiceAsync(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request){
            return StubInvocationUtil.unaryCall(invoker, testTripleGrpcProtocolServiceAsyncMethod, request);
        }

        public void testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request, StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> responseObserver){
            StubInvocationUtil.unaryCall(invoker, testTripleGrpcProtocolServiceMethod , request, responseObserver);
        }



    }

    public static abstract class TripleGrpcProtocolServiceImplBase implements TripleGrpcProtocolService, ServerService<TripleGrpcProtocolService> {

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
        public CompletableFuture<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> testTripleGrpcProtocolServiceAsync(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request){
                return CompletableFuture.completedFuture(testTripleGrpcProtocolService(request));
        }

        /**
        * This server stream type unary method is <b>only</b> used for generated stub to support async unary method.
        * It will not be called if you are NOT using Dubbo3 generated triple stub and <b>DO NOT</b> implement this method.
        */
        public void testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request, StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> responseObserver){
            testTripleGrpcProtocolServiceAsync(request).whenComplete((r, t) -> {
                if (t != null) {
                    responseObserver.onError(t);
                } else {
                    responseObserver.onNext(r);
                    responseObserver.onCompleted();
                }
            });
        }

        @Override
        public final Invoker<TripleGrpcProtocolService> getInvoker(URL url) {
            PathResolver pathResolver = url.getOrDefaultFrameworkModel()
            .getExtensionLoader(PathResolver.class)
            .getDefaultExtension();
            Map<String,StubMethodHandler<?, ?>> handlers = new HashMap<>();

            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/testTripleGrpcProtocolService");
            pathResolver.addNativeStub( "/" + SERVICE_NAME + "/testTripleGrpcProtocolServiceAsync");
            // for compatibility
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/testTripleGrpcProtocolService");
            pathResolver.addNativeStub( "/" + JAVA_SERVICE_NAME + "/testTripleGrpcProtocolServiceAsync");


            BiConsumer<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO, StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO>> testTripleGrpcProtocolServiceFunc = this::testTripleGrpcProtocolService;
            handlers.put(testTripleGrpcProtocolServiceMethod.getMethodName(), new UnaryStubMethodHandler<>(testTripleGrpcProtocolServiceFunc));
            BiConsumer<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO, StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO>> testTripleGrpcProtocolServiceAsyncFunc = syncToAsync(this::testTripleGrpcProtocolService);
            handlers.put(testTripleGrpcProtocolServiceProxyAsyncMethod.getMethodName(), new UnaryStubMethodHandler<>(testTripleGrpcProtocolServiceAsyncFunc));




            return new StubInvoker<>(this, url, TripleGrpcProtocolService.class, handlers);
        }


        @Override
        public com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request){
            throw unimplementedMethodException(testTripleGrpcProtocolServiceMethod);
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
