package com.audioprocessing.server;

import com.audioprocessing.grpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AudioProcessingServer {
  private static final int PORT = 50051;
  private static final String AUDIO_STORAGE_DIR = "audio_files/";
  private static final String PROCESSED_STORAGE_DIR = "processed_files/";

  private Server server;
  private final Map<String, AudioFileMetadata> audioFiles = new ConcurrentHashMap<>();
  private final AtomicLong fileIdCounter = new AtomicLong(1);

  private static class AudioFileMetadata {
    String fileId;
    String filename;
    String format;
    long size;
    String createdAt;
    String filePath;

    AudioFileMetadata(String fileId, String filename, String format, long size, String filePath) {
      this.fileId = fileId;
      this.filename = filename;
      this.format = format;
      this.size = size;
      this.filePath = filePath;
      this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
  }

  public static void main(String[] args) throws Exception {
    System.setProperty("java.net.preferIPv4Stack", "true");
    AudioProcessingServer server = new AudioProcessingServer();
    server.start();
    server.blockUntilShutdown();
  }

  private void start() throws Exception {
    // Criar diretórios se não existirem
    Files.createDirectories(Paths.get(AUDIO_STORAGE_DIR));
    Files.createDirectories(Paths.get(PROCESSED_STORAGE_DIR));

    server = ServerBuilder
            .forPort(PORT)
            .addService(new AudioProcessingServer.AudioProcessingServiceImpl())
            .build()
            .start();

    System.out.println("Servidor de Processamento de Áudio iniciado na porta " + PORT);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("Desligando servidor gRPC...");
      AudioProcessingServer.this.stop();
      System.err.println("Servidor desligado.");
    }));
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  private class AudioProcessingServiceImpl extends AudioProcessingServiceGrpc.AudioProcessingServiceImplBase {

    @Override
    public StreamObserver<AudioChunk> uploadAudio(StreamObserver<AudioUploadResponse> responseObserver) {
      return new StreamObserver<AudioChunk>() {
        private ByteArrayOutputStream fileData = new ByteArrayOutputStream();
        private String filename;
        private String contentType;
        private long totalChunks;
        private long receivedChunks = 0;

        @Override
        public void onNext(AudioChunk chunk) {
          try {
            if (filename == null) {
              filename = chunk.getFilename();
              contentType = chunk.getContentType();
              totalChunks = chunk.getTotalChunks();
            }

            fileData.write(chunk.getData().toByteArray());
            receivedChunks++;

            System.out.println("Recebido chunk " + receivedChunks + "/" + totalChunks + " do arquivo " + filename);

          } catch (IOException e) {
            onError(e);
          }
        }

        @Override
        public void onError(Throwable t) {
          System.err.println("Erro durante upload: " + t.getMessage());
          responseObserver.onError(t);
        }

        @Override
        public void onCompleted() {
          try {
            String fileId = String.valueOf(fileIdCounter.getAndIncrement());
            String fileExtension = getFileExtension(filename);
            String storedFilename = fileId + "_" + filename;
            String filePath = AUDIO_STORAGE_DIR + storedFilename;

            // Salvar arquivo
            Files.write(Paths.get(filePath), fileData.toByteArray());

            // Armazenar metadados
            AudioFileMetadata metadata = new AudioFileMetadata(
                fileId, filename, fileExtension, fileData.size(), filePath);
            audioFiles.put(fileId, metadata);

            AudioUploadResponse response = AudioUploadResponse.newBuilder()
                .setFileId(fileId)
                .setFilename(filename)
                .setSize(fileData.size())
                .setSuccess(true)
                .setMessage("Upload concluído com sucesso")
                .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            System.out.println("Upload concluído: " + filename + " (ID: " + fileId + ")");

          } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
            responseObserver.onError(e);
          }
        }
      };
    }

    @Override
    public void downloadAudio(AudioDownloadRequest request, StreamObserver<AudioChunk> responseObserver) {
      String fileId = request.getFileId();
      AudioFileMetadata metadata = audioFiles.get(fileId);

      if (metadata == null) {
        responseObserver.onError(new RuntimeException("Arquivo não encontrado: " + fileId));
        return;
      }

      try {
        byte[] fileData = Files.readAllBytes(Paths.get(metadata.filePath));
        int chunkSize = 1024 * 1024; // 1MB por chunk
        int totalChunks = (int) Math.ceil((double) fileData.length / chunkSize);

        for (int i = 0; i < totalChunks; i++) {
          int start = i * chunkSize;
          int end = Math.min(start + chunkSize, fileData.length);
          byte[] chunkData = Arrays.copyOfRange(fileData, start, end);

          AudioChunk chunk = AudioChunk.newBuilder()
              .setData(com.google.protobuf.ByteString.copyFrom(chunkData))
              .setFilename(metadata.filename)
              .setChunkNumber(i + 1)
              .setTotalChunks(totalChunks)
              .setContentType("audio/*")
              .build();

          responseObserver.onNext(chunk);
        }

        responseObserver.onCompleted();
        System.out.println("Download concluído: " + metadata.filename);

      } catch (IOException e) {
        System.err.println("Erro durante download: " + e.getMessage());
        responseObserver.onError(e);
      }
    }

    @Override
    public void processAudio(AudioProcessRequest request, StreamObserver<AudioProcessResponse> responseObserver) {
      String fileId = request.getFileId();
      AudioFileMetadata metadata = audioFiles.get(fileId);

      if (metadata == null) {
        responseObserver.onError(new RuntimeException("Arquivo não encontrado: " + fileId));
        return;
      }

      try {
        long startTime = System.currentTimeMillis();

        // Simular processamento de áudio
        ProcessingOptions options = request.getOptions();
        System.out.println("Processando áudio: " + metadata.filename);

        if (options.getNormalize()) {
          System.out.println("Aplicando normalização...");
          Thread.sleep(500); // Simular processamento
        }

        if (options.getApplyEqualizer()) {
          System.out.println("Aplicando equalização...");
          Thread.sleep(300);
        }

        if (options.getApplyNoiseReduction()) {
          System.out.println("Aplicando redução de ruído...");
          Thread.sleep(700);
        }

        if (options.getVolumeAdjustment() != 0) {
          System.out.println("Ajustando volume: " + options.getVolumeAdjustment());
          Thread.sleep(200);
        }

        // Criar arquivo processado
        String processedFileId = String.valueOf(fileIdCounter.getAndIncrement());
        String processedFilename = "processed_" + metadata.filename;
        String processedFilePath = PROCESSED_STORAGE_DIR + processedFileId + "_" + processedFilename;

        // Copiar arquivo original para o processado (simulação)
        Files.copy(Paths.get(metadata.filePath), Paths.get(processedFilePath));

        AudioFileMetadata processedMetadata = new AudioFileMetadata(
            processedFileId, processedFilename, metadata.format, metadata.size, processedFilePath);
        audioFiles.put(processedFileId, processedMetadata);

        long endTime = System.currentTimeMillis();
        double processingTime = (endTime - startTime) / 1000.0;

        ProcessingStats stats = ProcessingStats.newBuilder()
            .setProcessingTimeSeconds(processingTime)
            .setOriginalSize(metadata.size)
            .setProcessedSize(metadata.size)
            .build();

        AudioProcessResponse response = AudioProcessResponse.newBuilder()
            .setProcessedFileId(processedFileId)
            .setSuccess(true)
            .setMessage("Processamento concluído com sucesso")
            .setStats(stats)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Processamento concluído: " + processedFilename + " (ID: " + processedFileId + ")");

      } catch (Exception e) {
        System.err.println("Erro durante processamento: " + e.getMessage());
        responseObserver.onError(e);
      }
    }

    @Override
    public void getAudioInfo(AudioInfoRequest request, StreamObserver<AudioInfoResponse> responseObserver) {
      String fileId = request.getFileId();
      AudioFileMetadata metadata = audioFiles.get(fileId);

      if (metadata == null) {
        responseObserver.onError(new RuntimeException("Arquivo não encontrado: " + fileId));
        return;
      }

      // Simular análise de metadados de áudio
      AudioInfoResponse response = AudioInfoResponse.newBuilder()
          .setFileId(metadata.fileId)
          .setFilename(metadata.filename)
          .setFormat(metadata.format)
          .setDurationSeconds(180.5) // Simulado
          .setSampleRate(44100)
          .setChannels(2)
          .setBitDepth(16)
          .setFileSize(metadata.size)
          .setCreatedAt(metadata.createdAt)
          .build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }

    @Override
    public void listAudioFiles(ListAudioFilesRequest request, StreamObserver<ListAudioFilesResponse> responseObserver) {
      List<AudioInfoResponse> files = new ArrayList<>();

      for (AudioFileMetadata metadata : audioFiles.values()) {
        AudioInfoResponse fileInfo = AudioInfoResponse.newBuilder()
            .setFileId(metadata.fileId)
            .setFilename(metadata.filename)
            .setFormat(metadata.format)
            .setDurationSeconds(180.5) // Simulado
            .setSampleRate(44100)
            .setChannels(2)
            .setBitDepth(16)
            .setFileSize(metadata.size)
            .setCreatedAt(metadata.createdAt)
            .build();
        files.add(fileInfo);
      }

      ListAudioFilesResponse response = ListAudioFilesResponse.newBuilder()
          .addAllFiles(files)
          .setTotalCount(files.size())
          .setCurrentPage(1)
          .build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }

    private String getFileExtension(String filename) {
      int lastDotIndex = filename.lastIndexOf('.');
      return lastDotIndex > 0 ? filename.substring(lastDotIndex + 1).toLowerCase() : "unknown";
    }
  }
}