package com.rpc.dubbo.api.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.0)",
    comments = "Source: TripleGrpcProtocol.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TripleGrpcProtocolServiceGrpc {

  private TripleGrpcProtocolServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TripleGrpcProtocolService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO,
      com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> getTestTripleGrpcProtocolServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "testTripleGrpcProtocolService",
      requestType = com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO.class,
      responseType = com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO,
      com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> getTestTripleGrpcProtocolServiceMethod() {
    io.grpc.MethodDescriptor<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO, com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> getTestTripleGrpcProtocolServiceMethod;
    if ((getTestTripleGrpcProtocolServiceMethod = TripleGrpcProtocolServiceGrpc.getTestTripleGrpcProtocolServiceMethod) == null) {
      synchronized (TripleGrpcProtocolServiceGrpc.class) {
        if ((getTestTripleGrpcProtocolServiceMethod = TripleGrpcProtocolServiceGrpc.getTestTripleGrpcProtocolServiceMethod) == null) {
          TripleGrpcProtocolServiceGrpc.getTestTripleGrpcProtocolServiceMethod = getTestTripleGrpcProtocolServiceMethod =
              io.grpc.MethodDescriptor.<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO, com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "testTripleGrpcProtocolService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO.getDefaultInstance()))
              .setSchemaDescriptor(new TripleGrpcProtocolServiceMethodDescriptorSupplier("testTripleGrpcProtocolService"))
              .build();
        }
      }
    }
    return getTestTripleGrpcProtocolServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TripleGrpcProtocolServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceStub>() {
        @java.lang.Override
        public TripleGrpcProtocolServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripleGrpcProtocolServiceStub(channel, callOptions);
        }
      };
    return TripleGrpcProtocolServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TripleGrpcProtocolServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceBlockingStub>() {
        @java.lang.Override
        public TripleGrpcProtocolServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripleGrpcProtocolServiceBlockingStub(channel, callOptions);
        }
      };
    return TripleGrpcProtocolServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TripleGrpcProtocolServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TripleGrpcProtocolServiceFutureStub>() {
        @java.lang.Override
        public TripleGrpcProtocolServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TripleGrpcProtocolServiceFutureStub(channel, callOptions);
        }
      };
    return TripleGrpcProtocolServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request,
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestTripleGrpcProtocolServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TripleGrpcProtocolService.
   */
  public static abstract class TripleGrpcProtocolServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TripleGrpcProtocolServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TripleGrpcProtocolService.
   */
  public static final class TripleGrpcProtocolServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TripleGrpcProtocolServiceStub> {
    private TripleGrpcProtocolServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripleGrpcProtocolServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripleGrpcProtocolServiceStub(channel, callOptions);
    }

    /**
     */
    public void testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request,
        io.grpc.stub.StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestTripleGrpcProtocolServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TripleGrpcProtocolService.
   */
  public static final class TripleGrpcProtocolServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TripleGrpcProtocolServiceBlockingStub> {
    private TripleGrpcProtocolServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripleGrpcProtocolServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripleGrpcProtocolServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO testTripleGrpcProtocolService(com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestTripleGrpcProtocolServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TripleGrpcProtocolService.
   */
  public static final class TripleGrpcProtocolServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TripleGrpcProtocolServiceFutureStub> {
    private TripleGrpcProtocolServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripleGrpcProtocolServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TripleGrpcProtocolServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO> testTripleGrpcProtocolService(
        com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestTripleGrpcProtocolServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST_TRIPLE_GRPC_PROTOCOL_SERVICE = 0;

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
        case METHODID_TEST_TRIPLE_GRPC_PROTOCOL_SERVICE:
          serviceImpl.testTripleGrpcProtocolService((com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO) request,
              (io.grpc.stub.StreamObserver<com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO>) responseObserver);
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
          getTestTripleGrpcProtocolServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceDTO,
              com.rpc.dubbo.api.proto.TripleGrpcProtocolServiceVO>(
                service, METHODID_TEST_TRIPLE_GRPC_PROTOCOL_SERVICE)))
        .build();
  }

  private static abstract class TripleGrpcProtocolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TripleGrpcProtocolServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.dubbo.api.proto.TripleGrpcProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TripleGrpcProtocolService");
    }
  }

  private static final class TripleGrpcProtocolServiceFileDescriptorSupplier
      extends TripleGrpcProtocolServiceBaseDescriptorSupplier {
    TripleGrpcProtocolServiceFileDescriptorSupplier() {}
  }

  private static final class TripleGrpcProtocolServiceMethodDescriptorSupplier
      extends TripleGrpcProtocolServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TripleGrpcProtocolServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TripleGrpcProtocolServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TripleGrpcProtocolServiceFileDescriptorSupplier())
              .addMethod(getTestTripleGrpcProtocolServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
