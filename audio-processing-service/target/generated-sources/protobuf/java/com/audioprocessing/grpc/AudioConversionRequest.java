// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: audio_service.proto

package com.audioprocessing.grpc;

/**
 * <pre>
 * Mensagens para conversão
 * </pre>
 *
 * Protobuf type {@code audioprocessing.AudioConversionRequest}
 */
public final class AudioConversionRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:audioprocessing.AudioConversionRequest)
    AudioConversionRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AudioConversionRequest.newBuilder() to construct.
  private AudioConversionRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AudioConversionRequest() {
    fileId_ = "";
    targetFormat_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AudioConversionRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioConversionRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioConversionRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.audioprocessing.grpc.AudioConversionRequest.class, com.audioprocessing.grpc.AudioConversionRequest.Builder.class);
  }

  private int bitField0_;
  public static final int FILE_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object fileId_ = "";
  /**
   * <code>string file_id = 1;</code>
   * @return The fileId.
   */
  @java.lang.Override
  public java.lang.String getFileId() {
    java.lang.Object ref = fileId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fileId_ = s;
      return s;
    }
  }
  /**
   * <code>string file_id = 1;</code>
   * @return The bytes for fileId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFileIdBytes() {
    java.lang.Object ref = fileId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fileId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TARGET_FORMAT_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object targetFormat_ = "";
  /**
   * <code>string target_format = 2;</code>
   * @return The targetFormat.
   */
  @java.lang.Override
  public java.lang.String getTargetFormat() {
    java.lang.Object ref = targetFormat_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      targetFormat_ = s;
      return s;
    }
  }
  /**
   * <code>string target_format = 2;</code>
   * @return The bytes for targetFormat.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTargetFormatBytes() {
    java.lang.Object ref = targetFormat_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      targetFormat_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPTIONS_FIELD_NUMBER = 3;
  private com.audioprocessing.grpc.ConversionOptions options_;
  /**
   * <code>.audioprocessing.ConversionOptions options = 3;</code>
   * @return Whether the options field is set.
   */
  @java.lang.Override
  public boolean hasOptions() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.audioprocessing.ConversionOptions options = 3;</code>
   * @return The options.
   */
  @java.lang.Override
  public com.audioprocessing.grpc.ConversionOptions getOptions() {
    return options_ == null ? com.audioprocessing.grpc.ConversionOptions.getDefaultInstance() : options_;
  }
  /**
   * <code>.audioprocessing.ConversionOptions options = 3;</code>
   */
  @java.lang.Override
  public com.audioprocessing.grpc.ConversionOptionsOrBuilder getOptionsOrBuilder() {
    return options_ == null ? com.audioprocessing.grpc.ConversionOptions.getDefaultInstance() : options_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fileId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fileId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetFormat_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, targetFormat_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getOptions());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fileId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fileId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetFormat_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, targetFormat_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getOptions());
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
    if (!(obj instanceof com.audioprocessing.grpc.AudioConversionRequest)) {
      return super.equals(obj);
    }
    com.audioprocessing.grpc.AudioConversionRequest other = (com.audioprocessing.grpc.AudioConversionRequest) obj;

    if (!getFileId()
        .equals(other.getFileId())) return false;
    if (!getTargetFormat()
        .equals(other.getTargetFormat())) return false;
    if (hasOptions() != other.hasOptions()) return false;
    if (hasOptions()) {
      if (!getOptions()
          .equals(other.getOptions())) return false;
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
    hash = (37 * hash) + FILE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getFileId().hashCode();
    hash = (37 * hash) + TARGET_FORMAT_FIELD_NUMBER;
    hash = (53 * hash) + getTargetFormat().hashCode();
    if (hasOptions()) {
      hash = (37 * hash) + OPTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getOptions().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.audioprocessing.grpc.AudioConversionRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.audioprocessing.grpc.AudioConversionRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.AudioConversionRequest parseFrom(
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
  public static Builder newBuilder(com.audioprocessing.grpc.AudioConversionRequest prototype) {
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
   * <pre>
   * Mensagens para conversão
   * </pre>
   *
   * Protobuf type {@code audioprocessing.AudioConversionRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:audioprocessing.AudioConversionRequest)
      com.audioprocessing.grpc.AudioConversionRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioConversionRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioConversionRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.audioprocessing.grpc.AudioConversionRequest.class, com.audioprocessing.grpc.AudioConversionRequest.Builder.class);
    }

    // Construct using com.audioprocessing.grpc.AudioConversionRequest.newBuilder()
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
        getOptionsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      fileId_ = "";
      targetFormat_ = "";
      options_ = null;
      if (optionsBuilder_ != null) {
        optionsBuilder_.dispose();
        optionsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_AudioConversionRequest_descriptor;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioConversionRequest getDefaultInstanceForType() {
      return com.audioprocessing.grpc.AudioConversionRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioConversionRequest build() {
      com.audioprocessing.grpc.AudioConversionRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.AudioConversionRequest buildPartial() {
      com.audioprocessing.grpc.AudioConversionRequest result = new com.audioprocessing.grpc.AudioConversionRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.audioprocessing.grpc.AudioConversionRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.fileId_ = fileId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.targetFormat_ = targetFormat_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.options_ = optionsBuilder_ == null
            ? options_
            : optionsBuilder_.build();
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
      if (other instanceof com.audioprocessing.grpc.AudioConversionRequest) {
        return mergeFrom((com.audioprocessing.grpc.AudioConversionRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.audioprocessing.grpc.AudioConversionRequest other) {
      if (other == com.audioprocessing.grpc.AudioConversionRequest.getDefaultInstance()) return this;
      if (!other.getFileId().isEmpty()) {
        fileId_ = other.fileId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getTargetFormat().isEmpty()) {
        targetFormat_ = other.targetFormat_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (other.hasOptions()) {
        mergeOptions(other.getOptions());
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
              fileId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              targetFormat_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getOptionsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
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

    private java.lang.Object fileId_ = "";
    /**
     * <code>string file_id = 1;</code>
     * @return The fileId.
     */
    public java.lang.String getFileId() {
      java.lang.Object ref = fileId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fileId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string file_id = 1;</code>
     * @return The bytes for fileId.
     */
    public com.google.protobuf.ByteString
        getFileIdBytes() {
      java.lang.Object ref = fileId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fileId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string file_id = 1;</code>
     * @param value The fileId to set.
     * @return This builder for chaining.
     */
    public Builder setFileId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      fileId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string file_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFileId() {
      fileId_ = getDefaultInstance().getFileId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string file_id = 1;</code>
     * @param value The bytes for fileId to set.
     * @return This builder for chaining.
     */
    public Builder setFileIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      fileId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object targetFormat_ = "";
    /**
     * <code>string target_format = 2;</code>
     * @return The targetFormat.
     */
    public java.lang.String getTargetFormat() {
      java.lang.Object ref = targetFormat_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        targetFormat_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string target_format = 2;</code>
     * @return The bytes for targetFormat.
     */
    public com.google.protobuf.ByteString
        getTargetFormatBytes() {
      java.lang.Object ref = targetFormat_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        targetFormat_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string target_format = 2;</code>
     * @param value The targetFormat to set.
     * @return This builder for chaining.
     */
    public Builder setTargetFormat(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      targetFormat_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string target_format = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTargetFormat() {
      targetFormat_ = getDefaultInstance().getTargetFormat();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string target_format = 2;</code>
     * @param value The bytes for targetFormat to set.
     * @return This builder for chaining.
     */
    public Builder setTargetFormatBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      targetFormat_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private com.audioprocessing.grpc.ConversionOptions options_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.audioprocessing.grpc.ConversionOptions, com.audioprocessing.grpc.ConversionOptions.Builder, com.audioprocessing.grpc.ConversionOptionsOrBuilder> optionsBuilder_;
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     * @return Whether the options field is set.
     */
    public boolean hasOptions() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     * @return The options.
     */
    public com.audioprocessing.grpc.ConversionOptions getOptions() {
      if (optionsBuilder_ == null) {
        return options_ == null ? com.audioprocessing.grpc.ConversionOptions.getDefaultInstance() : options_;
      } else {
        return optionsBuilder_.getMessage();
      }
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public Builder setOptions(com.audioprocessing.grpc.ConversionOptions value) {
      if (optionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        options_ = value;
      } else {
        optionsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public Builder setOptions(
        com.audioprocessing.grpc.ConversionOptions.Builder builderForValue) {
      if (optionsBuilder_ == null) {
        options_ = builderForValue.build();
      } else {
        optionsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public Builder mergeOptions(com.audioprocessing.grpc.ConversionOptions value) {
      if (optionsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          options_ != null &&
          options_ != com.audioprocessing.grpc.ConversionOptions.getDefaultInstance()) {
          getOptionsBuilder().mergeFrom(value);
        } else {
          options_ = value;
        }
      } else {
        optionsBuilder_.mergeFrom(value);
      }
      if (options_ != null) {
        bitField0_ |= 0x00000004;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public Builder clearOptions() {
      bitField0_ = (bitField0_ & ~0x00000004);
      options_ = null;
      if (optionsBuilder_ != null) {
        optionsBuilder_.dispose();
        optionsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public com.audioprocessing.grpc.ConversionOptions.Builder getOptionsBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getOptionsFieldBuilder().getBuilder();
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    public com.audioprocessing.grpc.ConversionOptionsOrBuilder getOptionsOrBuilder() {
      if (optionsBuilder_ != null) {
        return optionsBuilder_.getMessageOrBuilder();
      } else {
        return options_ == null ?
            com.audioprocessing.grpc.ConversionOptions.getDefaultInstance() : options_;
      }
    }
    /**
     * <code>.audioprocessing.ConversionOptions options = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.audioprocessing.grpc.ConversionOptions, com.audioprocessing.grpc.ConversionOptions.Builder, com.audioprocessing.grpc.ConversionOptionsOrBuilder> 
        getOptionsFieldBuilder() {
      if (optionsBuilder_ == null) {
        optionsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.audioprocessing.grpc.ConversionOptions, com.audioprocessing.grpc.ConversionOptions.Builder, com.audioprocessing.grpc.ConversionOptionsOrBuilder>(
                getOptions(),
                getParentForChildren(),
                isClean());
        options_ = null;
      }
      return optionsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:audioprocessing.AudioConversionRequest)
  }

  // @@protoc_insertion_point(class_scope:audioprocessing.AudioConversionRequest)
  private static final com.audioprocessing.grpc.AudioConversionRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.audioprocessing.grpc.AudioConversionRequest();
  }

  public static com.audioprocessing.grpc.AudioConversionRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AudioConversionRequest>
      PARSER = new com.google.protobuf.AbstractParser<AudioConversionRequest>() {
    @java.lang.Override
    public AudioConversionRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<AudioConversionRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AudioConversionRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.audioprocessing.grpc.AudioConversionRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

