// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthMonitoring.proto

package grpc.example.healthmonitoring;

/**
 * Protobuf type {@code UserHearthRateResponse}
 */
public  final class UserHearthRateResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UserHearthRateResponse)
    UserHearthRateResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UserHearthRateResponse.newBuilder() to construct.
  private UserHearthRateResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UserHearthRateResponse() {
    curentHearthRate_ = 0;
    warningMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UserHearthRateResponse(
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

            curentHearthRate_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            warningMessage_ = s;
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
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserHearthRateResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserHearthRateResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.healthmonitoring.UserHearthRateResponse.class, grpc.example.healthmonitoring.UserHearthRateResponse.Builder.class);
  }

  public static final int CURENT_HEARTH_RATE_FIELD_NUMBER = 1;
  private int curentHearthRate_;
  /**
   * <code>int32 curent_hearth_rate = 1;</code>
   */
  public int getCurentHearthRate() {
    return curentHearthRate_;
  }

  public static final int WARNING_MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object warningMessage_;
  /**
   * <code>string warning_message = 2;</code>
   */
  public java.lang.String getWarningMessage() {
    java.lang.Object ref = warningMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      warningMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string warning_message = 2;</code>
   */
  public com.google.protobuf.ByteString
      getWarningMessageBytes() {
    java.lang.Object ref = warningMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      warningMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (curentHearthRate_ != 0) {
      output.writeInt32(1, curentHearthRate_);
    }
    if (!getWarningMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, warningMessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (curentHearthRate_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, curentHearthRate_);
    }
    if (!getWarningMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, warningMessage_);
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
    if (!(obj instanceof grpc.example.healthmonitoring.UserHearthRateResponse)) {
      return super.equals(obj);
    }
    grpc.example.healthmonitoring.UserHearthRateResponse other = (grpc.example.healthmonitoring.UserHearthRateResponse) obj;

    boolean result = true;
    result = result && (getCurentHearthRate()
        == other.getCurentHearthRate());
    result = result && getWarningMessage()
        .equals(other.getWarningMessage());
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
    hash = (37 * hash) + CURENT_HEARTH_RATE_FIELD_NUMBER;
    hash = (53 * hash) + getCurentHearthRate();
    hash = (37 * hash) + WARNING_MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getWarningMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthmonitoring.UserHearthRateResponse parseFrom(
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
  public static Builder newBuilder(grpc.example.healthmonitoring.UserHearthRateResponse prototype) {
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
   * Protobuf type {@code UserHearthRateResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UserHearthRateResponse)
      grpc.example.healthmonitoring.UserHearthRateResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserHearthRateResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserHearthRateResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.healthmonitoring.UserHearthRateResponse.class, grpc.example.healthmonitoring.UserHearthRateResponse.Builder.class);
    }

    // Construct using grpc.example.healthmonitoring.UserHearthRateResponse.newBuilder()
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
      curentHearthRate_ = 0;

      warningMessage_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.healthmonitoring.healthMonitoringProto.internal_static_UserHearthRateResponse_descriptor;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserHearthRateResponse getDefaultInstanceForType() {
      return grpc.example.healthmonitoring.UserHearthRateResponse.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserHearthRateResponse build() {
      grpc.example.healthmonitoring.UserHearthRateResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.healthmonitoring.UserHearthRateResponse buildPartial() {
      grpc.example.healthmonitoring.UserHearthRateResponse result = new grpc.example.healthmonitoring.UserHearthRateResponse(this);
      result.curentHearthRate_ = curentHearthRate_;
      result.warningMessage_ = warningMessage_;
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
      if (other instanceof grpc.example.healthmonitoring.UserHearthRateResponse) {
        return mergeFrom((grpc.example.healthmonitoring.UserHearthRateResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.healthmonitoring.UserHearthRateResponse other) {
      if (other == grpc.example.healthmonitoring.UserHearthRateResponse.getDefaultInstance()) return this;
      if (other.getCurentHearthRate() != 0) {
        setCurentHearthRate(other.getCurentHearthRate());
      }
      if (!other.getWarningMessage().isEmpty()) {
        warningMessage_ = other.warningMessage_;
        onChanged();
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
      grpc.example.healthmonitoring.UserHearthRateResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.healthmonitoring.UserHearthRateResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int curentHearthRate_ ;
    /**
     * <code>int32 curent_hearth_rate = 1;</code>
     */
    public int getCurentHearthRate() {
      return curentHearthRate_;
    }
    /**
     * <code>int32 curent_hearth_rate = 1;</code>
     */
    public Builder setCurentHearthRate(int value) {
      
      curentHearthRate_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 curent_hearth_rate = 1;</code>
     */
    public Builder clearCurentHearthRate() {
      
      curentHearthRate_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object warningMessage_ = "";
    /**
     * <code>string warning_message = 2;</code>
     */
    public java.lang.String getWarningMessage() {
      java.lang.Object ref = warningMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        warningMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string warning_message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getWarningMessageBytes() {
      java.lang.Object ref = warningMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        warningMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string warning_message = 2;</code>
     */
    public Builder setWarningMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      warningMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string warning_message = 2;</code>
     */
    public Builder clearWarningMessage() {
      
      warningMessage_ = getDefaultInstance().getWarningMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string warning_message = 2;</code>
     */
    public Builder setWarningMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      warningMessage_ = value;
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


    // @@protoc_insertion_point(builder_scope:UserHearthRateResponse)
  }

  // @@protoc_insertion_point(class_scope:UserHearthRateResponse)
  private static final grpc.example.healthmonitoring.UserHearthRateResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.healthmonitoring.UserHearthRateResponse();
  }

  public static grpc.example.healthmonitoring.UserHearthRateResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UserHearthRateResponse>
      PARSER = new com.google.protobuf.AbstractParser<UserHearthRateResponse>() {
    @java.lang.Override
    public UserHearthRateResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserHearthRateResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UserHearthRateResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UserHearthRateResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.healthmonitoring.UserHearthRateResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

