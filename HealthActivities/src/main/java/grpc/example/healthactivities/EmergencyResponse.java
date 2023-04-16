// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthActivities.proto

package grpc.example.healthactivities;

/**
 * Protobuf type {@code health_activities.EmergencyResponse}
 */
public  final class EmergencyResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:health_activities.EmergencyResponse)
    EmergencyResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmergencyResponse.newBuilder() to construct.
  private EmergencyResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmergencyResponse() {
    callAmbulance_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EmergencyResponse(
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

            callAmbulance_ = input.readBool();
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
    return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_EmergencyResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_EmergencyResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.healthactivities.EmergencyResponse.class, grpc.example.healthactivities.EmergencyResponse.Builder.class);
  }

  public static final int CALL_AMBULANCE_FIELD_NUMBER = 1;
  private boolean callAmbulance_;
  /**
   * <code>bool call_ambulance = 1;</code>
   */
  public boolean getCallAmbulance() {
    return callAmbulance_;
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
    if (callAmbulance_ != false) {
      output.writeBool(1, callAmbulance_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (callAmbulance_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, callAmbulance_);
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
    if (!(obj instanceof grpc.example.healthactivities.EmergencyResponse)) {
      return super.equals(obj);
    }
    grpc.example.healthactivities.EmergencyResponse other = (grpc.example.healthactivities.EmergencyResponse) obj;

    boolean result = true;
    result = result && (getCallAmbulance()
        == other.getCallAmbulance());
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
    hash = (37 * hash) + CALL_AMBULANCE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getCallAmbulance());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.EmergencyResponse parseFrom(
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
  public static Builder newBuilder(grpc.example.healthactivities.EmergencyResponse prototype) {
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
   * Protobuf type {@code health_activities.EmergencyResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:health_activities.EmergencyResponse)
      grpc.example.healthactivities.EmergencyResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_EmergencyResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_EmergencyResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.healthactivities.EmergencyResponse.class, grpc.example.healthactivities.EmergencyResponse.Builder.class);
    }

    // Construct using grpc.example.healthactivities.EmergencyResponse.newBuilder()
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
      callAmbulance_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_EmergencyResponse_descriptor;
    }

    @java.lang.Override
    public grpc.example.healthactivities.EmergencyResponse getDefaultInstanceForType() {
      return grpc.example.healthactivities.EmergencyResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.healthactivities.EmergencyResponse build() {
      grpc.example.healthactivities.EmergencyResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.healthactivities.EmergencyResponse buildPartial() {
      grpc.example.healthactivities.EmergencyResponse result = new grpc.example.healthactivities.EmergencyResponse(this);
      result.callAmbulance_ = callAmbulance_;
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
      if (other instanceof grpc.example.healthactivities.EmergencyResponse) {
        return mergeFrom((grpc.example.healthactivities.EmergencyResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.healthactivities.EmergencyResponse other) {
      if (other == grpc.example.healthactivities.EmergencyResponse.getDefaultInstance()) return this;
      if (other.getCallAmbulance() != false) {
        setCallAmbulance(other.getCallAmbulance());
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
      grpc.example.healthactivities.EmergencyResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.healthactivities.EmergencyResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean callAmbulance_ ;
    /**
     * <code>bool call_ambulance = 1;</code>
     */
    public boolean getCallAmbulance() {
      return callAmbulance_;
    }
    /**
     * <code>bool call_ambulance = 1;</code>
     */
    public Builder setCallAmbulance(boolean value) {
      
      callAmbulance_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool call_ambulance = 1;</code>
     */
    public Builder clearCallAmbulance() {
      
      callAmbulance_ = false;
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


    // @@protoc_insertion_point(builder_scope:health_activities.EmergencyResponse)
  }

  // @@protoc_insertion_point(class_scope:health_activities.EmergencyResponse)
  private static final grpc.example.healthactivities.EmergencyResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.healthactivities.EmergencyResponse();
  }

  public static grpc.example.healthactivities.EmergencyResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EmergencyResponse>
      PARSER = new com.google.protobuf.AbstractParser<EmergencyResponse>() {
    @java.lang.Override
    public EmergencyResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EmergencyResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EmergencyResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmergencyResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.healthactivities.EmergencyResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

