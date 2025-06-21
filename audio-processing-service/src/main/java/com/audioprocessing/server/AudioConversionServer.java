package com.audioprocessing.server;

import com.audioprocessing.grpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AudioConversionServer {
  private static final int PORT = 50052;
  private Server server;
  private final Map<String, ConvertedFileMetadata> convertedFiles = new ConcurrentHashMap<>();
  private final AtomicLong fileIdCounter = new AtomicLong(1000);

  // Formatos suportados
  private static final Set<String> SUPPORTED_FORMATS = Set.of(
      "mp3", "wav", "flac", "aac", "ogg", "m4a", "wma");

  private static class ConvertedFileMetadata {
    String fileId;
    String originalFormat;
    String targetFormat;
    String createdAt;
    long size;

    ConvertedFileMetadata(String fileId, String originalFormat, String targetFormat, long size) {
      this.fileId = fileId;
      this.originalFormat = originalFormat;
      this.targetFormat = targetFormat;
      this.size = size;
      this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
  }

  public static void main(String[] args) throws Exception {
    AudioConversionServer server = new AudioConversionServer();
    server.start();
    server.blockUntilShutdown();
  }

  private void start() throws Exception {
    server = NettyServerBuilder
              .forAddress(new InetSocketAddress("0.0.0.0", PORT))
              .addService(new AudioConversionServiceImpl())
              .build()
              .start();

    System.out.println("Servidor de Conversão de Áudio iniciado na porta " + PORT);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("Desligando servidor de conversão gRPC...");
      AudioConversionServer.this.stop();
      System.err.println("Servidor de conversão desligado.");
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

  private class AudioConversionServiceImpl extends AudioConversionServiceGrpc.AudioConversionServiceImplBase {

    @Override
    public void convertAudioFormat(AudioConversionRequest request,
        StreamObserver<AudioConversionResponse> responseObserver) {
      String fileId = request.getFileId();
      String targetFormat = request.getTargetFormat().toLowerCase();
      ConversionOptions options = request.getOptions();

      try {
        // Validar formato de destino
        if (!SUPPORTED_FORMATS.contains(targetFormat)) {
          throw new IllegalArgumentException("Formato não suportado: " + targetFormat);
        }

        System.out.println("Iniciando conversão do arquivo " + fileId + " para " + targetFormat);

        // Simular processo de conversão
        String originalFormat = simulateGetOriginalFormat(fileId);
        long conversionTime = simulateConversion(originalFormat, targetFormat, options);

        String convertedFileId = String.valueOf(fileIdCounter.getAndIncrement());
        long estimatedSize = estimateConvertedSize(originalFormat, targetFormat, 5000000L); // 5MB original

        ConvertedFileMetadata metadata = new ConvertedFileMetadata(
            convertedFileId, originalFormat, targetFormat, estimatedSize);
        convertedFiles.put(convertedFileId, metadata);

        AudioConversionResponse response = AudioConversionResponse.newBuilder()
            .setConvertedFileId(convertedFileId)
            .setOriginalFormat(originalFormat)
            .setTargetFormat(targetFormat)
            .setSuccess(true)
            .setMessage("Conversão concluída em " + conversionTime + "ms")
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Conversão concluída: " + originalFormat + " -> " + targetFormat +
            " (ID: " + convertedFileId + ")");

      } catch (Exception e) {
        System.err.println("Erro durante conversão: " + e.getMessage());

        AudioConversionResponse response = AudioConversionResponse.newBuilder()
            .setSuccess(false)
            .setMessage("Erro na conversão: " + e.getMessage())
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    }

    @Override
    public void batchConvertAudio(BatchConversionRequest request,
        StreamObserver<AudioConversionResponse> responseObserver) {
      List<String> fileIds = request.getFileIdsList();
      List<String> targetFormats = request.getTargetFormatsList();
      ConversionOptions options = request.getOptions();

      System.out.println("Iniciando conversão em lote de " + fileIds.size() + " arquivos");

      for (int i = 0; i < fileIds.size(); i++) {
        String fileId = fileIds.get(i);
        String targetFormat = i < targetFormats.size() ? targetFormats.get(i).toLowerCase()
            : targetFormats.get(0).toLowerCase();

        try {
          // Validar formato
          if (!SUPPORTED_FORMATS.contains(targetFormat)) {
            throw new IllegalArgumentException("Formato não suportado: " + targetFormat);
          }

          String originalFormat = simulateGetOriginalFormat(fileId);
          long conversionTime = simulateConversion(originalFormat, targetFormat, options);

          String convertedFileId = String.valueOf(fileIdCounter.getAndIncrement());
          long estimatedSize = estimateConvertedSize(originalFormat, targetFormat, 5000000L);

          ConvertedFileMetadata metadata = new ConvertedFileMetadata(
              convertedFileId, originalFormat, targetFormat, estimatedSize);
          convertedFiles.put(convertedFileId, metadata);

          AudioConversionResponse response = AudioConversionResponse.newBuilder()
              .setConvertedFileId(convertedFileId)
              .setOriginalFormat(originalFormat)
              .setTargetFormat(targetFormat)
              .setSuccess(true)
              .setMessage("Conversão " + (i + 1) + "/" + fileIds.size() + " concluída")
              .build();

          responseObserver.onNext(response);

          System.out.println("Conversão " + (i + 1) + "/" + fileIds.size() + " concluída: " +
              originalFormat + " -> " + targetFormat);

        } catch (Exception e) {
          System.err.println("Erro na conversão do arquivo " + fileId + ": " + e.getMessage());

          AudioConversionResponse response = AudioConversionResponse.newBuilder()
              .setSuccess(false)
              .setMessage("Erro na conversão do arquivo " + fileId + ": " + e.getMessage())
              .build();

          responseObserver.onNext(response);
        }
      }

      responseObserver.onCompleted();
      System.out.println("Conversão em lote concluída");
    }

    private String simulateGetOriginalFormat(String fileId) {
      // Simular obtenção do formato original
      String[] formats = { "mp3", "wav", "flac", "aac" };
      return formats[Math.abs(fileId.hashCode()) % formats.length];
    }

    private long simulateConversion(String originalFormat, String targetFormat, ConversionOptions options) {
      try {
        // Simular tempo de conversão baseado na complexidade
        long baseTime = 1000; // 1 segundo base

        // Diferentes formatos têm diferentes complexidades
        Map<String, Integer> complexityMap = Map.of(
            "wav", 1,
            "mp3", 2,
            "aac", 3,
            "flac", 4,
            "ogg", 3,
            "m4a", 3,
            "wma", 2);

        int originalComplexity = complexityMap.getOrDefault(originalFormat, 2);
        int targetComplexity = complexityMap.getOrDefault(targetFormat, 2);

        long conversionTime = baseTime + (originalComplexity + targetComplexity) * 200;

        // Adicionar tempo extra para opções especiais
        if (options.getSampleRate() != 0 && options.getSampleRate() != 44100) {
          conversionTime += 300;
        }
        if (options.getChannels() != 0 && options.getChannels() != 2) {
          conversionTime += 200;
        }
        if (options.getQuality() > 0) {
          conversionTime += options.getQuality() * 50;
        }

        Thread.sleep(conversionTime);
        return conversionTime;

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return 1000;
      }
    }

    private long estimateConvertedSize(String originalFormat, String targetFormat, long originalSize) {
      // Estimar tamanho do arquivo convertido baseado nos formatos
      Map<String, Double> compressionRatios = Map.of(
          "wav", 1.0, // Sem compressão
          "flac", 0.6, // Compressão lossless
          "mp3", 0.1, // Alta compressão
          "aac", 0.12, // Compressão similar ao MP3
          "ogg", 0.15, // Compressão boa
          "m4a", 0.12, // Similar ao AAC
          "wma", 0.13 // Compressão Microsoft
      );

      double originalRatio = compressionRatios.getOrDefault(originalFormat, 0.2);
      double targetRatio = compressionRatios.getOrDefault(targetFormat, 0.2);

      // Estimar tamanho baseado na razão de compressão
      return Math.round(originalSize * (targetRatio / originalRatio));
    }
  }
}