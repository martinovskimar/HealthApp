// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: S2-healthMonitoring.proto

package grpc.service2;

public interface UserSleepResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserSleepResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 total_sleep_time_minutes = 1;</code>
   */
  int getTotalSleepTimeMinutes();

  /**
   * <code>double sleep_score = 2;</code>
   */
  double getSleepScore();

  /**
   * <code>.SleepDisorder sleep_disprder = 3;</code>
   */
  int getSleepDisprderValue();
  /**
   * <code>.SleepDisorder sleep_disprder = 3;</code>
   */
  grpc.service2.SleepDisorder getSleepDisprder();
}