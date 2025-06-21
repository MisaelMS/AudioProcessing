package com.audioprocessing.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Serviço de análise de áudio
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: audio_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AudioAnalysisServiceGrpc {

  private AudioAnalysisServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "audioprocessing.AudioAnalysisService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.AudioAnalysisResponse> getAnalyzeFrequencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeFrequency",
      requestType = com.audioprocessing.grpc.AudioAnalysisRequest.class,
      responseType = com.audioprocessing.grpc.AudioAnalysisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.AudioAnalysisResponse> getAnalyzeFrequencyMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.AudioAnalysisResponse> getAnalyzeFrequencyMethod;
    if ((getAnalyzeFrequencyMethod = AudioAnalysisServiceGrpc.getAnalyzeFrequencyMethod) == null) {
      synchronized (AudioAnalysisServiceGrpc.class) {
        if ((getAnalyzeFrequencyMethod = AudioAnalysisServiceGrpc.getAnalyzeFrequencyMethod) == null) {
          AudioAnalysisServiceGrpc.getAnalyzeFrequencyMethod = getAnalyzeFrequencyMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.AudioAnalysisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeFrequency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioAnalysisResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioAnalysisServiceMethodDescriptorSupplier("AnalyzeFrequency"))
              .build();
        }
      }
    }
    return getAnalyzeFrequencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.SilenceDetectionResponse> getDetectSilenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetectSilence",
      requestType = com.audioprocessing.grpc.AudioAnalysisRequest.class,
      responseType = com.audioprocessing.grpc.SilenceDetectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.SilenceDetectionResponse> getDetectSilenceMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.SilenceDetectionResponse> getDetectSilenceMethod;
    if ((getDetectSilenceMethod = AudioAnalysisServiceGrpc.getDetectSilenceMethod) == null) {
      synchronized (AudioAnalysisServiceGrpc.class) {
        if ((getDetectSilenceMethod = AudioAnalysisServiceGrpc.getDetectSilenceMethod) == null) {
          AudioAnalysisServiceGrpc.getDetectSilenceMethod = getDetectSilenceMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.SilenceDetectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetectSilence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.SilenceDetectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioAnalysisServiceMethodDescriptorSupplier("DetectSilence"))
              .build();
        }
      }
    }
    return getDetectSilenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.AudioFeaturesResponse> getExtractFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExtractFeatures",
      requestType = com.audioprocessing.grpc.AudioAnalysisRequest.class,
      responseType = com.audioprocessing.grpc.AudioFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest,
      com.audioprocessing.grpc.AudioFeaturesResponse> getExtractFeaturesMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.AudioFeaturesResponse> getExtractFeaturesMethod;
    if ((getExtractFeaturesMethod = AudioAnalysisServiceGrpc.getExtractFeaturesMethod) == null) {
      synchronized (AudioAnalysisServiceGrpc.class) {
        if ((getExtractFeaturesMethod = AudioAnalysisServiceGrpc.getExtractFeaturesMethod) == null) {
          AudioAnalysisServiceGrpc.getExtractFeaturesMethod = getExtractFeaturesMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioAnalysisRequest, com.audioprocessing.grpc.AudioFeaturesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExtractFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioFeaturesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioAnalysisServiceMethodDescriptorSupplier("ExtractFeatures"))
              .build();
        }
      }
    }
    return getExtractFeaturesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AudioAnalysisServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceStub>() {
        @java.lang.Override
        public AudioAnalysisServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioAnalysisServiceStub(channel, callOptions);
        }
      };
    return AudioAnalysisServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AudioAnalysisServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceBlockingStub>() {
        @java.lang.Override
        public AudioAnalysisServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioAnalysisServiceBlockingStub(channel, callOptions);
        }
      };
    return AudioAnalysisServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AudioAnalysisServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioAnalysisServiceFutureStub>() {
        @java.lang.Override
        public AudioAnalysisServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioAnalysisServiceFutureStub(channel, callOptions);
        }
      };
    return AudioAnalysisServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Serviço de análise de áudio
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Analisar frequências do áudio
     * </pre>
     */
    default void analyzeFrequency(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioAnalysisResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeFrequencyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Detectar silêncio
     * </pre>
     */
    default void detectSilence(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.SilenceDetectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetectSilenceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Extrair características do áudio
     * </pre>
     */
    default void extractFeatures(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioFeaturesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExtractFeaturesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AudioAnalysisService.
   * <pre>
   * Serviço de análise de áudio
   * </pre>
   */
  public static abstract class AudioAnalysisServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AudioAnalysisServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AudioAnalysisService.
   * <pre>
   * Serviço de análise de áudio
   * </pre>
   */
  public static final class AudioAnalysisServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AudioAnalysisServiceStub> {
    private AudioAnalysisServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioAnalysisServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioAnalysisServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analisar frequências do áudio
     * </pre>
     */
    public void analyzeFrequency(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioAnalysisResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeFrequencyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Detectar silêncio
     * </pre>
     */
    public void detectSilence(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.SilenceDetectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetectSilenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Extrair características do áudio
     * </pre>
     */
    public void extractFeatures(com.audioprocessing.grpc.AudioAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioFeaturesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExtractFeaturesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AudioAnalysisService.
   * <pre>
   * Serviço de análise de áudio
   * </pre>
   */
  public static final class AudioAnalysisServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AudioAnalysisServiceBlockingStub> {
    private AudioAnalysisServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioAnalysisServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioAnalysisServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analisar frequências do áudio
     * </pre>
     */
    public com.audioprocessing.grpc.AudioAnalysisResponse analyzeFrequency(com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeFrequencyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Detectar silêncio
     * </pre>
     */
    public com.audioprocessing.grpc.SilenceDetectionResponse detectSilence(com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetectSilenceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extrair características do áudio
     * </pre>
     */
    public com.audioprocessing.grpc.AudioFeaturesResponse extractFeatures(com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtractFeaturesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AudioAnalysisService.
   * <pre>
   * Serviço de análise de áudio
   * </pre>
   */
  public static final class AudioAnalysisServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AudioAnalysisServiceFutureStub> {
    private AudioAnalysisServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioAnalysisServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioAnalysisServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analisar frequências do áudio
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.AudioAnalysisResponse> analyzeFrequency(
        com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeFrequencyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Detectar silêncio
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.SilenceDetectionResponse> detectSilence(
        com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetectSilenceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Extrair características do áudio
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.AudioFeaturesResponse> extractFeatures(
        com.audioprocessing.grpc.AudioAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExtractFeaturesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYZE_FREQUENCY = 0;
  private static final int METHODID_DETECT_SILENCE = 1;
  private static final int METHODID_EXTRACT_FEATURES = 2;

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
        case METHODID_ANALYZE_FREQUENCY:
          serviceImpl.analyzeFrequency((com.audioprocessing.grpc.AudioAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioAnalysisResponse>) responseObserver);
          break;
        case METHODID_DETECT_SILENCE:
          serviceImpl.detectSilence((com.audioprocessing.grpc.AudioAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.SilenceDetectionResponse>) responseObserver);
          break;
        case METHODID_EXTRACT_FEATURES:
          serviceImpl.extractFeatures((com.audioprocessing.grpc.AudioAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioFeaturesResponse>) responseObserver);
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
          getAnalyzeFrequencyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioAnalysisRequest,
              com.audioprocessing.grpc.AudioAnalysisResponse>(
                service, METHODID_ANALYZE_FREQUENCY)))
        .addMethod(
          getDetectSilenceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioAnalysisRequest,
              com.audioprocessing.grpc.SilenceDetectionResponse>(
                service, METHODID_DETECT_SILENCE)))
        .addMethod(
          getExtractFeaturesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioAnalysisRequest,
              com.audioprocessing.grpc.AudioFeaturesResponse>(
                service, METHODID_EXTRACT_FEATURES)))
        .build();
  }

  private static abstract class AudioAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AudioAnalysisServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AudioAnalysisService");
    }
  }

  private static final class AudioAnalysisServiceFileDescriptorSupplier
      extends AudioAnalysisServiceBaseDescriptorSupplier {
    AudioAnalysisServiceFileDescriptorSupplier() {}
  }

  private static final class AudioAnalysisServiceMethodDescriptorSupplier
      extends AudioAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AudioAnalysisServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AudioAnalysisServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AudioAnalysisServiceFileDescriptorSupplier())
              .addMethod(getAnalyzeFrequencyMethod())
              .addMethod(getDetectSilenceMethod())
              .addMethod(getExtractFeaturesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
