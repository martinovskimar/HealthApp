// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthMonitoring.proto

package grpc.example.healthmonitoring;

/**
 * Protobuf type {@code UserSleepResponse}
 */
public  final class UserSleepResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UserSleepResponse)
    UserSleepResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserSleepResponse.newBuilder() to construct.
  private UserSleepResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserSleepResponse() {
    totalSleepTimeMinutes_ = 0;
    sleepScore_ = 0D;
    sleepDisprder_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserSleepResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            totalSleepTimeMinutes_ = input.readInt32();
            break;
          }
          case 17: {

            sleepScore_ = input.readDouble();
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            sleepDisprder_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserSleepResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserSleepResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.healthmonitoring.UserSleepResponse.class, grpc.example.healthmonitoring.UserSleepResponse.Builder.class);
  }

  public static final int TOTAL_SLEEP_TIME_MINUTES_FIELD_NUMBER = 1;
  private int totalSleepTimeMinutes_;
  /**
   * <code>int32 total_sleep_time_minutes = 1;</code>
   */
  public int getTotalSleepTimeMinutes() {
    return totalSleepTimeMinutes_;
  }

  public static final int SLEEP_SCORE_FIELD_NUMBER = 2;
  private double sleepScore_;
  /**
   * <code>double sleep_score = 2;</code>
   */
  public double getSleepScore() {
    return sleepScore_;
  }

  public static final int SLEEP_DISPRDER_FIELD_NUMBER = 3;
  private int sleepDisprder_;
  /**
   * <code>.SleepDisorder sleep_disprder = 3;</code>
   */
  public int getSleepDisprderValue() {
    return sleepDisprder_;
  }
  /**
   * <code>.SleepDisorder sleep_disprder = 3;</code>
   */
  public grpc.example.healthmonitoring.SleepDisorder getSleepDisprder() {
    @SuppressWarnings("deprecation")
    grpc.example.healthmonitoring.SleepDisorder result = grpc.example.healthmonitoring.SleepDisorder.valueOf(sleepDisprder_);
    return result == null ? grpc.example.healthmonitoring.SleepDisorder.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (totalSleepTimeMinutes_ != 0) {
      output.writeInt32(1, totalSleepTimeMinutes_);
    }
    if (sleepScore_ != 0D) {
      output.writeDouble(2, sleepScore_);
    }
    if (sleepDisprder_ != grpc.example.healthmonitoring.SleepDisorder.NONE.getNumber()) {
      output.writeEnum(3, sleepDisprder_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (totalSleepTimeMinutes_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, totalSleepTimeMinutes_);
    }
    if (sleepScore_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, sleepScore_);
    }
    if (sleepDisprder_ != grpc.example.healthmonitoring.SleepDisorder.NONE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, sleepDisprder_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.example.healthmonitoring.UserSleepResponse)) {
      return super.equals(obj);
    }
    grpc.example.healthmonitoring.UserSleepResponse other = (grpc.example.healthmonitoring.UserSleepResponse) obj;

    boolean result = true;
    result = result && (getTotalSleepTimeMinutes()
        == other.getTotalSleepTimeMinutes());
    result = result && (
        java.lang.Double.doubleToLongBits(getSleepScore())
        == java.lang.Double.doubleToLongBits(
            other.getSleepScore()));
    result = result && sleepDisprder_ == other.sleepDisprder_;
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TOTAL_SLEEP_TIME_MINUTES_FIELD_NUMBER;
    hash = (53 * hash) + getTotalSleepTimeMinutes();
    hash = (37 * hash) + SLEEP_SCORE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getSleepScore()));
    hash = (37 * hash) + SLEEP_DISPRDER_FIELD_NUMBER;
    hash = (53 * hash) + sleepDisprder_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserSleepResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.example.healthmonitoring.UserSleepResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code UserSleepResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UserSleepResponse)
      grpc.example.healthmonitoring.UserSleepResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserSleepResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserSleepResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.healthmonitoring.UserSleepResponse.class, grpc.example.healthmonitoring.UserSleepResponse.Builder.class);
    }

    // Construct using grpc.example.healthmonitoring.UserSleepResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      totalSleepTimeMinutes_ = 0;

      sleepScore_ = 0D;

      sleepDisprder_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserSleepResponse_descriptor;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserSleepResponse getDefaultInstanceForType() {
      return grpc.example.healthmonitoring.UserSleepResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserSleepResponse build() {
      grpc.example.healthmonitoring.UserSleepResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserSleepResponse buildPartial() {
      grpc.example.healthmonitoring.UserSleepResponse result = new grpc.example.healthmonitoring.UserSleepResponse(this);
      result.totalSleepTimeMinutes_ = totalSleepTimeMinutes_;
      result.sleepScore_ = sleepScore_;
      result.sleepDisprder_ = sleepDisprder_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.example.healthmonitoring.UserSleepResponse) {
        return mergeFrom((grpc.example.healthmonitoring.UserSleepResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.healthmonitoring.UserSleepResponse other) {
      if (other == grpc.example.healthmonitoring.UserSleepResponse.getDefaultInstance()) return this;
      if (other.getTotalSleepTimeMinutes() != 0) {
        setTotalSleepTimeMinutes(other.getTotalSleepTimeMinutes());
      }
      if (other.getSleepScore() != 0D) {
        setSleepScore(other.getSleepScore());
      }
      if (other.sleepDisprder_ != 0) {
        setSleepDisprderValue(other.getSleepDisprderValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.example.healthmonitoring.UserSleepResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.healthmonitoring.UserSleepResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int totalSleepTimeMinutes_ ;
    /**
     * <code>int32 total_sleep_time_minutes = 1;</code>
     */
    public int getTotalSleepTimeMinutes() {
      return totalSleepTimeMinutes_;
    }
    /**
     * <code>int32 total_sleep_time_minutes = 1;</code>
     */
    public Builder setTotalSleepTimeMinutes(int value) {
      
      totalSleepTimeMinutes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 total_sleep_time_minutes = 1;</code>
     */
    public Builder clearTotalSleepTimeMinutes() {
      
      totalSleepTimeMinutes_ = 0;
      onChanged();
      return this;
    }

    private double sleepScore_ ;
    /**
     * <code>double sleep_score = 2;</code>
     */
    public double getSleepScore() {
      return sleepScore_;
    }
    /**
     * <code>double sleep_score = 2;</code>
     */
    public Builder setSleepScore(double value) {
      
      sleepScore_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double sleep_score = 2;</code>
     */
    public Builder clearSleepScore() {
      
      sleepScore_ = 0D;
      onChanged();
      return this;
    }

    private int sleepDisprder_ = 0;
    /**
     * <code>.SleepDisorder sleep_disprder = 3;</code>
     */
    public int getSleepDisprderValue() {
      return sleepDisprder_;
    }
    /**
     * <code>.SleepDisorder sleep_disprder = 3;</code>
     */
    public Builder setSleepDisprderValue(int value) {
      sleepDisprder_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.SleepDisorder sleep_disprder = 3;</code>
     */
    public grpc.example.healthmonitoring.SleepDisorder getSleepDisprder() {
      @SuppressWarnings("deprecation")
      grpc.example.healthmonitoring.SleepDisorder result = grpc.example.healthmonitoring.SleepDisorder.valueOf(sleepDisprder_);
      return result == null ? grpc.example.healthmonitoring.SleepDisorder.UNRECOGNIZED : result;
    }
    /**
     * <code>.SleepDisorder sleep_disprder = 3;</code>
     */
    public Builder setSleepDisprder(grpc.example.healthmonitoring.SleepDisorder value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      sleepDisprder_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.SleepDisorder sleep_disprder = 3;</code>
     */
    public Builder clearSleepDisprder() {
      
      sleepDisprder_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:UserSleepResponse)
  }

  // @@protoc_insertion_point(class_scope:UserSleepResponse)
  private static final grpc.example.healthmonitoring.UserSleepResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.healthmonitoring.UserSleepResponse();
  }

  public static grpc.example.healthmonitoring.UserSleepResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserSleepResponse>
      PARSER = new com.google.protobuf.AbstractParser<UserSleepResponse>() {
    @java.lang.Override
    public UserSleepResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserSleepResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserSleepResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserSleepResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.healthmonitoring.UserSleepResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
