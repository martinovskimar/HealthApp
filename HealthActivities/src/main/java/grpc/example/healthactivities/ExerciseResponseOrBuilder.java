// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthActivities.proto

package grpc.example.healthactivities;

public interface ExerciseResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:health_activities.ExerciseResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 duration = 1;</code>
   */
  int getDuration();

  /**
   * <code>int32 total_calories = 2;</code>
   */
  int getTotalCalories();

  /**
   * <code>repeated .health_activities.ExerciseResponse.HeartRateZone heart_rate_zones = 3;</code>
   */
  java.util.List<grpc.example.healthactivities.ExerciseResponse.HeartRateZone> 
      getHeartRateZonesList();
  /**
   * <code>repeated .health_activities.ExerciseResponse.HeartRateZone heart_rate_zones = 3;</code>
   */
  grpc.example.healthactivities.ExerciseResponse.HeartRateZone getHeartRateZones(int index);
  /**
   * <code>repeated .health_activities.ExerciseResponse.HeartRateZone heart_rate_zones = 3;</code>
   */
  int getHeartRateZonesCount();
  /**
   * <code>repeated .health_activities.ExerciseResponse.HeartRateZone heart_rate_zones = 3;</code>
   */
  java.util.List<? extends grpc.example.healthactivities.ExerciseResponse.HeartRateZoneOrBuilder> 
      getHeartRateZonesOrBuilderList();
  /**
   * <code>repeated .health_activities.ExerciseResponse.HeartRateZone heart_rate_zones = 3;</code>
   */
  grpc.example.healthactivities.ExerciseResponse.HeartRateZoneOrBuilder getHeartRateZonesOrBuilder(
      int index);

  /**
   * <code>int32 average_heart_rate = 4;</code>
   */
  int getAverageHeartRate();

  /**
   * <code>int32 max_heart_rate = 5;</code>
   */
  int getMaxHeartRate();

  /**
   * <code>int32 calories_spent = 6;</code>
   */
  int getCaloriesSpent();
}