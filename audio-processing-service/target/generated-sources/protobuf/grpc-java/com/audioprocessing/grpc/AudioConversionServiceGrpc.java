package com.audioprocessing.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Serviço de conversão de formatos
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: audio_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AudioConversionServiceGrpc {

  private AudioConversionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "audioprocessing.AudioConversionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioConversionRequest,
      com.audioprocessing.grpc.AudioConversionResponse> getConvertAudioFormatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConvertAudioFormat",
      requestType = com.audioprocessing.grpc.AudioConversionRequest.class,
      responseType = com.audioprocessing.grpc.AudioConversionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioConversionRequest,
      com.audioprocessing.grpc.AudioConversionResponse> getConvertAudioFormatMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioConversionRequest, com.audioprocessing.grpc.AudioConversionResponse> getConvertAudioFormatMethod;
    if ((getConvertAudioFormatMethod = AudioConversionServiceGrpc.getConvertAudioFormatMethod) == null) {
      synchronized (AudioConversionServiceGrpc.class) {
        if ((getConvertAudioFormatMethod = AudioConversionServiceGrpc.getConvertAudioFormatMethod) == null) {
          AudioConversionServiceGrpc.getConvertAudioFormatMethod = getConvertAudioFormatMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioConversionRequest, com.audioprocessing.grpc.AudioConversionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ConvertAudioFormat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioConversionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioConversionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioConversionServiceMethodDescriptorSupplier("ConvertAudioFormat"))
              .build();
        }
      }
    }
    return getConvertAudioFormatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.BatchConversionRequest,
      com.audioprocessing.grpc.AudioConversionResponse> getBatchConvertAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchConvertAudio",
      requestType = com.audioprocessing.grpc.BatchConversionRequest.class,
      responseType = com.audioprocessing.grpc.AudioConversionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.BatchConversionRequest,
      com.audioprocessing.grpc.AudioConversionResponse> getBatchConvertAudioMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.BatchConversionRequest, com.audioprocessing.grpc.AudioConversionResponse> getBatchConvertAudioMethod;
    if ((getBatchConvertAudioMethod = AudioConversionServiceGrpc.getBatchConvertAudioMethod) == null) {
      synchronized (AudioConversionServiceGrpc.class) {
        if ((getBatchConvertAudioMethod = AudioConversionServiceGrpc.getBatchConvertAudioMethod) == null) {
          AudioConversionServiceGrpc.getBatchConvertAudioMethod = getBatchConvertAudioMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.BatchConversionRequest, com.audioprocessing.grpc.AudioConversionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchConvertAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.BatchConversionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioConversionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioConversionServiceMethodDescriptorSupplier("BatchConvertAudio"))
              .build();
        }
      }
    }
    return getBatchConvertAudioMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AudioConversionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceStub>() {
        @java.lang.Override
        public AudioConversionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioConversionServiceStub(channel, callOptions);
        }
      };
    return AudioConversionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AudioConversionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceBlockingStub>() {
        @java.lang.Override
        public AudioConversionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioConversionServiceBlockingStub(channel, callOptions);
        }
      };
    return AudioConversionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AudioConversionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioConversionServiceFutureStub>() {
        @java.lang.Override
        public AudioConversionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioConversionServiceFutureStub(channel, callOptions);
        }
      };
    return AudioConversionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Serviço de conversão de formatos
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Converter formato de áudio
     * </pre>
     */
    default void convertAudioFormat(com.audioprocessing.grpc.AudioConversionRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConvertAudioFormatMethod(), responseObserver);
    }

    /**
     * <pre>
     * Converter para múltiplos formatos
     * </pre>
     */
    default void batchConvertAudio(com.audioprocessing.grpc.BatchConversionRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchConvertAudioMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AudioConversionService.
   * <pre>
   * Serviço de conversão de formatos
   * </pre>
   */
  public static abstract class AudioConversionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AudioConversionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AudioConversionService.
   * <pre>
   * Serviço de conversão de formatos
   * </pre>
   */
  public static final class AudioConversionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AudioConversionServiceStub> {
    private AudioConversionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioConversionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioConversionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converter formato de áudio
     * </pre>
     */
    public void convertAudioFormat(com.audioprocessing.grpc.AudioConversionRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConvertAudioFormatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Converter para múltiplos formatos
     * </pre>
     */
    public void batchConvertAudio(com.audioprocessing.grpc.BatchConversionRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBatchConvertAudioMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AudioConversionService.
   * <pre>
   * Serviço de conversão de formatos
   * </pre>
   */
  public static final class AudioConversionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AudioConversionServiceBlockingStub> {
    private AudioConversionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioConversionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioConversionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converter formato de áudio
     * </pre>
     */
    public com.audioprocessing.grpc.AudioConversionResponse convertAudioFormat(com.audioprocessing.grpc.AudioConversionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConvertAudioFormatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Converter para múltiplos formatos
     * </pre>
     */
    public java.util.Iterator<com.audioprocessing.grpc.AudioConversionResponse> batchConvertAudio(
        com.audioprocessing.grpc.BatchConversionRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBatchConvertAudioMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AudioConversionService.
   * <pre>
   * Serviço de conversão de formatos
   * </pre>
   */
  public static final class AudioConversionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AudioConversionServiceFutureStub> {
    private AudioConversionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioConversionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioConversionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Converter formato de áudio
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.AudioConversionResponse> convertAudioFormat(
        com.audioprocessing.grpc.AudioConversionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConvertAudioFormatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONVERT_AUDIO_FORMAT = 0;
  private static final int METHODID_BATCH_CONVERT_AUDIO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONVERT_AUDIO_FORMAT:
          serviceImpl.convertAudioFormat((com.audioprocessing.grpc.AudioConversionRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse>) responseObserver);
          break;
        case METHODID_BATCH_CONVERT_AUDIO:
          serviceImpl.batchConvertAudio((com.audioprocessing.grpc.BatchConversionRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioConversionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getConvertAudioFormatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioConversionRequest,
              com.audioprocessing.grpc.AudioConversionResponse>(
                service, METHODID_CONVERT_AUDIO_FORMAT)))
        .addMethod(
          getBatchConvertAudioMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.audioprocessing.grpc.BatchConversionRequest,
              com.audioprocessing.grpc.AudioConversionResponse>(
                service, METHODID_BATCH_CONVERT_AUDIO)))
        .build();
  }

  private static abstract class AudioConversionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AudioConversionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AudioConversionService");
    }
  }

  private static final class AudioConversionServiceFileDescriptorSupplier
      extends AudioConversionServiceBaseDescriptorSupplier {
    AudioConversionServiceFileDescriptorSupplier() {}
  }

  private static final class AudioConversionServiceMethodDescriptorSupplier
      extends AudioConversionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AudioConversionServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AudioConversionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AudioConversionServiceFileDescriptorSupplier())
              .addMethod(getConvertAudioFormatMethod())
              .addMethod(getBatchConvertAudioMethod())
              .build();
        }
      }
    }
    return result;
  }
}
