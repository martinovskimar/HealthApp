package grpc.service2;

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
    comments = "Source: S2-healthMonitoring.proto")
public final class HealthMonitoringServiceGrpc {

  private HealthMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "HealthMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.service2.UserStepsRequest,
      grpc.service2.UserStepsResponse> getTrackStepsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackSteps",
      requestType = grpc.service2.UserStepsRequest.class,
      responseType = grpc.service2.UserStepsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.service2.UserStepsRequest,
      grpc.service2.UserStepsResponse> getTrackStepsMethod() {
    io.grpc.MethodDescriptor<grpc.service2.UserStepsRequest, grpc.service2.UserStepsResponse> getTrackStepsMethod;
    if ((getTrackStepsMethod = HealthMonitoringServiceGrpc.getTrackStepsMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getTrackStepsMethod = HealthMonitoringServiceGrpc.getTrackStepsMethod) == null) {
          HealthMonitoringServiceGrpc.getTrackStepsMethod = getTrackStepsMethod = 
              io.grpc.MethodDescriptor.<grpc.service2.UserStepsRequest, grpc.service2.UserStepsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HealthMonitoringService", "TrackSteps"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserStepsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserStepsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("TrackSteps"))
                  .build();
          }
        }
     }
     return getTrackStepsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.service2.UserHearthRateRequest,
      grpc.service2.UserHearthRateResponse> getHearthRateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HearthRate",
      requestType = grpc.service2.UserHearthRateRequest.class,
      responseType = grpc.service2.UserHearthRateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.service2.UserHearthRateRequest,
      grpc.service2.UserHearthRateResponse> getHearthRateMethod() {
    io.grpc.MethodDescriptor<grpc.service2.UserHearthRateRequest, grpc.service2.UserHearthRateResponse> getHearthRateMethod;
    if ((getHearthRateMethod = HealthMonitoringServiceGrpc.getHearthRateMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getHearthRateMethod = HealthMonitoringServiceGrpc.getHearthRateMethod) == null) {
          HealthMonitoringServiceGrpc.getHearthRateMethod = getHearthRateMethod = 
              io.grpc.MethodDescriptor.<grpc.service2.UserHearthRateRequest, grpc.service2.UserHearthRateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HealthMonitoringService", "HearthRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserHearthRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserHearthRateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("HearthRate"))
                  .build();
          }
        }
     }
     return getHearthRateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.service2.UserSleepRequest,
      grpc.service2.UserSleepResponse> getTrackSleepMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackSleep",
      requestType = grpc.service2.UserSleepRequest.class,
      responseType = grpc.service2.UserSleepResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.service2.UserSleepRequest,
      grpc.service2.UserSleepResponse> getTrackSleepMethod() {
    io.grpc.MethodDescriptor<grpc.service2.UserSleepRequest, grpc.service2.UserSleepResponse> getTrackSleepMethod;
    if ((getTrackSleepMethod = HealthMonitoringServiceGrpc.getTrackSleepMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getTrackSleepMethod = HealthMonitoringServiceGrpc.getTrackSleepMethod) == null) {
          HealthMonitoringServiceGrpc.getTrackSleepMethod = getTrackSleepMethod = 
              io.grpc.MethodDescriptor.<grpc.service2.UserSleepRequest, grpc.service2.UserSleepResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HealthMonitoringService", "TrackSleep"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserSleepRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserSleepResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("TrackSleep"))
                  .build();
          }
        }
     }
     return getTrackSleepMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.service2.UserStressRequest,
      grpc.service2.UserStressResponse> getTrackStressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackStress",
      requestType = grpc.service2.UserStressRequest.class,
      responseType = grpc.service2.UserStressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.service2.UserStressRequest,
      grpc.service2.UserStressResponse> getTrackStressMethod() {
    io.grpc.MethodDescriptor<grpc.service2.UserStressRequest, grpc.service2.UserStressResponse> getTrackStressMethod;
    if ((getTrackStressMethod = HealthMonitoringServiceGrpc.getTrackStressMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getTrackStressMethod = HealthMonitoringServiceGrpc.getTrackStressMethod) == null) {
          HealthMonitoringServiceGrpc.getTrackStressMethod = getTrackStressMethod = 
              io.grpc.MethodDescriptor.<grpc.service2.UserStressRequest, grpc.service2.UserStressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HealthMonitoringService", "TrackStress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserStressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.service2.UserStressResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("TrackStress"))
                  .build();
          }
        }
     }
     return getTrackStressMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthMonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new HealthMonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthMonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthMonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HealthMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void trackSteps(grpc.service2.UserStepsRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserStepsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTrackStepsMethod(), responseObserver);
    }

    /**
     */
    public void hearthRate(grpc.service2.UserHearthRateRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserHearthRateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHearthRateMethod(), responseObserver);
    }

    /**
     */
    public void trackSleep(grpc.service2.UserSleepRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserSleepResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTrackSleepMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.service2.UserStressRequest> trackStress(
        io.grpc.stub.StreamObserver<grpc.service2.UserStressResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTrackStressMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrackStepsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.service2.UserStepsRequest,
                grpc.service2.UserStepsResponse>(
                  this, METHODID_TRACK_STEPS)))
          .addMethod(
            getHearthRateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.service2.UserHearthRateRequest,
                grpc.service2.UserHearthRateResponse>(
                  this, METHODID_HEARTH_RATE)))
          .addMethod(
            getTrackSleepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.service2.UserSleepRequest,
                grpc.service2.UserSleepResponse>(
                  this, METHODID_TRACK_SLEEP)))
          .addMethod(
            getTrackStressMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.service2.UserStressRequest,
                grpc.service2.UserStressResponse>(
                  this, METHODID_TRACK_STRESS)))
          .build();
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceStub extends io.grpc.stub.AbstractStub<HealthMonitoringServiceStub> {
    private HealthMonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceStub(channel, callOptions);
    }

    /**
     */
    public void trackSteps(grpc.service2.UserStepsRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserStepsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTrackStepsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void hearthRate(grpc.service2.UserHearthRateRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserHearthRateResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getHearthRateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void trackSleep(grpc.service2.UserSleepRequest request,
        io.grpc.stub.StreamObserver<grpc.service2.UserSleepResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTrackSleepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.service2.UserStressRequest> trackStress(
        io.grpc.stub.StreamObserver<grpc.service2.UserStressResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTrackStressMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<HealthMonitoringServiceBlockingStub> {
    private HealthMonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.service2.UserStepsResponse> trackSteps(
        grpc.service2.UserStepsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getTrackStepsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.service2.UserHearthRateResponse> hearthRate(
        grpc.service2.UserHearthRateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getHearthRateMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.service2.UserSleepResponse trackSleep(grpc.service2.UserSleepRequest request) {
      return blockingUnaryCall(
          getChannel(), getTrackSleepMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<HealthMonitoringServiceFutureStub> {
    private HealthMonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthMonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.service2.UserSleepResponse> trackSleep(
        grpc.service2.UserSleepRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTrackSleepMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRACK_STEPS = 0;
  private static final int METHODID_HEARTH_RATE = 1;
  private static final int METHODID_TRACK_SLEEP = 2;
  private static final int METHODID_TRACK_STRESS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRACK_STEPS:
          serviceImpl.trackSteps((grpc.service2.UserStepsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.service2.UserStepsResponse>) responseObserver);
          break;
        case METHODID_HEARTH_RATE:
          serviceImpl.hearthRate((grpc.service2.UserHearthRateRequest) request,
              (io.grpc.stub.StreamObserver<grpc.service2.UserHearthRateResponse>) responseObserver);
          break;
        case METHODID_TRACK_SLEEP:
          serviceImpl.trackSleep((grpc.service2.UserSleepRequest) request,
              (io.grpc.stub.StreamObserver<grpc.service2.UserSleepResponse>) responseObserver);
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
        case METHODID_TRACK_STRESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.trackStress(
              (io.grpc.stub.StreamObserver<grpc.service2.UserStressResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.service2.healthMonitoringProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthMonitoringService");
    }
  }

  private static final class HealthMonitoringServiceFileDescriptorSupplier
      extends HealthMonitoringServiceBaseDescriptorSupplier {
    HealthMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class HealthMonitoringServiceMethodDescriptorSupplier
      extends HealthMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthMonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthMonitoringServiceFileDescriptorSupplier())
              .addMethod(getTrackStepsMethod())
              .addMethod(getHearthRateMethod())
              .addMethod(getTrackSleepMethod())
              .addMethod(getTrackStressMethod())
              .build();
        }
      }
    }
    return result;
  }
}
