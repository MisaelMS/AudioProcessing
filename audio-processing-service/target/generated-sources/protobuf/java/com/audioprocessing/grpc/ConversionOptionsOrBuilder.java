// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: audio_service.proto

package com.audioprocessing.grpc;

public interface ConversionOptionsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:audioprocessing.ConversionOptions)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 sample_rate = 1;</code>
   * @return The sampleRate.
   */
  int getSampleRate();

  /**
   * <code>int32 channels = 2;</code>
   * @return The channels.
   */
  int getChannels();

  /**
   * <code>int32 bit_depth = 3;</code>
   * @return The bitDepth.
   */
  int getBitDepth();

  /**
   * <code>int32 quality = 4;</code>
   * @return The quality.
   */
  int getQuality();
}
