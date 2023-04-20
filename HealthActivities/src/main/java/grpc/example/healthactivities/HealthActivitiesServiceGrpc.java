package grpc.example.healthactivities;

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
    comments = "Source: healthActivities.proto")
public final class HealthActivitiesServiceGrpc {

  private HealthActivitiesServiceGrpc() {}

  public static final String SERVICE_NAME = "health_activities.HealthActivitiesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.example.healthactivities.ExerciseRequest,
      grpc.example.healthactivities.ExerciseResponse> getExerciseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Exercise",
      requestType = grpc.example.healthactivities.ExerciseRequest.class,
      responseType = grpc.example.healthactivities.ExerciseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.example.healthactivities.ExerciseRequest,
      grpc.example.healthactivities.ExerciseResponse> getExerciseMethod() {
    io.grpc.MethodDescriptor<grpc.example.healthactivities.ExerciseRequest, grpc.example.healthactivities.ExerciseResponse> getExerciseMethod;
    if ((getExerciseMethod = HealthActivitiesServiceGrpc.getExerciseMethod) == null) {
      synchronized (HealthActivitiesServiceGrpc.class) {
        if ((getExerciseMethod = HealthActivitiesServiceGrpc.getExerciseMethod) == null) {
          HealthActivitiesServiceGrpc.getExerciseMethod = getExerciseMethod = 
              io.grpc.MethodDescriptor.<grpc.example.healthactivities.ExerciseRequest, grpc.example.healthactivities.ExerciseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "health_activities.HealthActivitiesService", "Exercise"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.ExerciseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.ExerciseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthActivitiesServiceMethodDescriptorSupplier("Exercise"))
                  .build();
          }
        }
     }
     return getExerciseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.healthactivities.NutritionRequest,
      grpc.example.healthactivities.NutritionResponse> getNutritionInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NutritionInformation",
      requestType = grpc.example.healthactivities.NutritionRequest.class,
      responseType = grpc.example.healthactivities.NutritionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.healthactivities.NutritionRequest,
      grpc.example.healthactivities.NutritionResponse> getNutritionInformationMethod() {
    io.grpc.MethodDescriptor<grpc.example.healthactivities.NutritionRequest, grpc.example.healthactivities.NutritionResponse> getNutritionInformationMethod;
    if ((getNutritionInformationMethod = HealthActivitiesServiceGrpc.getNutritionInformationMethod) == null) {
      synchronized (HealthActivitiesServiceGrpc.class) {
        if ((getNutritionInformationMethod = HealthActivitiesServiceGrpc.getNutritionInformationMethod) == null) {
          HealthActivitiesServiceGrpc.getNutritionInformationMethod = getNutritionInformationMethod = 
              io.grpc.MethodDescriptor.<grpc.example.healthactivities.NutritionRequest, grpc.example.healthactivities.NutritionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "health_activities.HealthActivitiesService", "NutritionInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.NutritionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.NutritionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthActivitiesServiceMethodDescriptorSupplier("NutritionInformation"))
                  .build();
          }
        }
     }
     return getNutritionInformationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.healthactivities.EmergencyRequest,
      grpc.example.healthactivities.EmergencyResponse> getCallAmbulanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CallAmbulance",
      requestType = grpc.example.healthactivities.EmergencyRequest.class,
      responseType = grpc.example.healthactivities.EmergencyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.example.healthactivities.EmergencyRequest,
      grpc.example.healthactivities.EmergencyResponse> getCallAmbulanceMethod() {
    io.grpc.MethodDescriptor<grpc.example.healthactivities.EmergencyRequest, grpc.example.healthactivities.EmergencyResponse> getCallAmbulanceMethod;
    if ((getCallAmbulanceMethod = HealthActivitiesServiceGrpc.getCallAmbulanceMethod) == null) {
      synchronized (HealthActivitiesServiceGrpc.class) {
        if ((getCallAmbulanceMethod = HealthActivitiesServiceGrpc.getCallAmbulanceMethod) == null) {
          HealthActivitiesServiceGrpc.getCallAmbulanceMethod = getCallAmbulanceMethod = 
              io.grpc.MethodDescriptor.<grpc.example.healthactivities.EmergencyRequest, grpc.example.healthactivities.EmergencyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "health_activities.HealthActivitiesService", "CallAmbulance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.EmergencyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.EmergencyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthActivitiesServiceMethodDescriptorSupplier("CallAmbulance"))
                  .build();
          }
        }
     }
     return getCallAmbulanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.healthactivities.MedicationRequest,
      grpc.example.healthactivities.MedicationReminder> getRemindMedicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemindMedication",
      requestType = grpc.example.healthactivities.MedicationRequest.class,
      responseType = grpc.example.healthactivities.MedicationReminder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.healthactivities.MedicationRequest,
      grpc.example.healthactivities.MedicationReminder> getRemindMedicationMethod() {
    io.grpc.MethodDescriptor<grpc.example.healthactivities.MedicationRequest, grpc.example.healthactivities.MedicationReminder> getRemindMedicationMethod;
    if ((getRemindMedicationMethod = HealthActivitiesServiceGrpc.getRemindMedicationMethod) == null) {
      synchronized (HealthActivitiesServiceGrpc.class) {
        if ((getRemindMedicationMethod = HealthActivitiesServiceGrpc.getRemindMedicationMethod) == null) {
          HealthActivitiesServiceGrpc.getRemindMedicationMethod = getRemindMedicationMethod = 
              io.grpc.MethodDescriptor.<grpc.example.healthactivities.MedicationRequest, grpc.example.healthactivities.MedicationReminder>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "health_activities.HealthActivitiesService", "RemindMedication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.MedicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.healthactivities.MedicationReminder.getDefaultInstance()))
                  .setSchemaDescriptor(new HealthActivitiesServiceMethodDescriptorSupplier("RemindMedication"))
                  .build();
          }
        }
     }
     return getRemindMedicationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthActivitiesServiceStub newStub(io.grpc.Channel channel) {
    return new HealthActivitiesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthActivitiesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HealthActivitiesServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthActivitiesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HealthActivitiesServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HealthActivitiesServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void exercise(grpc.example.healthactivities.ExerciseRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.ExerciseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getExerciseMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.healthactivities.NutritionRequest> nutritionInformation(
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.NutritionResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getNutritionInformationMethod(), responseObserver);
    }

    /**
     */
    public void callAmbulance(grpc.example.healthactivities.EmergencyRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.EmergencyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCallAmbulanceMethod(), responseObserver);
    }

    /**
     */
    public void remindMedication(grpc.example.healthactivities.MedicationRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.MedicationReminder> responseObserver) {
      asyncUnimplementedUnaryCall(getRemindMedicationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExerciseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.example.healthactivities.ExerciseRequest,
                grpc.example.healthactivities.ExerciseResponse>(
                  this, METHODID_EXERCISE)))
          .addMethod(
            getNutritionInformationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.example.healthactivities.NutritionRequest,
                grpc.example.healthactivities.NutritionResponse>(
                  this, METHODID_NUTRITION_INFORMATION)))
          .addMethod(
            getCallAmbulanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.example.healthactivities.EmergencyRequest,
                grpc.example.healthactivities.EmergencyResponse>(
                  this, METHODID_CALL_AMBULANCE)))
          .addMethod(
            getRemindMedicationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.example.healthactivities.MedicationRequest,
                grpc.example.healthactivities.MedicationReminder>(
                  this, METHODID_REMIND_MEDICATION)))
          .build();
    }
  }

  /**
   */
  public static final class HealthActivitiesServiceStub extends io.grpc.stub.AbstractStub<HealthActivitiesServiceStub> {
    private HealthActivitiesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthActivitiesServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthActivitiesServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthActivitiesServiceStub(channel, callOptions);
    }

    /**
     */
    public void exercise(grpc.example.healthactivities.ExerciseRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.ExerciseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExerciseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.healthactivities.NutritionRequest> nutritionInformation(
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.NutritionResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getNutritionInformationMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void callAmbulance(grpc.example.healthactivities.EmergencyRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.EmergencyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallAmbulanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void remindMedication(grpc.example.healthactivities.MedicationRequest request,
        io.grpc.stub.StreamObserver<grpc.example.healthactivities.MedicationReminder> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRemindMedicationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HealthActivitiesServiceBlockingStub extends io.grpc.stub.AbstractStub<HealthActivitiesServiceBlockingStub> {
    private HealthActivitiesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthActivitiesServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthActivitiesServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthActivitiesServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.example.healthactivities.ExerciseResponse exercise(grpc.example.healthactivities.ExerciseRequest request) {
      return blockingUnaryCall(
          getChannel(), getExerciseMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.example.healthactivities.EmergencyResponse callAmbulance(grpc.example.healthactivities.EmergencyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallAmbulanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.example.healthactivities.MedicationReminder> remindMedication(
        grpc.example.healthactivities.MedicationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getRemindMedicationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthActivitiesServiceFutureStub extends io.grpc.stub.AbstractStub<HealthActivitiesServiceFutureStub> {
    private HealthActivitiesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HealthActivitiesServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthActivitiesServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HealthActivitiesServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.example.healthactivities.ExerciseResponse> exercise(
        grpc.example.healthactivities.ExerciseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExerciseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.example.healthactivities.EmergencyResponse> callAmbulance(
        grpc.example.healthactivities.EmergencyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallAmbulanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXERCISE = 0;
  private static final int METHODID_CALL_AMBULANCE = 1;
  private static final int METHODID_REMIND_MEDICATION = 2;
  private static final int METHODID_NUTRITION_INFORMATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthActivitiesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthActivitiesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXERCISE:
          serviceImpl.exercise((grpc.example.healthactivities.ExerciseRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.healthactivities.ExerciseResponse>) responseObserver);
          break;
        case METHODID_CALL_AMBULANCE:
          serviceImpl.callAmbulance((grpc.example.healthactivities.EmergencyRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.healthactivities.EmergencyResponse>) responseObserver);
          break;
        case METHODID_REMIND_MEDICATION:
          serviceImpl.remindMedication((grpc.example.healthactivities.MedicationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.healthactivities.MedicationReminder>) responseObserver);
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
        case METHODID_NUTRITION_INFORMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.nutritionInformation(
              (io.grpc.stub.StreamObserver<grpc.example.healthactivities.NutritionResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthActivitiesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthActivitiesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.healthactivities.HealthActivitiesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthActivitiesService");
    }
  }

  private static final class HealthActivitiesServiceFileDescriptorSupplier
      extends HealthActivitiesServiceBaseDescriptorSupplier {
    HealthActivitiesServiceFileDescriptorSupplier() {}
  }

  private static final class HealthActivitiesServiceMethodDescriptorSupplier
      extends HealthActivitiesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthActivitiesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthActivitiesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthActivitiesServiceFileDescriptorSupplier())
              .addMethod(getExerciseMethod())
              .addMethod(getNutritionInformationMethod())
              .addMethod(getCallAmbulanceMethod())
              .addMethod(getRemindMedicationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
