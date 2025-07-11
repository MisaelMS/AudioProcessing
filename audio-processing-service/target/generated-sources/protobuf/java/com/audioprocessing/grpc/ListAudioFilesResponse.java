// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: audio_service.proto

package com.audioprocessing.grpc;

/**
 * Protobuf type {@code audioprocessing.ListAudioFilesResponse}
 */
public final class ListAudioFilesResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:audioprocessing.ListAudioFilesResponse)
    ListAudioFilesResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListAudioFilesResponse.newBuilder() to construct.
  private ListAudioFilesResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListAudioFilesResponse() {
    files_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ListAudioFilesResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_ListAudioFilesResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_ListAudioFilesResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.audioprocessing.grpc.ListAudioFilesResponse.class, com.audioprocessing.grpc.ListAudioFilesResponse.Builder.class);
  }

  public static final int FILES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.audioprocessing.grpc.AudioInfoResponse> files_;
  /**
   * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.audioprocessing.grpc.AudioInfoResponse> getFilesList() {
    return files_;
  }
  /**
   * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.audioprocessing.grpc.AudioInfoResponseOrBuilder> 
      getFilesOrBuilderList() {
    return files_;
  }
  /**
   * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
   */
  @java.lang.Override
  public int getFilesCount() {
    return files_.size();
  }
  /**
   * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
   */
  @java.lang.Override
  public com.audioprocessing.grpc.AudioInfoResponse getFiles(int index) {
    return files_.get(index);
  }
  /**
   * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
   */
  @java.lang.Override
  public com.audioprocessing.grpc.AudioInfoResponseOrBuilder getFilesOrBuilder(
      int index) {
    return files_.get(index);
  }

  public static final int TOTAL_COUNT_FIELD_NUMBER = 2;
  private int totalCount_ = 0;
  /**
   * <code>int32 total_count = 2;</code>
   * @return The totalCount.
   */
  @java.lang.Override
  public int getTotalCount() {
    return totalCount_;
  }

  public static final int CURRENT_PAGE_FIELD_NUMBER = 3;
  private int currentPage_ = 0;
  /**
   * <code>int32 current_page = 3;</code>
   * @return The currentPage.
   */
  @java.lang.Override
  public int getCurrentPage() {
    return currentPage_;
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
    for (int i = 0; i < files_.size(); i++) {
      output.writeMessage(1, files_.get(i));
    }
    if (totalCount_ != 0) {
      output.writeInt32(2, totalCount_);
    }
    if (currentPage_ != 0) {
      output.writeInt32(3, currentPage_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < files_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, files_.get(i));
    }
    if (totalCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, totalCount_);
    }
    if (currentPage_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, currentPage_);
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
    if (!(obj instanceof com.audioprocessing.grpc.ListAudioFilesResponse)) {
      return super.equals(obj);
    }
    com.audioprocessing.grpc.ListAudioFilesResponse other = (com.audioprocessing.grpc.ListAudioFilesResponse) obj;

    if (!getFilesList()
        .equals(other.getFilesList())) return false;
    if (getTotalCount()
        != other.getTotalCount()) return false;
    if (getCurrentPage()
        != other.getCurrentPage()) return false;
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
    if (getFilesCount() > 0) {
      hash = (37 * hash) + FILES_FIELD_NUMBER;
      hash = (53 * hash) + getFilesList().hashCode();
    }
    hash = (37 * hash) + TOTAL_COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getTotalCount();
    hash = (37 * hash) + CURRENT_PAGE_FIELD_NUMBER;
    hash = (53 * hash) + getCurrentPage();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.audioprocessing.grpc.ListAudioFilesResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.audioprocessing.grpc.ListAudioFilesResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.audioprocessing.grpc.ListAudioFilesResponse parseFrom(
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
  public static Builder newBuilder(com.audioprocessing.grpc.ListAudioFilesResponse prototype) {
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
   * Protobuf type {@code audioprocessing.ListAudioFilesResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:audioprocessing.ListAudioFilesResponse)
      com.audioprocessing.grpc.ListAudioFilesResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_ListAudioFilesResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_ListAudioFilesResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.audioprocessing.grpc.ListAudioFilesResponse.class, com.audioprocessing.grpc.ListAudioFilesResponse.Builder.class);
    }

    // Construct using com.audioprocessing.grpc.ListAudioFilesResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (filesBuilder_ == null) {
        files_ = java.util.Collections.emptyList();
      } else {
        files_ = null;
        filesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      totalCount_ = 0;
      currentPage_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.audioprocessing.grpc.AudioServiceProto.internal_static_audioprocessing_ListAudioFilesResponse_descriptor;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.ListAudioFilesResponse getDefaultInstanceForType() {
      return com.audioprocessing.grpc.ListAudioFilesResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.audioprocessing.grpc.ListAudioFilesResponse build() {
      com.audioprocessing.grpc.ListAudioFilesResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.audioprocessing.grpc.ListAudioFilesResponse buildPartial() {
      com.audioprocessing.grpc.ListAudioFilesResponse result = new com.audioprocessing.grpc.ListAudioFilesResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.audioprocessing.grpc.ListAudioFilesResponse result) {
      if (filesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          files_ = java.util.Collections.unmodifiableList(files_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.files_ = files_;
      } else {
        result.files_ = filesBuilder_.build();
      }
    }

    private void buildPartial0(com.audioprocessing.grpc.ListAudioFilesResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.totalCount_ = totalCount_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.currentPage_ = currentPage_;
      }
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
      if (other instanceof com.audioprocessing.grpc.ListAudioFilesResponse) {
        return mergeFrom((com.audioprocessing.grpc.ListAudioFilesResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.audioprocessing.grpc.ListAudioFilesResponse other) {
      if (other == com.audioprocessing.grpc.ListAudioFilesResponse.getDefaultInstance()) return this;
      if (filesBuilder_ == null) {
        if (!other.files_.isEmpty()) {
          if (files_.isEmpty()) {
            files_ = other.files_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureFilesIsMutable();
            files_.addAll(other.files_);
          }
          onChanged();
        }
      } else {
        if (!other.files_.isEmpty()) {
          if (filesBuilder_.isEmpty()) {
            filesBuilder_.dispose();
            filesBuilder_ = null;
            files_ = other.files_;
            bitField0_ = (bitField0_ & ~0x00000001);
            filesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFilesFieldBuilder() : null;
          } else {
            filesBuilder_.addAllMessages(other.files_);
          }
        }
      }
      if (other.getTotalCount() != 0) {
        setTotalCount(other.getTotalCount());
      }
      if (other.getCurrentPage() != 0) {
        setCurrentPage(other.getCurrentPage());
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
              com.audioprocessing.grpc.AudioInfoResponse m =
                  input.readMessage(
                      com.audioprocessing.grpc.AudioInfoResponse.parser(),
                      extensionRegistry);
              if (filesBuilder_ == null) {
                ensureFilesIsMutable();
                files_.add(m);
              } else {
                filesBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 16: {
              totalCount_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 24: {
              currentPage_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
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

    private java.util.List<com.audioprocessing.grpc.AudioInfoResponse> files_ =
      java.util.Collections.emptyList();
    private void ensureFilesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        files_ = new java.util.ArrayList<com.audioprocessing.grpc.AudioInfoResponse>(files_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.audioprocessing.grpc.AudioInfoResponse, com.audioprocessing.grpc.AudioInfoResponse.Builder, com.audioprocessing.grpc.AudioInfoResponseOrBuilder> filesBuilder_;

    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public java.util.List<com.audioprocessing.grpc.AudioInfoResponse> getFilesList() {
      if (filesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(files_);
      } else {
        return filesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public int getFilesCount() {
      if (filesBuilder_ == null) {
        return files_.size();
      } else {
        return filesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public com.audioprocessing.grpc.AudioInfoResponse getFiles(int index) {
      if (filesBuilder_ == null) {
        return files_.get(index);
      } else {
        return filesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder setFiles(
        int index, com.audioprocessing.grpc.AudioInfoResponse value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.set(index, value);
        onChanged();
      } else {
        filesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder setFiles(
        int index, com.audioprocessing.grpc.AudioInfoResponse.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.set(index, builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder addFiles(com.audioprocessing.grpc.AudioInfoResponse value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.add(value);
        onChanged();
      } else {
        filesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder addFiles(
        int index, com.audioprocessing.grpc.AudioInfoResponse value) {
      if (filesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFilesIsMutable();
        files_.add(index, value);
        onChanged();
      } else {
        filesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder addFiles(
        com.audioprocessing.grpc.AudioInfoResponse.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.add(builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder addFiles(
        int index, com.audioprocessing.grpc.AudioInfoResponse.Builder builderForValue) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.add(index, builderForValue.build());
        onChanged();
      } else {
        filesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder addAllFiles(
        java.lang.Iterable<? extends com.audioprocessing.grpc.AudioInfoResponse> values) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, files_);
        onChanged();
      } else {
        filesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder clearFiles() {
      if (filesBuilder_ == null) {
        files_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        filesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public Builder removeFiles(int index) {
      if (filesBuilder_ == null) {
        ensureFilesIsMutable();
        files_.remove(index);
        onChanged();
      } else {
        filesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public com.audioprocessing.grpc.AudioInfoResponse.Builder getFilesBuilder(
        int index) {
      return getFilesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public com.audioprocessing.grpc.AudioInfoResponseOrBuilder getFilesOrBuilder(
        int index) {
      if (filesBuilder_ == null) {
        return files_.get(index);  } else {
        return filesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public java.util.List<? extends com.audioprocessing.grpc.AudioInfoResponseOrBuilder> 
         getFilesOrBuilderList() {
      if (filesBuilder_ != null) {
        return filesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(files_);
      }
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public com.audioprocessing.grpc.AudioInfoResponse.Builder addFilesBuilder() {
      return getFilesFieldBuilder().addBuilder(
          com.audioprocessing.grpc.AudioInfoResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public com.audioprocessing.grpc.AudioInfoResponse.Builder addFilesBuilder(
        int index) {
      return getFilesFieldBuilder().addBuilder(
          index, com.audioprocessing.grpc.AudioInfoResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .audioprocessing.AudioInfoResponse files = 1;</code>
     */
    public java.util.List<com.audioprocessing.grpc.AudioInfoResponse.Builder> 
         getFilesBuilderList() {
      return getFilesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.audioprocessing.grpc.AudioInfoResponse, com.audioprocessing.grpc.AudioInfoResponse.Builder, com.audioprocessing.grpc.AudioInfoResponseOrBuilder> 
        getFilesFieldBuilder() {
      if (filesBuilder_ == null) {
        filesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.audioprocessing.grpc.AudioInfoResponse, com.audioprocessing.grpc.AudioInfoResponse.Builder, com.audioprocessing.grpc.AudioInfoResponseOrBuilder>(
                files_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        files_ = null;
      }
      return filesBuilder_;
    }

    private int totalCount_ ;
    /**
     * <code>int32 total_count = 2;</code>
     * @return The totalCount.
     */
    @java.lang.Override
    public int getTotalCount() {
      return totalCount_;
    }
    /**
     * <code>int32 total_count = 2;</code>
     * @param value The totalCount to set.
     * @return This builder for chaining.
     */
    public Builder setTotalCount(int value) {

      totalCount_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 total_count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTotalCount() {
      bitField0_ = (bitField0_ & ~0x00000002);
      totalCount_ = 0;
      onChanged();
      return this;
    }

    private int currentPage_ ;
    /**
     * <code>int32 current_page = 3;</code>
     * @return The currentPage.
     */
    @java.lang.Override
    public int getCurrentPage() {
      return currentPage_;
    }
    /**
     * <code>int32 current_page = 3;</code>
     * @param value The currentPage to set.
     * @return This builder for chaining.
     */
    public Builder setCurrentPage(int value) {

      currentPage_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 current_page = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCurrentPage() {
      bitField0_ = (bitField0_ & ~0x00000004);
      currentPage_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:audioprocessing.ListAudioFilesResponse)
  }

  // @@protoc_insertion_point(class_scope:audioprocessing.ListAudioFilesResponse)
  private static final com.audioprocessing.grpc.ListAudioFilesResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.audioprocessing.grpc.ListAudioFilesResponse();
  }

  public static com.audioprocessing.grpc.ListAudioFilesResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListAudioFilesResponse>
      PARSER = new com.google.protobuf.AbstractParser<ListAudioFilesResponse>() {
    @java.lang.Override
    public ListAudioFilesResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<ListAudioFilesResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListAudioFilesResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.audioprocessing.grpc.ListAudioFilesResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

