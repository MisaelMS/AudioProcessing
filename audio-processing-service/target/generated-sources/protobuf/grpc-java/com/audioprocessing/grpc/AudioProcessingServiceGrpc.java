package com.audioprocessing.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Serviço principal de processamento de áudio
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: audio_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AudioProcessingServiceGrpc {

  private AudioProcessingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "audioprocessing.AudioProcessingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioChunk,
      com.audioprocessing.grpc.AudioUploadResponse> getUploadAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadAudio",
      requestType = com.audioprocessing.grpc.AudioChunk.class,
      responseType = com.audioprocessing.grpc.AudioUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioChunk,
      com.audioprocessing.grpc.AudioUploadResponse> getUploadAudioMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioChunk, com.audioprocessing.grpc.AudioUploadResponse> getUploadAudioMethod;
    if ((getUploadAudioMethod = AudioProcessingServiceGrpc.getUploadAudioMethod) == null) {
      synchronized (AudioProcessingServiceGrpc.class) {
        if ((getUploadAudioMethod = AudioProcessingServiceGrpc.getUploadAudioMethod) == null) {
          AudioProcessingServiceGrpc.getUploadAudioMethod = getUploadAudioMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioChunk, com.audioprocessing.grpc.AudioUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioChunk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioUploadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioProcessingServiceMethodDescriptorSupplier("UploadAudio"))
              .build();
        }
      }
    }
    return getUploadAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioDownloadRequest,
      com.audioprocessing.grpc.AudioChunk> getDownloadAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadAudio",
      requestType = com.audioprocessing.grpc.AudioDownloadRequest.class,
      responseType = com.audioprocessing.grpc.AudioChunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioDownloadRequest,
      com.audioprocessing.grpc.AudioChunk> getDownloadAudioMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioDownloadRequest, com.audioprocessing.grpc.AudioChunk> getDownloadAudioMethod;
    if ((getDownloadAudioMethod = AudioProcessingServiceGrpc.getDownloadAudioMethod) == null) {
      synchronized (AudioProcessingServiceGrpc.class) {
        if ((getDownloadAudioMethod = AudioProcessingServiceGrpc.getDownloadAudioMethod) == null) {
          AudioProcessingServiceGrpc.getDownloadAudioMethod = getDownloadAudioMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioDownloadRequest, com.audioprocessing.grpc.AudioChunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DownloadAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioDownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioChunk.getDefaultInstance()))
              .setSchemaDescriptor(new AudioProcessingServiceMethodDescriptorSupplier("DownloadAudio"))
              .build();
        }
      }
    }
    return getDownloadAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioProcessRequest,
      com.audioprocessing.grpc.AudioProcessResponse> getProcessAudioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessAudio",
      requestType = com.audioprocessing.grpc.AudioProcessRequest.class,
      responseType = com.audioprocessing.grpc.AudioProcessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioProcessRequest,
      com.audioprocessing.grpc.AudioProcessResponse> getProcessAudioMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioProcessRequest, com.audioprocessing.grpc.AudioProcessResponse> getProcessAudioMethod;
    if ((getProcessAudioMethod = AudioProcessingServiceGrpc.getProcessAudioMethod) == null) {
      synchronized (AudioProcessingServiceGrpc.class) {
        if ((getProcessAudioMethod = AudioProcessingServiceGrpc.getProcessAudioMethod) == null) {
          AudioProcessingServiceGrpc.getProcessAudioMethod = getProcessAudioMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioProcessRequest, com.audioprocessing.grpc.AudioProcessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessAudio"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioProcessResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioProcessingServiceMethodDescriptorSupplier("ProcessAudio"))
              .build();
        }
      }
    }
    return getProcessAudioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioInfoRequest,
      com.audioprocessing.grpc.AudioInfoResponse> getGetAudioInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAudioInfo",
      requestType = com.audioprocessing.grpc.AudioInfoRequest.class,
      responseType = com.audioprocessing.grpc.AudioInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioInfoRequest,
      com.audioprocessing.grpc.AudioInfoResponse> getGetAudioInfoMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.AudioInfoRequest, com.audioprocessing.grpc.AudioInfoResponse> getGetAudioInfoMethod;
    if ((getGetAudioInfoMethod = AudioProcessingServiceGrpc.getGetAudioInfoMethod) == null) {
      synchronized (AudioProcessingServiceGrpc.class) {
        if ((getGetAudioInfoMethod = AudioProcessingServiceGrpc.getGetAudioInfoMethod) == null) {
          AudioProcessingServiceGrpc.getGetAudioInfoMethod = getGetAudioInfoMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.AudioInfoRequest, com.audioprocessing.grpc.AudioInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAudioInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.AudioInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioProcessingServiceMethodDescriptorSupplier("GetAudioInfo"))
              .build();
        }
      }
    }
    return getGetAudioInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.audioprocessing.grpc.ListAudioFilesRequest,
      com.audioprocessing.grpc.ListAudioFilesResponse> getListAudioFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAudioFiles",
      requestType = com.audioprocessing.grpc.ListAudioFilesRequest.class,
      responseType = com.audioprocessing.grpc.ListAudioFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.audioprocessing.grpc.ListAudioFilesRequest,
      com.audioprocessing.grpc.ListAudioFilesResponse> getListAudioFilesMethod() {
    io.grpc.MethodDescriptor<com.audioprocessing.grpc.ListAudioFilesRequest, com.audioprocessing.grpc.ListAudioFilesResponse> getListAudioFilesMethod;
    if ((getListAudioFilesMethod = AudioProcessingServiceGrpc.getListAudioFilesMethod) == null) {
      synchronized (AudioProcessingServiceGrpc.class) {
        if ((getListAudioFilesMethod = AudioProcessingServiceGrpc.getListAudioFilesMethod) == null) {
          AudioProcessingServiceGrpc.getListAudioFilesMethod = getListAudioFilesMethod =
              io.grpc.MethodDescriptor.<com.audioprocessing.grpc.ListAudioFilesRequest, com.audioprocessing.grpc.ListAudioFilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAudioFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.ListAudioFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.audioprocessing.grpc.ListAudioFilesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AudioProcessingServiceMethodDescriptorSupplier("ListAudioFiles"))
              .build();
        }
      }
    }
    return getListAudioFilesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AudioProcessingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceStub>() {
        @java.lang.Override
        public AudioProcessingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioProcessingServiceStub(channel, callOptions);
        }
      };
    return AudioProcessingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AudioProcessingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceBlockingStub>() {
        @java.lang.Override
        public AudioProcessingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioProcessingServiceBlockingStub(channel, callOptions);
        }
      };
    return AudioProcessingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AudioProcessingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AudioProcessingServiceFutureStub>() {
        @java.lang.Override
        public AudioProcessingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AudioProcessingServiceFutureStub(channel, callOptions);
        }
      };
    return AudioProcessingServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Serviço principal de processamento de áudio
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Upload de arquivo de áudio
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioChunk> uploadAudio(
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioUploadResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadAudioMethod(), responseObserver);
    }

    /**
     * <pre>
     * Download de arquivo de áudio
     * </pre>
     */
    default void downloadAudio(com.audioprocessing.grpc.AudioDownloadRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioChunk> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadAudioMethod(), responseObserver);
    }

    /**
     * <pre>
     * Processamento de áudio (normalização, equalização, etc.)
     * </pre>
     */
    default void processAudio(com.audioprocessing.grpc.AudioProcessRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioProcessResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessAudioMethod(), responseObserver);
    }

    /**
     * <pre>
     * Obter informações sobre um arquivo de áudio
     * </pre>
     */
    default void getAudioInfo(com.audioprocessing.grpc.AudioInfoRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAudioInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Listar arquivos disponíveis
     * </pre>
     */
    default void listAudioFiles(com.audioprocessing.grpc.ListAudioFilesRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.ListAudioFilesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAudioFilesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AudioProcessingService.
   * <pre>
   * Serviço principal de processamento de áudio
   * </pre>
   */
  public static abstract class AudioProcessingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AudioProcessingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AudioProcessingService.
   * <pre>
   * Serviço principal de processamento de áudio
   * </pre>
   */
  public static final class AudioProcessingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AudioProcessingServiceStub> {
    private AudioProcessingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioProcessingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioProcessingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Upload de arquivo de áudio
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioChunk> uploadAudio(
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioUploadResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadAudioMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Download de arquivo de áudio
     * </pre>
     */
    public void downloadAudio(com.audioprocessing.grpc.AudioDownloadRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioChunk> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadAudioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Processamento de áudio (normalização, equalização, etc.)
     * </pre>
     */
    public void processAudio(com.audioprocessing.grpc.AudioProcessRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioProcessResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessAudioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Obter informações sobre um arquivo de áudio
     * </pre>
     */
    public void getAudioInfo(com.audioprocessing.grpc.AudioInfoRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAudioInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Listar arquivos disponíveis
     * </pre>
     */
    public void listAudioFiles(com.audioprocessing.grpc.ListAudioFilesRequest request,
        io.grpc.stub.StreamObserver<com.audioprocessing.grpc.ListAudioFilesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAudioFilesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AudioProcessingService.
   * <pre>
   * Serviço principal de processamento de áudio
   * </pre>
   */
  public static final class AudioProcessingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AudioProcessingServiceBlockingStub> {
    private AudioProcessingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioProcessingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioProcessingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Download de arquivo de áudio
     * </pre>
     */
    public java.util.Iterator<com.audioprocessing.grpc.AudioChunk> downloadAudio(
        com.audioprocessing.grpc.AudioDownloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadAudioMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Processamento de áudio (normalização, equalização, etc.)
     * </pre>
     */
    public com.audioprocessing.grpc.AudioProcessResponse processAudio(com.audioprocessing.grpc.AudioProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessAudioMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Obter informações sobre um arquivo de áudio
     * </pre>
     */
    public com.audioprocessing.grpc.AudioInfoResponse getAudioInfo(com.audioprocessing.grpc.AudioInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAudioInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Listar arquivos disponíveis
     * </pre>
     */
    public com.audioprocessing.grpc.ListAudioFilesResponse listAudioFiles(com.audioprocessing.grpc.ListAudioFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAudioFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AudioProcessingService.
   * <pre>
   * Serviço principal de processamento de áudio
   * </pre>
   */
  public static final class AudioProcessingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AudioProcessingServiceFutureStub> {
    private AudioProcessingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AudioProcessingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AudioProcessingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Processamento de áudio (normalização, equalização, etc.)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.AudioProcessResponse> processAudio(
        com.audioprocessing.grpc.AudioProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessAudioMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Obter informações sobre um arquivo de áudio
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.AudioInfoResponse> getAudioInfo(
        com.audioprocessing.grpc.AudioInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAudioInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Listar arquivos disponíveis
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.audioprocessing.grpc.ListAudioFilesResponse> listAudioFiles(
        com.audioprocessing.grpc.ListAudioFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAudioFilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DOWNLOAD_AUDIO = 0;
  private static final int METHODID_PROCESS_AUDIO = 1;
  private static final int METHODID_GET_AUDIO_INFO = 2;
  private static final int METHODID_LIST_AUDIO_FILES = 3;
  private static final int METHODID_UPLOAD_AUDIO = 4;

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
        case METHODID_DOWNLOAD_AUDIO:
          serviceImpl.downloadAudio((com.audioprocessing.grpc.AudioDownloadRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioChunk>) responseObserver);
          break;
        case METHODID_PROCESS_AUDIO:
          serviceImpl.processAudio((com.audioprocessing.grpc.AudioProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioProcessResponse>) responseObserver);
          break;
        case METHODID_GET_AUDIO_INFO:
          serviceImpl.getAudioInfo((com.audioprocessing.grpc.AudioInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioInfoResponse>) responseObserver);
          break;
        case METHODID_LIST_AUDIO_FILES:
          serviceImpl.listAudioFiles((com.audioprocessing.grpc.ListAudioFilesRequest) request,
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.ListAudioFilesResponse>) responseObserver);
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
        case METHODID_UPLOAD_AUDIO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadAudio(
              (io.grpc.stub.StreamObserver<com.audioprocessing.grpc.AudioUploadResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUploadAudioMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioChunk,
              com.audioprocessing.grpc.AudioUploadResponse>(
                service, METHODID_UPLOAD_AUDIO)))
        .addMethod(
          getDownloadAudioMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioDownloadRequest,
              com.audioprocessing.grpc.AudioChunk>(
                service, METHODID_DOWNLOAD_AUDIO)))
        .addMethod(
          getProcessAudioMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioProcessRequest,
              com.audioprocessing.grpc.AudioProcessResponse>(
                service, METHODID_PROCESS_AUDIO)))
        .addMethod(
          getGetAudioInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.AudioInfoRequest,
              com.audioprocessing.grpc.AudioInfoResponse>(
                service, METHODID_GET_AUDIO_INFO)))
        .addMethod(
          getListAudioFilesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.audioprocessing.grpc.ListAudioFilesRequest,
              com.audioprocessing.grpc.ListAudioFilesResponse>(
                service, METHODID_LIST_AUDIO_FILES)))
        .build();
  }

  private static abstract class AudioProcessingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AudioProcessingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.audioprocessing.grpc.AudioServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AudioProcessingService");
    }
  }

  private static final class AudioProcessingServiceFileDescriptorSupplier
      extends AudioProcessingServiceBaseDescriptorSupplier {
    AudioProcessingServiceFileDescriptorSupplier() {}
  }

  private static final class AudioProcessingServiceMethodDescriptorSupplier
      extends AudioProcessingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AudioProcessingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AudioProcessingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AudioProcessingServiceFileDescriptorSupplier())
              .addMethod(getUploadAudioMethod())
              .addMethod(getDownloadAudioMethod())
              .addMethod(getProcessAudioMethod())
              .addMethod(getGetAudioInfoMethod())
              .addMethod(getListAudioFilesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
