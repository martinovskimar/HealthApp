// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthMonitoring.proto

package grpc.example.healthmonitoring;

/**
 * Protobuf enum {@code SleepDisorder}
 */
public enum SleepDisorder
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>NONE = 0;</code>
   */
  NONE(0),
  /**
   * <code>INSOMNIA = 1;</code>
   */
  INSOMNIA(1),
  /**
   * <code>SLEEP_APNEA = 2;</code>
   */
  SLEEP_APNEA(2),
  /**
   * <code>NARCOLEPSY = 3;</code>
   */
  NARCOLEPSY(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>NONE = 0;</code>
   */
  public static final int NONE_VALUE = 0;
  /**
   * <code>INSOMNIA = 1;</code>
   */
  public static final int INSOMNIA_VALUE = 1;
  /**
   * <code>SLEEP_APNEA = 2;</code>
   */
  public static final int SLEEP_APNEA_VALUE = 2;
  /**
   * <code>NARCOLEPSY = 3;</code>
   */
  public static final int NARCOLEPSY_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static SleepDisorder valueOf(int value) {
    return forNumber(value);
  }

  public static SleepDisorder forNumber(int value) {
    switch (value) {
      case 0: return NONE;
      case 1: return INSOMNIA;
      case 2: return SLEEP_APNEA;
      case 3: return NARCOLEPSY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SleepDisorder>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SleepDisorder> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SleepDisorder>() {
          public SleepDisorder findValueByNumber(int number) {
            return SleepDisorder.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return grpc.example.healthmonitoring.healthMonitoringProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final SleepDisorder[] VALUES = values();

  public static SleepDisorder valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SleepDisorder(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:SleepDisorder)
}

