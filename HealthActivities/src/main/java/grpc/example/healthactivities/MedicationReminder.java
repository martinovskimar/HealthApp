// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: healthActivities.proto

package grpc.example.healthactivities;

/**
 * Protobuf type {@code health_activities.MedicationReminder}
 */
public  final class MedicationReminder extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:health_activities.MedicationReminder)
    MedicationReminderOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MedicationReminder.newBuilder() to construct.
  private MedicationReminder(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MedicationReminder() {
    time_ = "";
    medication_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MedicationReminder(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            time_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            medication_ = s;
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
    return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_MedicationReminder_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_MedicationReminder_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.example.healthactivities.MedicationReminder.class, grpc.example.healthactivities.MedicationReminder.Builder.class);
  }

  public static final int TIME_FIELD_NUMBER = 1;
  private volatile java.lang.Object time_;
  /**
   * <pre>
   * The time of the medication reminder.
   * </pre>
   *
   * <code>string time = 1;</code>
   */
  public java.lang.String getTime() {
    java.lang.Object ref = time_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      time_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The time of the medication reminder.
   * </pre>
   *
   * <code>string time = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTimeBytes() {
    java.lang.Object ref = time_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      time_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MEDICATION_FIELD_NUMBER = 2;
  private volatile java.lang.Object medication_;
  /**
   * <pre>
   * The name of the medication.
   * </pre>
   *
   * <code>string medication = 2;</code>
   */
  public java.lang.String getMedication() {
    java.lang.Object ref = medication_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      medication_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The name of the medication.
   * </pre>
   *
   * <code>string medication = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMedicationBytes() {
    java.lang.Object ref = medication_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      medication_ = b;
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
    if (!getTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, time_);
    }
    if (!getMedicationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, medication_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, time_);
    }
    if (!getMedicationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, medication_);
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
    if (!(obj instanceof grpc.example.healthactivities.MedicationReminder)) {
      return super.equals(obj);
    }
    grpc.example.healthactivities.MedicationReminder other = (grpc.example.healthactivities.MedicationReminder) obj;

    boolean result = true;
    result = result && getTime()
        .equals(other.getTime());
    result = result && getMedication()
        .equals(other.getMedication());
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
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + getTime().hashCode();
    hash = (37 * hash) + MEDICATION_FIELD_NUMBER;
    hash = (53 * hash) + getMedication().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthactivities.MedicationReminder parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.MedicationReminder parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.example.healthactivities.MedicationReminder parseFrom(
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
  public static Builder newBuilder(grpc.example.healthactivities.MedicationReminder prototype) {
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
   * Protobuf type {@code health_activities.MedicationReminder}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:health_activities.MedicationReminder)
      grpc.example.healthactivities.MedicationReminderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_MedicationReminder_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_MedicationReminder_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.example.healthactivities.MedicationReminder.class, grpc.example.healthactivities.MedicationReminder.Builder.class);
    }

    // Construct using grpc.example.healthactivities.MedicationReminder.newBuilder()
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
      time_ = "";

      medication_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.example.healthactivities.HealthActivitiesProto.internal_static_health_activities_MedicationReminder_descriptor;
    }

    @java.lang.Override
    public grpc.example.healthactivities.MedicationReminder getDefaultInstanceForType() {
      return grpc.example.healthactivities.MedicationReminder.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.example.healthactivities.MedicationReminder build() {
      grpc.example.healthactivities.MedicationReminder result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.example.healthactivities.MedicationReminder buildPartial() {
      grpc.example.healthactivities.MedicationReminder result = new grpc.example.healthactivities.MedicationReminder(this);
      result.time_ = time_;
      result.medication_ = medication_;
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
      if (other instanceof grpc.example.healthactivities.MedicationReminder) {
        return mergeFrom((grpc.example.healthactivities.MedicationReminder)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.example.healthactivities.MedicationReminder other) {
      if (other == grpc.example.healthactivities.MedicationReminder.getDefaultInstance()) return this;
      if (!other.getTime().isEmpty()) {
        time_ = other.time_;
        onChanged();
      }
      if (!other.getMedication().isEmpty()) {
        medication_ = other.medication_;
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
      grpc.example.healthactivities.MedicationReminder parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.example.healthactivities.MedicationReminder) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object time_ = "";
    /**
     * <pre>
     * The time of the medication reminder.
     * </pre>
     *
     * <code>string time = 1;</code>
     */
    public java.lang.String getTime() {
      java.lang.Object ref = time_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        time_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The time of the medication reminder.
     * </pre>
     *
     * <code>string time = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTimeBytes() {
      java.lang.Object ref = time_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        time_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The time of the medication reminder.
     * </pre>
     *
     * <code>string time = 1;</code>
     */
    public Builder setTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The time of the medication reminder.
     * </pre>
     *
     * <code>string time = 1;</code>
     */
    public Builder clearTime() {
      
      time_ = getDefaultInstance().getTime();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The time of the medication reminder.
     * </pre>
     *
     * <code>string time = 1;</code>
     */
    public Builder setTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      time_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object medication_ = "";
    /**
     * <pre>
     * The name of the medication.
     * </pre>
     *
     * <code>string medication = 2;</code>
     */
    public java.lang.String getMedication() {
      java.lang.Object ref = medication_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        medication_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The name of the medication.
     * </pre>
     *
     * <code>string medication = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMedicationBytes() {
      java.lang.Object ref = medication_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        medication_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The name of the medication.
     * </pre>
     *
     * <code>string medication = 2;</code>
     */
    public Builder setMedication(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      medication_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The name of the medication.
     * </pre>
     *
     * <code>string medication = 2;</code>
     */
    public Builder clearMedication() {
      
      medication_ = getDefaultInstance().getMedication();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The name of the medication.
     * </pre>
     *
     * <code>string medication = 2;</code>
     */
    public Builder setMedicationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      medication_ = value;
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


    // @@protoc_insertion_point(builder_scope:health_activities.MedicationReminder)
  }

  // @@protoc_insertion_point(class_scope:health_activities.MedicationReminder)
  private static final grpc.example.healthactivities.MedicationReminder DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.example.healthactivities.MedicationReminder();
  }

  public static grpc.example.healthactivities.MedicationReminder getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MedicationReminder>
      PARSER = new com.google.protobuf.AbstractParser<MedicationReminder>() {
    @java.lang.Override
    public MedicationReminder parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MedicationReminder(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MedicationReminder> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MedicationReminder> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.example.healthactivities.MedicationReminder getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

