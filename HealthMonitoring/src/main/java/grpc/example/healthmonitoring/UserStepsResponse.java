// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthMonitoring.proto

package grpc.example.healthmonitoring;

/**
 * Protobuf type {@code UserStepsResponse}
 */
public  final class UserStepsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UserStepsResponse)
    UserStepsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserStepsResponse.newBuilder() to construct.
  private UserStepsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserStepsResponse() {
    currentSteps_ = 0;
    goalAchieved_ = false;
    averageSteps_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserStepsResponse(
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

            currentSteps_ = input.readInt32();
            break;
          }
          case 16: {

            goalAchieved_ = input.readBool();
            break;
          }
          case 24: {

            averageSteps_ = input.readInt32();
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
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserStepsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserStepsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.healthmonitoring.UserStepsResponse.class, grpc.example.healthmonitoring.UserStepsResponse.Builder.class);
  }

  public static final int CURRENT_STEPS_FIELD_NUMBER = 1;
  private int currentSteps_;
  /**
   * <code>int32 current_steps = 1;</code>
   */
  public int getCurrentSteps() {
    return currentSteps_;
  }

  public static final int GOAL_ACHIEVED_FIELD_NUMBER = 2;
  private boolean goalAchieved_;
  /**
   * <code>bool goal_achieved = 2;</code>
   */
  public boolean getGoalAchieved() {
    return goalAchieved_;
  }

  public static final int AVERAGE_STEPS_FIELD_NUMBER = 3;
  private int averageSteps_;
  /**
   * <code>int32 average_steps = 3;</code>
   */
  public int getAverageSteps() {
    return averageSteps_;
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
    if (currentSteps_ != 0) {
      output.writeInt32(1, currentSteps_);
    }
    if (goalAchieved_ != false) {
      output.writeBool(2, goalAchieved_);
    }
    if (averageSteps_ != 0) {
      output.writeInt32(3, averageSteps_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (currentSteps_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, currentSteps_);
    }
    if (goalAchieved_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, goalAchieved_);
    }
    if (averageSteps_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, averageSteps_);
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
    if (!(obj instanceof grpc.example.healthmonitoring.UserStepsResponse)) {
      return super.equals(obj);
    }
    grpc.example.healthmonitoring.UserStepsResponse other = (grpc.example.healthmonitoring.UserStepsResponse) obj;

    boolean result = true;
    result = result && (getCurrentSteps()
        == other.getCurrentSteps());
    result = result && (getGoalAchieved()
        == other.getGoalAchieved());
    result = result && (getAverageSteps()
        == other.getAverageSteps());
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
    hash = (37 * hash) + CURRENT_STEPS_FIELD_NUMBER;
    hash = (53 * hash) + getCurrentSteps();
    hash = (37 * hash) + GOAL_ACHIEVED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getGoalAchieved());
    hash = (37 * hash) + AVERAGE_STEPS_FIELD_NUMBER;
    hash = (53 * hash) + getAverageSteps();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserStepsResponse parseFrom(
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
  public static Builder newBuilder(grpc.example.healthmonitoring.UserStepsResponse prototype) {
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
   * Protobuf type {@code UserStepsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UserStepsResponse)
      grpc.example.healthmonitoring.UserStepsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserStepsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserStepsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.healthmonitoring.UserStepsResponse.class, grpc.example.healthmonitoring.UserStepsResponse.Builder.class);
    }

    // Construct using grpc.example.healthmonitoring.UserStepsResponse.newBuilder()
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
      currentSteps_ = 0;

      goalAchieved_ = false;

      averageSteps_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserStepsResponse_descriptor;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserStepsResponse getDefaultInstanceForType() {
      return grpc.example.healthmonitoring.UserStepsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserStepsResponse build() {
      grpc.example.healthmonitoring.UserStepsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserStepsResponse buildPartial() {
      grpc.example.healthmonitoring.UserStepsResponse result = new grpc.example.healthmonitoring.UserStepsResponse(this);
      result.currentSteps_ = currentSteps_;
      result.goalAchieved_ = goalAchieved_;
      result.averageSteps_ = averageSteps_;
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
      if (other instanceof grpc.example.healthmonitoring.UserStepsResponse) {
        return mergeFrom((grpc.example.healthmonitoring.UserStepsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.healthmonitoring.UserStepsResponse other) {
      if (other == grpc.example.healthmonitoring.UserStepsResponse.getDefaultInstance()) return this;
      if (other.getCurrentSteps() != 0) {
        setCurrentSteps(other.getCurrentSteps());
      }
      if (other.getGoalAchieved() != false) {
        setGoalAchieved(other.getGoalAchieved());
      }
      if (other.getAverageSteps() != 0) {
        setAverageSteps(other.getAverageSteps());
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
      grpc.example.healthmonitoring.UserStepsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.healthmonitoring.UserStepsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int currentSteps_ ;
    /**
     * <code>int32 current_steps = 1;</code>
     */
    public int getCurrentSteps() {
      return currentSteps_;
    }
    /**
     * <code>int32 current_steps = 1;</code>
     */
    public Builder setCurrentSteps(int value) {
      
      currentSteps_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 current_steps = 1;</code>
     */
    public Builder clearCurrentSteps() {
      
      currentSteps_ = 0;
      onChanged();
      return this;
    }

    private boolean goalAchieved_ ;
    /**
     * <code>bool goal_achieved = 2;</code>
     */
    public boolean getGoalAchieved() {
      return goalAchieved_;
    }
    /**
     * <code>bool goal_achieved = 2;</code>
     */
    public Builder setGoalAchieved(boolean value) {
      
      goalAchieved_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool goal_achieved = 2;</code>
     */
    public Builder clearGoalAchieved() {
      
      goalAchieved_ = false;
      onChanged();
      return this;
    }

    private int averageSteps_ ;
    /**
     * <code>int32 average_steps = 3;</code>
     */
    public int getAverageSteps() {
      return averageSteps_;
    }
    /**
     * <code>int32 average_steps = 3;</code>
     */
    public Builder setAverageSteps(int value) {
      
      averageSteps_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 average_steps = 3;</code>
     */
    public Builder clearAverageSteps() {
      
      averageSteps_ = 0;
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


    // @@protoc_insertion_point(builder_scope:UserStepsResponse)
  }

  // @@protoc_insertion_point(class_scope:UserStepsResponse)
  private static final grpc.example.healthmonitoring.UserStepsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.healthmonitoring.UserStepsResponse();
  }

  public static grpc.example.healthmonitoring.UserStepsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserStepsResponse>
      PARSER = new com.google.protobuf.AbstractParser<UserStepsResponse>() {
    @java.lang.Override
    public UserStepsResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserStepsResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserStepsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserStepsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.healthmonitoring.UserStepsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

