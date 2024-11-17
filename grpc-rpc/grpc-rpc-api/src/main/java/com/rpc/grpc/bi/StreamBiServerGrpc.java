package com.rpc.grpc.bi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: streaming_bi_server.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamBiServerGrpc {

  private StreamBiServerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "StreamBiServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq,
      com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp> getGetMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessages",
      requestType = com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq.class,
      responseType = com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq,
      com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp> getGetMessagesMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq, com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp> getGetMessagesMethod;
    if ((getGetMessagesMethod = StreamBiServerGrpc.getGetMessagesMethod) == null) {
      synchronized (StreamBiServerGrpc.class) {
        if ((getGetMessagesMethod = StreamBiServerGrpc.getGetMessagesMethod) == null) {
          StreamBiServerGrpc.getGetMessagesMethod = getGetMessagesMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq, com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp.getDefaultInstance()))
              .setSchemaDescriptor(new StreamBiServerMethodDescriptorSupplier("getMessages"))
              .build();
        }
      }
    }
    return getGetMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamBiServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamBiServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamBiServerStub>() {
        @java.lang.Override
        public StreamBiServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamBiServerStub(channel, callOptions);
        }
      };
    return StreamBiServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamBiServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamBiServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamBiServerBlockingStub>() {
        @java.lang.Override
        public StreamBiServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamBiServerBlockingStub(channel, callOptions);
        }
      };
    return StreamBiServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamBiServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamBiServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamBiServerFutureStub>() {
        @java.lang.Override
        public StreamBiServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamBiServerFutureStub(channel, callOptions);
        }
      };
    return StreamBiServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq> getMessages(
        io.grpc.stub.StreamObserver<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetMessagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamBiServer.
   */
  public static abstract class StreamBiServerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StreamBiServerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamBiServer.
   */
  public static final class StreamBiServerStub
      extends io.grpc.stub.AbstractAsyncStub<StreamBiServerStub> {
    private StreamBiServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamBiServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamBiServerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq> getMessages(
        io.grpc.stub.StreamObserver<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetMessagesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamBiServer.
   */
  public static final class StreamBiServerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamBiServerBlockingStub> {
    private StreamBiServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamBiServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamBiServerBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamBiServer.
   */
  public static final class StreamBiServerFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamBiServerFutureStub> {
    private StreamBiServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamBiServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamBiServerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_MESSAGES = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getMessages(
              (io.grpc.stub.StreamObserver<com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageReq,
              com.rpc.grpc.bi.StreamingBiServiceProto.StreamingBiMessageResp>(
                service, METHODID_GET_MESSAGES)))
        .build();
  }

  private static abstract class StreamBiServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamBiServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.grpc.bi.StreamingBiServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamBiServer");
    }
  }

  private static final class StreamBiServerFileDescriptorSupplier
      extends StreamBiServerBaseDescriptorSupplier {
    StreamBiServerFileDescriptorSupplier() {}
  }

  private static final class StreamBiServerMethodDescriptorSupplier
      extends StreamBiServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamBiServerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StreamBiServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamBiServerFileDescriptorSupplier())
              .addMethod(getGetMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
