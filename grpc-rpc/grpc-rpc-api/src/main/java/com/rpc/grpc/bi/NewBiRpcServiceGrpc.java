package com.rpc.grpc.bi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: bi_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NewBiRpcServiceGrpc {

  private NewBiRpcServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.rpc.grpc.bi.NewBiRpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.bi.BiService.OnceMessageRequest,
      com.rpc.grpc.bi.BiService.OnceMessageResponse> getNewGetOnceMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newGetOnceMessage",
      requestType = com.rpc.grpc.bi.BiService.OnceMessageRequest.class,
      responseType = com.rpc.grpc.bi.BiService.OnceMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.bi.BiService.OnceMessageRequest,
      com.rpc.grpc.bi.BiService.OnceMessageResponse> getNewGetOnceMessageMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.bi.BiService.OnceMessageRequest, com.rpc.grpc.bi.BiService.OnceMessageResponse> getNewGetOnceMessageMethod;
    if ((getNewGetOnceMessageMethod = NewBiRpcServiceGrpc.getNewGetOnceMessageMethod) == null) {
      synchronized (NewBiRpcServiceGrpc.class) {
        if ((getNewGetOnceMessageMethod = NewBiRpcServiceGrpc.getNewGetOnceMessageMethod) == null) {
          NewBiRpcServiceGrpc.getNewGetOnceMessageMethod = getNewGetOnceMessageMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.bi.BiService.OnceMessageRequest, com.rpc.grpc.bi.BiService.OnceMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "newGetOnceMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.bi.BiService.OnceMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.bi.BiService.OnceMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NewBiRpcServiceMethodDescriptorSupplier("newGetOnceMessage"))
              .build();
        }
      }
    }
    return getNewGetOnceMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NewBiRpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceStub>() {
        @java.lang.Override
        public NewBiRpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NewBiRpcServiceStub(channel, callOptions);
        }
      };
    return NewBiRpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NewBiRpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceBlockingStub>() {
        @java.lang.Override
        public NewBiRpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NewBiRpcServiceBlockingStub(channel, callOptions);
        }
      };
    return NewBiRpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NewBiRpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NewBiRpcServiceFutureStub>() {
        @java.lang.Override
        public NewBiRpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NewBiRpcServiceFutureStub(channel, callOptions);
        }
      };
    return NewBiRpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * 注意这里因为我们使用 future 的方式来通讯，这就不可以使用 stream，只能使用简单的 rpc
     * </pre>
     */
    default void newGetOnceMessage(com.rpc.grpc.bi.BiService.OnceMessageRequest request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.bi.BiService.OnceMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewGetOnceMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NewBiRpcService.
   */
  public static abstract class NewBiRpcServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return NewBiRpcServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NewBiRpcService.
   */
  public static final class NewBiRpcServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NewBiRpcServiceStub> {
    private NewBiRpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewBiRpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NewBiRpcServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注意这里因为我们使用 future 的方式来通讯，这就不可以使用 stream，只能使用简单的 rpc
     * </pre>
     */
    public void newGetOnceMessage(com.rpc.grpc.bi.BiService.OnceMessageRequest request,
        io.grpc.stub.StreamObserver<com.rpc.grpc.bi.BiService.OnceMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewGetOnceMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NewBiRpcService.
   */
  public static final class NewBiRpcServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NewBiRpcServiceBlockingStub> {
    private NewBiRpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewBiRpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NewBiRpcServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注意这里因为我们使用 future 的方式来通讯，这就不可以使用 stream，只能使用简单的 rpc
     * </pre>
     */
    public com.rpc.grpc.bi.BiService.OnceMessageResponse newGetOnceMessage(com.rpc.grpc.bi.BiService.OnceMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewGetOnceMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NewBiRpcService.
   */
  public static final class NewBiRpcServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NewBiRpcServiceFutureStub> {
    private NewBiRpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NewBiRpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NewBiRpcServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 注意这里因为我们使用 future 的方式来通讯，这就不可以使用 stream，只能使用简单的 rpc
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpc.grpc.bi.BiService.OnceMessageResponse> newGetOnceMessage(
        com.rpc.grpc.bi.BiService.OnceMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewGetOnceMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_GET_ONCE_MESSAGE = 0;

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
        case METHODID_NEW_GET_ONCE_MESSAGE:
          serviceImpl.newGetOnceMessage((com.rpc.grpc.bi.BiService.OnceMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.rpc.grpc.bi.BiService.OnceMessageResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getNewGetOnceMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rpc.grpc.bi.BiService.OnceMessageRequest,
              com.rpc.grpc.bi.BiService.OnceMessageResponse>(
                service, METHODID_NEW_GET_ONCE_MESSAGE)))
        .build();
  }

  private static abstract class NewBiRpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NewBiRpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.grpc.bi.BiService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NewBiRpcService");
    }
  }

  private static final class NewBiRpcServiceFileDescriptorSupplier
      extends NewBiRpcServiceBaseDescriptorSupplier {
    NewBiRpcServiceFileDescriptorSupplier() {}
  }

  private static final class NewBiRpcServiceMethodDescriptorSupplier
      extends NewBiRpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NewBiRpcServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NewBiRpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NewBiRpcServiceFileDescriptorSupplier())
              .addMethod(getNewGetOnceMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
