// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthActivities.proto

package grpc.example.healthactivities;

public interface MedicationReminderOrBuilder extends
    // @@protoc_insertion_point(interface_extends:health_activities.MedicationReminder)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string medication_name = 1;</code>
   */
  java.lang.String getMedicationName();
  /**
   * <code>string medication_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getMedicationNameBytes();

  /**
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>.google.protobuf.Timestamp reminder_time = 3;</code>
   */
  boolean hasReminderTime();
  /**
   * <code>.google.protobuf.Timestamp reminder_time = 3;</code>
   */
  com.google.protobuf.Timestamp getReminderTime();
  /**
   * <code>.google.protobuf.Timestamp reminder_time = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getReminderTimeOrBuilder();
}
