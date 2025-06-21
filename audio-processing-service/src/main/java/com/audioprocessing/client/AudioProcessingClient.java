package com.audioprocessing.client;

import com.audioprocessing.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.google.protobuf.ByteString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AudioProcessingClient {
  private final ManagedChannel processingChannel;
  private final ManagedChannel conversionChannel;
  private final ManagedChannel analysisChannel;

  private final AudioProcessingServiceGrpc.AudioProcessingServiceStub processingStub;
  private final AudioProcessingServiceGrpc.AudioProcessingServiceBlockingStub processingBlockingStub;
  private final AudioConversionServiceGrpc.AudioConversionServiceBlockingStub conversionStub;
  private final AudioAnalysisServiceGrpc.AudioAnalysisServiceBlockingStub analysisStub;

  public AudioProcessingClient(String processingHost, int processingPort,
      String conversionHost, int conversionPort,
      String analysisHost, int analysisPort) {
    // Conexões com os três serviços
    processingChannel = ManagedChannelBuilder.forAddress(processingHost, processingPort)
        .usePlaintext()
        .build();

    conversionChannel = ManagedChannelBuilder.forAddress(conversionHost, conversionPort)
        .usePlaintext()
        .build();

    analysisChannel = ManagedChannelBuilder.forAddress(analysisHost, analysisPort)
        .usePlaintext()
        .build();

    processingStub = AudioProcessingServiceGrpc.newStub(processingChannel);
    processingBlockingStub = AudioProcessingServiceGrpc.newBlockingStub(processingChannel);
    conversionStub = AudioConversionServiceGrpc.newBlockingStub(conversionChannel);
    analysisStub = AudioAnalysisServiceGrpc.newBlockingStub(analysisChannel);
  }

  public void shutdown() throws InterruptedException {
    processingChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    conversionChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    analysisChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  // Upload de arquivo de áudio
  public String uploadAudio(String filePath) throws Exception {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException("Arquivo não encontrado: " + filePath);
    }

    byte[] fileData = Files.readAllBytes(Paths.get(filePath));
    String filename = file.getName();

    CountDownLatch latch = new CountDownLatch(1);
    final String[] uploadedFileId = new String[1];
    final Exception[] uploadError = new Exception[1];

    StreamObserver<AudioChunk> requestObserver = processingStub.uploadAudio(
        new StreamObserver<AudioUploadResponse>() {
          @Override
          public void onNext(AudioUploadResponse response) {
            if (response.getSuccess()) {
              uploadedFileId[0] = response.getFileId();
              System.out.println("Upload bem-sucedido! ID: " + response.getFileId());
              System.out.println("Arquivo: " + response.getFilename());
              System.out.println("Tamanho: " + response.getSize() + " bytes");
            } else {
              System.err.println("Falha no upload: " + response.getMessage());
            }
          }

          @Override
          public void onError(Throwable t) {
            uploadError[0] = new Exception(t);
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    // Enviar arquivo em chunks
    int chunkSize = 1024 * 1024; // 1MB por chunk
    int totalChunks = (int) Math.ceil((double) fileData.length / chunkSize);

    for (int i = 0; i < totalChunks; i++) {
      int start = i * chunkSize;
      int end = Math.min(start + chunkSize, fileData.length);
      byte[] chunkData = new byte[end - start];
      System.arraycopy(fileData, start, chunkData, 0, end - start);

      AudioChunk chunk = AudioChunk.newBuilder()
          .setData(ByteString.copyFrom(chunkData))
          .setFilename(filename)
          .setChunkNumber(i + 1)
          .setTotalChunks(totalChunks)
          .setContentType("audio/*")
          .build();

      requestObserver.onNext(chunk);
      System.out.println("Enviado chunk " + (i + 1) + "/" + totalChunks);
    }

    requestObserver.onCompleted();
    latch.await(30, TimeUnit.SECONDS);

    if (uploadError[0] != null) {
      throw uploadError[0];
    }

    return uploadedFileId[0];
  }

  // Processamento completo: upload -> processo -> conversão -> análise
  public void processCompleteWorkflow(String filePath) {
    try {
      System.out.println("=== INICIANDO WORKFLOW COMPLETO ===");

      // 1. Upload do arquivo
      System.out.println("\n1. UPLOAD DO ARQUIVO");
      String fileId = uploadAudio(filePath);

      // 2. Obter informações do arquivo
      System.out.println("\n2. INFORMAÇÕES DO ARQUIVO");
      AudioInfoRequest infoRequest = AudioInfoRequest.newBuilder()
          .setFileId(fileId)
          .build();
      AudioInfoResponse info = processingBlockingStub.getAudioInfo(infoRequest);

      System.out.println("Arquivo: " + info.getFilename());
      System.out.println("Formato: " + info.getFormat());
      System.out.println("Duração: " + info.getDurationSeconds() + "s");
      System.out.println("Sample Rate: " + info.getSampleRate() + " Hz");
      System.out.println("Canais: " + info.getChannels());

      // 3. Processamento de áudio
      System.out.println("\n3. PROCESSAMENTO DE ÁUDIO");
      ProcessingOptions options = ProcessingOptions.newBuilder()
          .setNormalize(true)
          .setApplyEqualizer(true)
          .setEqualizer(EqualizerSettings.newBuilder()
              .setBass(1.2)
              .setMid(1.0)
              .setTreble(1.1)
              .build())
          .setApplyNoiseReduction(true)
          .setVolumeAdjustment(0.1)
          .build();

      AudioProcessRequest processRequest = AudioProcessRequest.newBuilder()
          .setFileId(fileId)
          .setOptions(options)
          .build();

      AudioProcessResponse processResponse = processingBlockingStub.processAudio(processRequest);
      String processedFileId = processResponse.getProcessedFileId();

      System.out.println("Processamento concluído!");
      System.out.println("Arquivo processado ID: " + processedFileId);
      System.out.println("Tempo de processamento: " +
          processResponse.getStats().getProcessingTimeSeconds() + "s");

      // 4. Conversão para MP3
      System.out.println("\n4. CONVERSÃO PARA MP3");
      ConversionOptions conversionOptions = ConversionOptions.newBuilder()
          .setSampleRate(44100)
          .setChannels(2)
          .setBitDepth(16)
          .setQuality(8)
          .build();

      AudioConversionRequest conversionRequest = AudioConversionRequest.newBuilder()
          .setFileId(processedFileId)
          .setTargetFormat("mp3")
          .setOptions(conversionOptions)
          .build();

      AudioConversionResponse conversionResponse = conversionStub.convertAudioFormat(conversionRequest);
      String convertedFileId = conversionResponse.getConvertedFileId();

      System.out.println("Conversão concluída!");
      System.out.println("Arquivo convertido ID: " + convertedFileId);
      System.out.println("Formato: " + conversionResponse.getOriginalFormat() +
          " -> " + conversionResponse.getTargetFormat());

      // 5. Análise do áudio
      System.out.println("\n5. ANÁLISE DO ÁUDIO");
      AnalysisOptions analysisOptions = AnalysisOptions.newBuilder()
          .setIncludeSpectrum(true)
          .setIncludeWaveform(true)
          .setAnalysisWindowSeconds(1.0)
          .build();

      AudioAnalysisRequest analysisRequest = AudioAnalysisRequest.newBuilder()
          .setFileId(fileId)
          .setOptions(analysisOptions)
          .build();

      // Análise de frequência
      AudioAnalysisResponse analysisResponse = analysisStub.analyzeFrequency(analysisRequest);
      System.out.println("Análise de frequência concluída!");
      System.out.println("Pico de frequência: " +
          String.format("%.1f", analysisResponse.getSpectrum().getPeakFrequency()) + " Hz");
      System.out.println("RMS Level: " +
          String.format("%.2f", analysisResponse.getStatistics().getRmsLevel()) + " dB");
      System.out.println("SNR: " +
          String.format("%.1f", analysisResponse.getStatistics().getSignalToNoiseRatio()) + " dB");

      // Detecção de silêncio
      SilenceDetectionResponse silenceResponse = analysisStub.detectSilence(analysisRequest);
      System.out.println("\nDetecção de silêncio:");
      System.out.println("Segmentos de silêncio: " + silenceResponse.getSilenceSegmentsCount());
      System.out.println("Duração total de silêncio: " +
          String.format("%.1f", silenceResponse.getTotalSilenceDuration()) + "s");
      System.out.println("Porcentagem de silêncio: " +
          String.format("%.1f", silenceResponse.getSilencePercentage()) + "%");

      // Extração de características
      AudioFeaturesResponse featuresResponse = analysisStub.extractFeatures(analysisRequest);
      System.out.println("\nCaracterísticas extraídas:");
      System.out.println("Tempo: " + String.format("%.1f", featuresResponse.getTempo()) + " BPM");
      System.out.println("Tom: " + featuresResponse.getKey());
      System.out.println("Loudness: " + String.format("%.1f", featuresResponse.getLoudness()) + " dB");
      System.out.println("Centroide espectral: " +
          String.format("%.1f", featuresResponse.getSpectralFeatures().getSpectralCentroid()) + " Hz");

      System.out.println("\n=== WORKFLOW COMPLETO CONCLUÍDO ===");

    } catch (Exception e) {
      System.err.println("Erro durante o workflow: " + e.getMessage());
      e.printStackTrace();
    }
  }

  // Listar todos os arquivos
  public void listFiles() {
    try {
      ListAudioFilesRequest request = ListAudioFilesRequest.newBuilder()
          .setPage(1)
          .setPageSize(10)
          .build();

      ListAudioFilesResponse response = processingBlockingStub.listAudioFiles(request);

      System.out.println("\n=== ARQUIVOS DISPONÍVEIS ===");
      System.out.println("Total: " + response.getTotalCount() + " arquivos");

      for (AudioInfoResponse file : response.getFilesList()) {
        System.out.println("\nID: " + file.getFileId());
        System.out.println("Nome: " + file.getFilename());
        System.out.println("Formato: " + file.getFormat());
        System.out.println("Tamanho: " + file.getFileSize() + " bytes");
        System.out.println("Criado em: " + file.getCreatedAt());
      }
    } catch (Exception e) {
      System.err.println("Erro ao listar arquivos: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    System.out.println("Teste");
    AudioProcessingClient client = new AudioProcessingClient(
        "127.0.0.1", 50051, // Processing Server
        "127.0.0.1", 50052, // Conversion Server
        "127.0.0.1", 50053 // Analysis Server
    );
    System.out.println("Teste");

    try {
      // Teste com um arquivo de exemplo (você precisa ter um arquivo de áudio)
      String audioFilePath = "com/audioprocessing/client/teste.wav"; // Substitua pelo caminho do seu arquivo

      // Se o arquivo não existir, criar um arquivo de teste simples
      File testFile = new File(audioFilePath);
//      if (!testFile.exists()) {
//        System.out.println("Criando arquivo de teste...");
//        try (FileOutputStream fos = new FileOutputStream(testFile)) {
//          // Criar um arquivo de teste simples (não é um WAV real, apenas para teste)
//          byte[] testData = new byte[1024 * 100]; // 100KB de dados de teste
//          for (int i = 0; i < testData.length; i++) {
//            testData[i] = (byte) (Math.sin(i * 0.1) * 127);
//          }
//          fos.write(testData);
//        }
//        System.out.println("Arquivo de teste criado: " + audioFilePath);
//      }

      // Executar workflow completo
      client.processCompleteWorkflow(audioFilePath);

      // Listar arquivos
      Thread.sleep(1000); // Aguardar um pouco
      client.listFiles();

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        client.shutdown();
      } catch (InterruptedException e) {
        System.err.println("Erro ao fechar conexões: " + e.getMessage());
      }
    }
  }
}