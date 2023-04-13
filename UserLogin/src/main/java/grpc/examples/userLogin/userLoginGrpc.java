package grpc.examples.userLogin;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: userLogin.proto")
public final class userLoginGrpc {

  private userLoginGrpc() {}

  public static final String SERVICE_NAME = "userLogin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.examples.userLogin.LoginRequest,
      grpc.examples.userLogin.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = grpc.examples.userLogin.LoginRequest.class,
      responseType = grpc.examples.userLogin.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.userLogin.LoginRequest,
      grpc.examples.userLogin.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<grpc.examples.userLogin.LoginRequest, grpc.examples.userLogin.LoginResponse> getLoginMethod;
    if ((getLoginMethod = userLoginGrpc.getLoginMethod) == null) {
      synchronized (userLoginGrpc.class) {
        if ((getLoginMethod = userLoginGrpc.getLoginMethod) == null) {
          userLoginGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.userLogin.LoginRequest, grpc.examples.userLogin.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "userLogin", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.userLogin.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.userLogin.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new userLoginMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.examples.userLogin.LogoutRequest,
      grpc.examples.userLogin.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Logout",
      requestType = grpc.examples.userLogin.LogoutRequest.class,
      responseType = grpc.examples.userLogin.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.examples.userLogin.LogoutRequest,
      grpc.examples.userLogin.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<grpc.examples.userLogin.LogoutRequest, grpc.examples.userLogin.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = userLoginGrpc.getLogoutMethod) == null) {
      synchronized (userLoginGrpc.class) {
        if ((getLogoutMethod = userLoginGrpc.getLogoutMethod) == null) {
          userLoginGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<grpc.examples.userLogin.LogoutRequest, grpc.examples.userLogin.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "userLogin", "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.userLogin.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.examples.userLogin.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new userLoginMethodDescriptorSupplier("Logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static userLoginStub newStub(io.grpc.Channel channel) {
    return new userLoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static userLoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new userLoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static userLoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new userLoginFutureStub(channel);
  }

  /**
   */
  public static abstract class userLoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(grpc.examples.userLogin.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.userLogin.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(grpc.examples.userLogin.LogoutRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.userLogin.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.userLogin.LoginRequest,
                grpc.examples.userLogin.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.examples.userLogin.LogoutRequest,
                grpc.examples.userLogin.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   */
  public static final class userLoginStub extends io.grpc.stub.AbstractStub<userLoginStub> {
    private userLoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userLoginStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userLoginStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userLoginStub(channel, callOptions);
    }

    /**
     */
    public void login(grpc.examples.userLogin.LoginRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.userLogin.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(grpc.examples.userLogin.LogoutRequest request,
        io.grpc.stub.StreamObserver<grpc.examples.userLogin.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class userLoginBlockingStub extends io.grpc.stub.AbstractStub<userLoginBlockingStub> {
    private userLoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userLoginBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userLoginBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userLoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.examples.userLogin.LoginResponse login(grpc.examples.userLogin.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.examples.userLogin.LogoutResponse logout(grpc.examples.userLogin.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class userLoginFutureStub extends io.grpc.stub.AbstractStub<userLoginFutureStub> {
    private userLoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private userLoginFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userLoginFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new userLoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.userLogin.LoginResponse> login(
        grpc.examples.userLogin.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.examples.userLogin.LogoutResponse> logout(
        grpc.examples.userLogin.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final userLoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(userLoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((grpc.examples.userLogin.LoginRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.userLogin.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((grpc.examples.userLogin.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<grpc.examples.userLogin.LogoutResponse>) responseObserver);
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

  private static abstract class userLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    userLoginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.examples.userLogin.userLoginProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("userLogin");
    }
  }

  private static final class userLoginFileDescriptorSupplier
      extends userLoginBaseDescriptorSupplier {
    userLoginFileDescriptorSupplier() {}
  }

  private static final class userLoginMethodDescriptorSupplier
      extends userLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    userLoginMethodDescriptorSupplier(String methodName) {
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
      synchronized (userLoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new userLoginFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
