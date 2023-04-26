// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S2-healthMonitoring.proto

package grpc.service2;

public final class healthMonitoringProto {
  private healthMonitoringProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserStepsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserStepsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserStepsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserStepsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserHearthRateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserHearthRateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserHearthRateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserHearthRateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserSleepRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserSleepRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserSleepResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserSleepResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserStressRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserStressRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserStressResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserStressResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031S2-healthMonitoring.proto\032\037google/prot" +
      "obuf/timestamp.proto\"$\n\020UserStepsRequest" +
      "\022\020\n\010username\030\001 \001(\t\"X\n\021UserStepsResponse\022" +
      "\025\n\rcurrent_steps\030\001 \001(\005\022\025\n\rgoal_achieved\030" +
      "\002 \001(\010\022\025\n\raverage_steps\030\003 \001(\005\")\n\025UserHear" +
      "thRateRequest\022\020\n\010username\030\001 \001(\t\"M\n\026UserH" +
      "earthRateResponse\022\032\n\022curent_hearth_rate\030" +
      "\001 \001(\005\022\027\n\017warning_message\030\002 \001(\t\"\243\001\n\020UserS" +
      "leepRequest\022\020\n\010username\030\001 \001(\t\022.\n\nsleep_t" +
      "ime\030\002 \001(\0132\032.google.protobuf.Timestamp\022/\n" +
      "\013wakeup_time\030\003 \001(\0132\032.google.protobuf.Tim" +
      "estamp\022\034\n\024snorint_time_minutes\030\004 \001(\005\"r\n\021" +
      "UserSleepResponse\022 \n\030total_sleep_time_mi" +
      "nutes\030\001 \001(\005\022\023\n\013sleep_score\030\002 \001(\001\022&\n\016slee" +
      "p_disprder\030\003 \001(\0162\016.SleepDisorder\"@\n\021User" +
      "StressRequest\022\023\n\013hearth_rate\030\001 \001(\005\022\026\n\016br" +
      "eathing_rate\030\002 \001(\005\"8\n\022UserStressResponse" +
      "\022\022\n\nstres_leve\030\001 \001(\002\022\016\n\006advice\030\002 \001(\t*H\n\r" +
      "SleepDisorder\022\010\n\004NONE\020\000\022\014\n\010INSOMNIA\020\001\022\017\n" +
      "\013SLEEP_APNEA\020\002\022\016\n\nNARCOLEPSY\020\0032\212\002\n\027Healt" +
      "hMonitoringService\0227\n\nTrackSteps\022\021.UserS" +
      "tepsRequest\032\022.UserStepsResponse\"\0000\001\022A\n\nH" +
      "earthRate\022\026.UserHearthRateRequest\032\027.User" +
      "HearthRateResponse\"\0000\001\0225\n\nTrackSleep\022\021.U" +
      "serSleepRequest\032\022.UserSleepResponse\"\000\022<\n" +
      "\013TrackStress\022\022.UserStressRequest\032\023.UserS" +
      "tressResponse\"\000(\0010\001B(\n\rgrpc.service2B\025he" +
      "althMonitoringProtoP\001b\006proto3"
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
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_UserStepsRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UserStepsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserStepsRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_UserStepsResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UserStepsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserStepsResponse_descriptor,
        new java.lang.String[] { "CurrentSteps", "GoalAchieved", "AverageSteps", });
    internal_static_UserHearthRateRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_UserHearthRateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserHearthRateRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_UserHearthRateResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_UserHearthRateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserHearthRateResponse_descriptor,
        new java.lang.String[] { "CurentHearthRate", "WarningMessage", });
    internal_static_UserSleepRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_UserSleepRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserSleepRequest_descriptor,
        new java.lang.String[] { "Username", "SleepTime", "WakeupTime", "SnorintTimeMinutes", });
    internal_static_UserSleepResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_UserSleepResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserSleepResponse_descriptor,
        new java.lang.String[] { "TotalSleepTimeMinutes", "SleepScore", "SleepDisprder", });
    internal_static_UserStressRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_UserStressRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserStressRequest_descriptor,
        new java.lang.String[] { "HearthRate", "BreathingRate", });
    internal_static_UserStressResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_UserStressResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserStressResponse_descriptor,
        new java.lang.String[] { "StresLeve", "Advice", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}