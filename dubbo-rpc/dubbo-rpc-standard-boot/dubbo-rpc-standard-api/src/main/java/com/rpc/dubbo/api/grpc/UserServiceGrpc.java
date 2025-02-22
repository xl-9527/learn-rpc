package com.rpc.dubbo.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: UserServiceProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.rpc.dubbo.api.grpc.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest,
      com.rpc.dubbo.api.grpc.User> getQueryUserByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryUserById",
      requestType = com.rpc.dubbo.api.grpc.UserRequest.class,
      responseType = com.rpc.dubbo.api.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest,
      com.rpc.dubbo.api.grpc.User> getQueryUserByIdMethod() {
    io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest, com.rpc.dubbo.api.grpc.User> getQueryUserByIdMethod;
    if ((getQueryUserByIdMethod = UserServiceGrpc.getQueryUserByIdMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getQueryUserByIdMethod = UserServiceGrpc.getQueryUserByIdMethod) == null) {
          UserServiceGrpc.getQueryUserByIdMethod = getQueryUserByIdMethod =
              io.grpc.MethodDescriptor.<com.rpc.dubbo.api.grpc.UserRequest, com.rpc.dubbo.api.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "queryUserById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.grpc.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.grpc.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("queryUserById"))
              .build();
        }
      }
    }
    return getQueryUserByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest,
      com.rpc.dubbo.api.grpc.User> getUserLocalInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "userLocalInfo",
      requestType = com.rpc.dubbo.api.grpc.UserRequest.class,
      responseType = com.rpc.dubbo.api.grpc.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest,
      com.rpc.dubbo.api.grpc.User> getUserLocalInfoMethod() {
    io.grpc.MethodDescriptor<com.rpc.dubbo.api.grpc.UserRequest, com.rpc.dubbo.api.grpc.User> getUserLocalInfoMethod;
    if ((getUserLocalInfoMethod = UserServiceGrpc.getUserLocalInfoMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUserLocalInfoMethod = UserServiceGrpc.getUserLocalInfoMethod) == null) {
          UserServiceGrpc.getUserLocalInfoMethod = getUserLocalInfoMethod =
              io.grpc.MethodDescriptor.<com.rpc.dubbo.api.grpc.UserRequest, com.rpc.dubbo.api.grpc.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "userLocalInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.grpc.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.grpc.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("userLocalInfo"))
              .build();
        }
      }
    }
    return getUserLocalInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 一元 RPC
     * </pre>
     */
    default void queryUserById(com.rpc.dubbo.api.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryUserByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * 测试流式
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserRequest> userLocalInfo(
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUserLocalInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   */
  public static abstract class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC
     * </pre>
     */
    public void queryUserById(com.rpc.dubbo.api.grpc.UserRequest request,
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryUserByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 测试流式
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.UserRequest> userLocalInfo(
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getUserLocalInfoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC
     * </pre>
     */
    public com.rpc.dubbo.api.grpc.User queryUserById(com.rpc.dubbo.api.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryUserByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一元 RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpc.dubbo.api.grpc.User> queryUserById(
        com.rpc.dubbo.api.grpc.UserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryUserByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_USER_BY_ID = 0;
  private static final int METHODID_USER_LOCAL_INFO = 1;

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
        case METHODID_QUERY_USER_BY_ID:
          serviceImpl.queryUserById((com.rpc.dubbo.api.grpc.UserRequest) request,
              (io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User>) responseObserver);
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
        case METHODID_USER_LOCAL_INFO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.userLocalInfo(
              (io.grpc.stub.StreamObserver<com.rpc.dubbo.api.grpc.User>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getQueryUserByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rpc.dubbo.api.grpc.UserRequest,
              com.rpc.dubbo.api.grpc.User>(
                service, METHODID_QUERY_USER_BY_ID)))
        .addMethod(
          getUserLocalInfoMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.rpc.dubbo.api.grpc.UserRequest,
              com.rpc.dubbo.api.grpc.User>(
                service, METHODID_USER_LOCAL_INFO)))
        .build();
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.dubbo.api.grpc.UserServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getQueryUserByIdMethod())
              .addMethod(getUserLocalInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
