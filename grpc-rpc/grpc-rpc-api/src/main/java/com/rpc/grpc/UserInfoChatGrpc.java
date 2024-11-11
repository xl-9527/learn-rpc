package com.rpc.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: user_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserInfoChatGrpc {

  private UserInfoChatGrpc() {}

  public static final java.lang.String SERVICE_NAME = "UserInfoChat";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.rpc.grpc.UserService.ChatMessage,
      com.rpc.grpc.UserService.ChatMessage> getStartChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startChat",
      requestType = com.rpc.grpc.UserService.ChatMessage.class,
      responseType = com.rpc.grpc.UserService.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.rpc.grpc.UserService.ChatMessage,
      com.rpc.grpc.UserService.ChatMessage> getStartChatMethod() {
    io.grpc.MethodDescriptor<com.rpc.grpc.UserService.ChatMessage, com.rpc.grpc.UserService.ChatMessage> getStartChatMethod;
    if ((getStartChatMethod = UserInfoChatGrpc.getStartChatMethod) == null) {
      synchronized (UserInfoChatGrpc.class) {
        if ((getStartChatMethod = UserInfoChatGrpc.getStartChatMethod) == null) {
          UserInfoChatGrpc.getStartChatMethod = getStartChatMethod =
              io.grpc.MethodDescriptor.<com.rpc.grpc.UserService.ChatMessage, com.rpc.grpc.UserService.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "startChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rpc.grpc.UserService.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new UserInfoChatMethodDescriptorSupplier("startChat"))
              .build();
        }
      }
    }
    return getStartChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserInfoChatStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoChatStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoChatStub>() {
        @java.lang.Override
        public UserInfoChatStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoChatStub(channel, callOptions);
        }
      };
    return UserInfoChatStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserInfoChatBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoChatBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoChatBlockingStub>() {
        @java.lang.Override
        public UserInfoChatBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoChatBlockingStub(channel, callOptions);
        }
      };
    return UserInfoChatBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserInfoChatFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserInfoChatFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserInfoChatFutureStub>() {
        @java.lang.Override
        public UserInfoChatFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserInfoChatFutureStub(channel, callOptions);
        }
      };
    return UserInfoChatFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.ChatMessage> startChat(
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.ChatMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStartChatMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserInfoChat.
   */
  public static abstract class UserInfoChatImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserInfoChatGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserInfoChat.
   */
  public static final class UserInfoChatStub
      extends io.grpc.stub.AbstractAsyncStub<UserInfoChatStub> {
    private UserInfoChatStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoChatStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoChatStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.ChatMessage> startChat(
        io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.ChatMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStartChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserInfoChat.
   */
  public static final class UserInfoChatBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserInfoChatBlockingStub> {
    private UserInfoChatBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoChatBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoChatBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserInfoChat.
   */
  public static final class UserInfoChatFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserInfoChatFutureStub> {
    private UserInfoChatFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserInfoChatFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserInfoChatFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_START_CHAT = 0;

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
        case METHODID_START_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.startChat(
              (io.grpc.stub.StreamObserver<com.rpc.grpc.UserService.ChatMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStartChatMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.rpc.grpc.UserService.ChatMessage,
              com.rpc.grpc.UserService.ChatMessage>(
                service, METHODID_START_CHAT)))
        .build();
  }

  private static abstract class UserInfoChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserInfoChatBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rpc.grpc.UserService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserInfoChat");
    }
  }

  private static final class UserInfoChatFileDescriptorSupplier
      extends UserInfoChatBaseDescriptorSupplier {
    UserInfoChatFileDescriptorSupplier() {}
  }

  private static final class UserInfoChatMethodDescriptorSupplier
      extends UserInfoChatBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserInfoChatMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserInfoChatGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserInfoChatFileDescriptorSupplier())
              .addMethod(getStartChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
