// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserServiceProto.proto

package com.rpc.dubbo.api.grpc;

public final class UserServiceProto {
  private UserServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_rpc_dubbo_api_grpc_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_rpc_dubbo_api_grpc_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_rpc_dubbo_api_grpc_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_rpc_dubbo_api_grpc_UserRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026UserServiceProto.proto\022\026com.rpc.dubbo." +
      "api.grpc\"(\n\004User\022\016\n\006userId\030\001 \001(\005\022\020\n\010user" +
      "name\030\002 \001(\t\"\035\n\013UserRequest\022\016\n\006userId\030\001 \001(" +
      "\0052\271\001\n\013UserService\022R\n\rqueryUserById\022#.com" +
      ".rpc.dubbo.api.grpc.UserRequest\032\034.com.rp" +
      "c.dubbo.api.grpc.User\022V\n\ruserLocalInfo\022#" +
      ".com.rpc.dubbo.api.grpc.UserRequest\032\034.co" +
      "m.rpc.dubbo.api.grpc.User(\0010\001B,\n\026com.rpc" +
      ".dubbo.api.grpcB\020UserServiceProtoP\001b\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_rpc_dubbo_api_grpc_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_rpc_dubbo_api_grpc_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_rpc_dubbo_api_grpc_User_descriptor,
        new java.lang.String[] { "UserId", "Username", });
    internal_static_com_rpc_dubbo_api_grpc_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_rpc_dubbo_api_grpc_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_rpc_dubbo_api_grpc_UserRequest_descriptor,
        new java.lang.String[] { "UserId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
