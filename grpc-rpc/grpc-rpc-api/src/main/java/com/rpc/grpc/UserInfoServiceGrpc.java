package com.rpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: user_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserInfoServiceGrpc {

  private UserInfoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "UserInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserInfo",
      requestType = com.rpc.grpc.UserService.UserInfo.class,
      responseType = com.rpc.grpc.UserService.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getGetUserInfoMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse> getGetUserInfoMethod;
    if ((getGetUserInfoMethod = UserInfoServiceGrpc.getGetUserInfoMethod) == null) {
      synchronized (UserInfoServiceGrpc.class) {
        if ((getGetUserInfoMethod = UserInfoServiceGrpc.getGetUserInfoMethod) == null) {
          UserInfoServiceGrpc.getGetUserInfoMethod = getGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServiceMethodDescriptorSupplier("getUserInfo"))
              .build();
        }
      }
    }
    return getGetUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getGetStreamingResponseWIthUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStreamingResponseWIthUserInfo",
      requestType = com.rpc.grpc.UserService.UserInfo.class,
      responseType = com.rpc.grpc.UserService.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getGetStreamingResponseWIthUserInfoMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse> getGetStreamingResponseWIthUserInfoMethod;
    if ((getGetStreamingResponseWIthUserInfoMethod = UserInfoServiceGrpc.getGetStreamingResponseWIthUserInfoMethod) == null) {
      synchronized (UserInfoServiceGrpc.class) {
        if ((getGetStreamingResponseWIthUserInfoMethod = UserInfoServiceGrpc.getGetStreamingResponseWIthUserInfoMethod) == null) {
          UserInfoServiceGrpc.getGetStreamingResponseWIthUserInfoMethod = getGetStreamingResponseWIthUserInfoMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStreamingResponseWIthUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServiceMethodDescriptorSupplier("getStreamingResponseWIthUserInfo"))
              .build();
        }
      }
    }
    return getGetStreamingResponseWIthUserInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getBatchGetUserInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "batchGetUserInfo",
      requestType = com.rpc.grpc.UserService.UserInfo.class,
      responseType = com.rpc.grpc.UserService.UserInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo,
      com.rpc.grpc.UserService.UserInfoResponse> getBatchGetUserInfoMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse> getBatchGetUserInfoMethod;
    if ((getBatchGetUserInfoMethod = UserInfoServiceGrpc.getBatchGetUserInfoMethod) == null) {
      synchronized (UserInfoServiceGrpc.class) {
        if ((getBatchGetUserInfoMethod = UserInfoServiceGrpc.getBatchGetUserInfoMethod) == null) {
          UserInfoServiceGrpc.getBatchGetUserInfoMethod = getBatchGetUserInfoMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.UserService.UserInfo, com.rpc.grpc.UserService.UserInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "batchGetUserInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.UserInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoServiceMethodDescriptorSupplier("batchGetUserInfo"))
              .build();
        }
      }
    }
    return getBatchGetUserInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceStub>() {
        @java.lang.Override
        public UserInfoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServiceStub(channel, callOptions);
        }
      };
    return UserInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceBlockingStub>() {
        @java.lang.Override
        public UserInfoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServiceBlockingStub(channel, callOptions);
        }
      };
    return UserInfoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoServiceFutureStub>() {
        @java.lang.Override
        public UserInfoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoServiceFutureStub(channel, callOptions);
        }
      };
    return UserInfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getUserInfo(com.rpc.grpc.UserService.UserInfo request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserInfoMethod(), responseObserver);
    }

    /**
     */
    default void getStreamingResponseWIthUserInfo(com.rpc.grpc.UserService.UserInfo request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStreamingResponseWIthUserInfoMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfo> batchGetUserInfo(
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBatchGetUserInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserInfoService.
   */
  public static abstract class UserInfoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserInfoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserInfoService.
   */
  public static final class UserInfoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserInfoServiceStub> {
    private UserInfoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserInfo(com.rpc.grpc.UserService.UserInfo request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStreamingResponseWIthUserInfo(com.rpc.grpc.UserService.UserInfo request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetStreamingResponseWIthUserInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfo> batchGetUserInfo(
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBatchGetUserInfoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserInfoService.
   */
  public static final class UserInfoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserInfoServiceBlockingStub> {
    private UserInfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpc.grpc.UserService.UserInfoResponse getUserInfo(com.rpc.grpc.UserService.UserInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.rpc.grpc.UserService.UserInfoResponse> getStreamingResponseWIthUserInfo(
        com.rpc.grpc.UserService.UserInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetStreamingResponseWIthUserInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserInfoService.
   */
  public static final class UserInfoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserInfoServiceFutureStub> {
    private UserInfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpc.grpc.UserService.UserInfoResponse> getUserInfo(
        com.rpc.grpc.UserService.UserInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_INFO = 0;
  private static final int METHODID_GET_STREAMING_RESPONSE_WITH_USER_INFO = 1;
  private static final int METHODID_BATCH_GET_USER_INFO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_INFO:
          serviceImpl.getUserInfo((com.rpc.grpc.UserService.UserInfo) request,
              (io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse>) responseObserver);
          break;
        case METHODID_GET_STREAMING_RESPONSE_WITH_USER_INFO:
          serviceImpl.getStreamingResponseWIthUserInfo((com.rpc.grpc.UserService.UserInfo) request,
              (io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BATCH_GET_USER_INFO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.batchGetUserInfo(
              (io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.UserInfoResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetUserInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rpc.grpc.UserService.UserInfo,
              com.rpc.grpc.UserService.UserInfoResponse>(
                service, METHODID_GET_USER_INFO)))
        .addMethod(
          getGetStreamingResponseWIthUserInfoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.rpc.grpc.UserService.UserInfo,
              com.rpc.grpc.UserService.UserInfoResponse>(
                service, METHODID_GET_STREAMING_RESPONSE_WITH_USER_INFO)))
        .addMethod(
          getBatchGetUserInfoMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.rpc.grpc.UserService.UserInfo,
              com.rpc.grpc.UserService.UserInfoResponse>(
                service, METHODID_BATCH_GET_USER_INFO)))
        .build();
  }

  private static abstract class UserInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.grpc.UserService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserInfoService");
    }
  }

  private static final class UserInfoServiceFileDescriptorSupplier
      extends UserInfoServiceBaseDescriptorSupplier {
    UserInfoServiceFileDescriptorSupplier() {}
  }

  private static final class UserInfoServiceMethodDescriptorSupplier
      extends UserInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserInfoServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserInfoServiceFileDescriptorSupplier())
              .addMethod(getGetUserInfoMethod())
              .addMethod(getGetStreamingResponseWIthUserInfoMethod())
              .addMethod(getBatchGetUserInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
