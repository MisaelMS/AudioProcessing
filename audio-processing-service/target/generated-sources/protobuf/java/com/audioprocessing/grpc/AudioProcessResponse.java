// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: audio_service.proto

package com.audioprocessing.grpc;

/**
 * Protobuf type {@code audioprocessing.AudioProcessResponse}
 */
public final class AudioProcessResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:audioprocessing.AudioProcessResponse)
    AudioProcessResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AudioProcessResponse.newBuilder() to construct.
  private AudioProcessResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AudioProcessResponse() {
    processedFileId_ = "";
    message_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AudioProcessResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioProcessResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioProcessResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.audioprocessing.grpc.AudioProcessResponse.class, com.audioprocessing.grpc.AudioProcessResponse.Builder.class);
  }

  private int bitField0_;
  public static final int PROCESSED_FILE_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object processedFileId_ = "";
  /**
   * <code>string processed_file_id = 1;</code>
   * @return The processedFileId.
   */
  @java.lang.Override
  public java.lang.String getProcessedFileId() {
    java.lang.Object ref = processedFileId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      processedFileId_ = s;
      return s;
    }
  }
  /**
   * <code>string processed_file_id = 1;</code>
   * @return The bytes for processedFileId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getProcessedFileIdBytes() {
    java.lang.Object ref = processedFileId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      processedFileId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SUCCESS_FIELD_NUMBER = 2;
  private boolean success_ = false;
  /**
   * <code>bool success = 2;</code>
   * @return The success.
   */
  @java.lang.Override
  public boolean getSuccess() {
    return success_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object message_ = "";
  /**
   * <code>string message = 3;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 3;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STATS_FIELD_NUMBER = 4;
  private com.audioprocessing.grpc.ProcessingStats stats_;
  /**
   * <code>.audioprocessing.ProcessingStats stats = 4;</code>
   * @return Whether the stats field is set.
   */
  @java.lang.Override
  public boolean hasStats() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.audioprocessing.ProcessingStats stats = 4;</code>
   * @return The stats.
   */
  @java.lang.Override
  public com.audioprocessing.grpc.ProcessingStats getStats() {
    return stats_ == null ? com.audioprocessing.grpc.ProcessingStats.getDefaultInstance() : stats_;
  }
  /**
   * <code>.audioprocessing.ProcessingStats stats = 4;</code>
   */
  @java.lang.Override
  public com.audioprocessing.grpc.ProcessingStatsOrBuilder getStatsOrBuilder() {
    return stats_ == null ? com.audioprocessing.grpc.ProcessingStats.getDefaultInstance() : stats_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(processedFileId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, processedFileId_);
    }
    if (success_ != false) {
      output.writeBool(2, success_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, message_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(4, getStats());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(processedFileId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, processedFileId_);
    }
    if (success_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, success_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(message_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, message_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getStats());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.audioprocessing.grpc.AudioProcessResponse)) {
      return super.equals(obj);
    }
    com.audioprocessing.grpc.AudioProcessResponse other = (com.audioprocessing.grpc.AudioProcessResponse) obj;

    if (!getProcessedFileId()
        .equals(other.getProcessedFileId())) return false;
    if (getSuccess()
        != other.getSuccess()) return false;
    if (!getMessage()
        .equals(other.getMessage())) return false;
    if (hasStats() != other.hasStats()) return false;
    if (hasStats()) {
      if (!getStats()
          .equals(other.getStats())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PROCESSED_FILE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getProcessedFileId().hashCode();
    hash = (37 * hash) + SUCCESS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getSuccess());
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    if (hasStats()) {
      hash = (37 * hash) + STATS_FIELD_NUMBER;
      hash = (53 * hash) + getStats().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.audioprocessing.grpc.AudioProcessResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.audioprocessing.grpc.AudioProcessResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.AudioProcessResponse parseFrom(
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
  public static Builder newBuilder(com.audioprocessing.grpc.AudioProcessResponse prototype) {
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
   * Protobuf type {@code audioprocessing.AudioProcessResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:audioprocessing.AudioProcessResponse)
      com.audioprocessing.grpc.AudioProcessResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioProcessResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioProcessResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.audioprocessing.grpc.AudioProcessResponse.class, com.audioprocessing.grpc.AudioProcessResponse.Builder.class);
    }

    // Construct using com.audioprocessing.grpc.AudioProcessResponse.newBuilder()
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
        getStatsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      processedFileId_ = "";
      success_ = false;
      message_ = "";
      stats_ = null;
      if (statsBuilder_ != null) {
        statsBuilder_.dispose();
        statsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioProcessResponse_descriptor;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioProcessResponse getDefaultInstanceForType() {
      return com.audioprocessing.grpc.AudioProcessResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioProcessResponse build() {
      com.audioprocessing.grpc.AudioProcessResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioProcessResponse buildPartial() {
      com.audioprocessing.grpc.AudioProcessResponse result = new com.audioprocessing.grpc.AudioProcessResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.audioprocessing.grpc.AudioProcessResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.processedFileId_ = processedFileId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.success_ = success_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.message_ = message_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.stats_ = statsBuilder_ == null
            ? stats_
            : statsBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.audioprocessing.grpc.AudioProcessResponse) {
        return mergeFrom((com.audioprocessing.grpc.AudioProcessResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.audioprocessing.grpc.AudioProcessResponse other) {
      if (other == com.audioprocessing.grpc.AudioProcessResponse.getDefaultInstance()) return this;
      if (!other.getProcessedFileId().isEmpty()) {
        processedFileId_ = other.processedFileId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getSuccess() != false) {
        setSuccess(other.getSuccess());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.hasStats()) {
        mergeStats(other.getStats());
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              processedFileId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              success_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              message_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              input.readMessage(
                  getStatsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object processedFileId_ = "";
    /**
     * <code>string processed_file_id = 1;</code>
     * @return The processedFileId.
     */
    public java.lang.String getProcessedFileId() {
      java.lang.Object ref = processedFileId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        processedFileId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string processed_file_id = 1;</code>
     * @return The bytes for processedFileId.
     */
    public com.google.protobuf.ByteString
        getProcessedFileIdBytes() {
      java.lang.Object ref = processedFileId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        processedFileId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string processed_file_id = 1;</code>
     * @param value The processedFileId to set.
     * @return This builder for chaining.
     */
    public Builder setProcessedFileId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      processedFileId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string processed_file_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearProcessedFileId() {
      processedFileId_ = getDefaultInstance().getProcessedFileId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string processed_file_id = 1;</code>
     * @param value The bytes for processedFileId to set.
     * @return This builder for chaining.
     */
    public Builder setProcessedFileIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      processedFileId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private boolean success_ ;
    /**
     * <code>bool success = 2;</code>
     * @return The success.
     */
    @java.lang.Override
    public boolean getSuccess() {
      return success_;
    }
    /**
     * <code>bool success = 2;</code>
     * @param value The success to set.
     * @return This builder for chaining.
     */
    public Builder setSuccess(boolean value) {

      success_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool success = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSuccess() {
      bitField0_ = (bitField0_ & ~0x00000002);
      success_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 3;</code>
     * @return The message.
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 3;</code>
     * @return The bytes for message.
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 3;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      message_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      message_ = getDefaultInstance().getMessage();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string message = 3;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      message_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private com.audioprocessing.grpc.ProcessingStats stats_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.audioprocessing.grpc.ProcessingStats, com.audioprocessing.grpc.ProcessingStats.Builder, com.audioprocessing.grpc.ProcessingStatsOrBuilder> statsBuilder_;
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     * @return Whether the stats field is set.
     */
    public boolean hasStats() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     * @return The stats.
     */
    public com.audioprocessing.grpc.ProcessingStats getStats() {
      if (statsBuilder_ == null) {
        return stats_ == null ? com.audioprocessing.grpc.ProcessingStats.getDefaultInstance() : stats_;
      } else {
        return statsBuilder_.getMessage();
      }
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public Builder setStats(com.audioprocessing.grpc.ProcessingStats value) {
      if (statsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stats_ = value;
      } else {
        statsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public Builder setStats(
        com.audioprocessing.grpc.ProcessingStats.Builder builderForValue) {
      if (statsBuilder_ == null) {
        stats_ = builderForValue.build();
      } else {
        statsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public Builder mergeStats(com.audioprocessing.grpc.ProcessingStats value) {
      if (statsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          stats_ != null &&
          stats_ != com.audioprocessing.grpc.ProcessingStats.getDefaultInstance()) {
          getStatsBuilder().mergeFrom(value);
        } else {
          stats_ = value;
        }
      } else {
        statsBuilder_.mergeFrom(value);
      }
      if (stats_ != null) {
        bitField0_ |= 0x00000008;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public Builder clearStats() {
      bitField0_ = (bitField0_ & ~0x00000008);
      stats_ = null;
      if (statsBuilder_ != null) {
        statsBuilder_.dispose();
        statsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public com.audioprocessing.grpc.ProcessingStats.Builder getStatsBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getStatsFieldBuilder().getBuilder();
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    public com.audioprocessing.grpc.ProcessingStatsOrBuilder getStatsOrBuilder() {
      if (statsBuilder_ != null) {
        return statsBuilder_.getMessageOrBuilder();
      } else {
        return stats_ == null ?
            com.audioprocessing.grpc.ProcessingStats.getDefaultInstance() : stats_;
      }
    }
    /**
     * <code>.audioprocessing.ProcessingStats stats = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.audioprocessing.grpc.ProcessingStats, com.audioprocessing.grpc.ProcessingStats.Builder, com.audioprocessing.grpc.ProcessingStatsOrBuilder> 
        getStatsFieldBuilder() {
      if (statsBuilder_ == null) {
        statsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.audioprocessing.grpc.ProcessingStats, com.audioprocessing.grpc.ProcessingStats.Builder, com.audioprocessing.grpc.ProcessingStatsOrBuilder>(
                getStats(),
                getParentForChildren(),
                isClean());
        stats_ = null;
      }
      return statsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:audioprocessing.AudioProcessResponse)
  }

  // @@protoc_insertion_point(class_scope:audioprocessing.AudioProcessResponse)
  private static final com.audioprocessing.grpc.AudioProcessResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.audioprocessing.grpc.AudioProcessResponse();
  }

  public static com.audioprocessing.grpc.AudioProcessResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AudioProcessResponse>
      PARSER = new com.google.protobuf.AbstractParser<AudioProcessResponse>() {
    @java.lang.Override
    public AudioProcessResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<AudioProcessResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AudioProcessResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.audioprocessing.grpc.AudioProcessResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

