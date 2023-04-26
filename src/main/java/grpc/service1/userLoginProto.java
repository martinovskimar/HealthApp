// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S1-userLogin.proto

package grpc.service1;

public final class userLoginProto {
  private userLoginProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LogoutRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LogoutRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LogoutResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LogoutResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022S1-userLogin.proto\"/\n\014LoginRequest\022\r\n\005" +
      "email\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"A\n\rLoginRe" +
      "sponse\022\034\n\006status\030\001 \001(\0162\014.LoginStatus\022\022\n\n" +
      "userStatus\030\002 \001(\t\"#\n\rLogoutRequest\022\022\n\nuse" +
      "rStatus\030\001 \001(\t\"/\n\016LogoutResponse\022\035\n\006statu" +
      "s\030\001 \001(\0162\r.LogoutStatus*A\n\013LoginStatus\022\025\n" +
      "\021LOGIN_SUCCESSFULL\020\000\022\033\n\027INCORRECT_LOGIN_" +
      "DETAILS\020\001*>\n\014LogoutStatus\022\026\n\022LOGOUT_SUCC" +
      "ESSFULL\020\000\022\026\n\022INVALID_USERSTATUS\020\0012b\n\tuse" +
      "rLogin\022(\n\005Login\022\r.LoginRequest\032\016.LoginRe" +
      "sponse\"\000\022+\n\006Logout\022\016.LogoutRequest\032\017.Log" +
      "outResponse\"\000B!\n\rgrpc.service1B\016userLogi" +
      "nProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginRequest_descriptor,
        new java.lang.String[] { "Email", "Password", });
    internal_static_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginResponse_descriptor,
        new java.lang.String[] { "Status", "UserStatus", });
    internal_static_LogoutRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_LogoutRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LogoutRequest_descriptor,
        new java.lang.String[] { "UserStatus", });
    internal_static_LogoutResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_LogoutResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LogoutResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}