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
import java.util.concurrent.atomic.AtomicBoolean;

public class AudioProcessingClient {
  private final ManagedChannel processingChannel;
  private final ManagedChannel conversionChannel;
  private final ManagedChannel analysisChannel;

  private final AudioProcessingServiceGrpc.AudioProcessingServiceStub processingStub;
  private final AudioProcessingServiceGrpc.AudioProcessingServiceBlockingStub processingBlockingStub;
  private final AudioConversionServiceGrpc.AudioConversionServiceBlockingStub conversionStub;
  private final AudioAnalysisServiceGrpc.AudioAnalysisServiceBlockingStub analysisStub;

  private final AtomicBoolean isShutdown = new AtomicBoolean(false);

  public AudioProcessingClient(String processingHost, int processingPort,
                               String conversionHost, int conversionPort,
                               String analysisHost, int analysisPort) {
    // Conexões com os três serviços
    processingChannel = ManagedChannelBuilder.forAddress(processingHost, processingPort)
            .usePlaintext()
            .keepAliveTime(30, TimeUnit.SECONDS)
            .keepAliveTimeout(5, TimeUnit.SECONDS)
            .keepAliveWithoutCalls(true)
            .maxInboundMessageSize(64 * 1024 * 1024) // 64MB
            .build();

    conversionChannel = ManagedChannelBuilder.forAddress(conversionHost, conversionPort)
            .usePlaintext()
            .keepAliveTime(30, TimeUnit.SECONDS)
            .keepAliveTimeout(5, TimeUnit.SECONDS)
            .keepAliveWithoutCalls(true)
            .maxInboundMessageSize(64 * 1024 * 1024)
            .build();

    analysisChannel = ManagedChannelBuilder.forAddress(analysisHost, analysisPort)
            .usePlaintext()
            .keepAliveTime(30, TimeUnit.SECONDS)
            .keepAliveTimeout(5, TimeUnit.SECONDS)
            .keepAliveWithoutCalls(true)
            .maxInboundMessageSize(64 * 1024 * 1024)
            .build();

    processingStub = AudioProcessingServiceGrpc.newStub(processingChannel);
    processingBlockingStub = AudioProcessingServiceGrpc.newBlockingStub(processingChannel);
    conversionStub = AudioConversionServiceGrpc.newBlockingStub(conversionChannel);
    analysisStub = AudioAnalysisServiceGrpc.newBlockingStub(analysisChannel);
  }

  public void shutdown() throws InterruptedException {
    if (isShutdown.compareAndSet(false, true)) {
      System.out.println("Shutting down channels...");

      if (!processingChannel.shutdown().awaitTermination(10, TimeUnit.SECONDS)) {
        processingChannel.shutdownNow();
      }
      if (!conversionChannel.shutdown().awaitTermination(10, TimeUnit.SECONDS)) {
        conversionChannel.shutdownNow();
      }
      if (!analysisChannel.shutdown().awaitTermination(10, TimeUnit.SECONDS)) {
        analysisChannel.shutdownNow();
      }

      System.out.println("Channels shutdown completed");
    }
  }

  public String uploadAudio(String filePath) throws Exception {
    if (isShutdown.get()) {
      throw new IllegalStateException("Client is already shutdown");
    }

    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException("Arquivo não encontrado: " + filePath);
    }

    byte[] fileData = Files.readAllBytes(Paths.get(filePath));
    String filename = file.getName();

    CountDownLatch latch = new CountDownLatch(1);
    final String[] uploadedFileId = new String[1];
    final Exception[] uploadError = new Exception[1];
    final AtomicBoolean completed = new AtomicBoolean(false);

    System.out.println("Iniciando upload de: " + filename + " (" + fileData.length + " bytes)");

    StreamObserver<AudioChunk> requestObserver = processingStub
            .withDeadlineAfter(120, TimeUnit.SECONDS) // Timeout aumentado para 120 segundos
            .uploadAudio(new StreamObserver<AudioUploadResponse>() {
              @Override
              public void onNext(AudioUploadResponse response) {
                System.out.println("Resposta recebida do servidor");
                if (response.getSuccess()) {
                  uploadedFileId[0] = response.getFileId();
                  System.out.println("Upload bem-sucedido! ID: " + response.getFileId());
                  System.out.println("Arquivo: " + response.getFilename());
                  System.out.println("Tamanho: " + response.getSize() + " bytes");
                } else {
                  System.err.println("Falha no upload: " + response.getMessage());
                  uploadError[0] = new Exception("Upload falhou: " + response.getMessage());
                }
              }

              @Override
              public void onError(Throwable t) {
                if (!isShutdown.get()) {
                  System.err.println("Erro no upload: " + t.getMessage());
                  uploadError[0] = new Exception(t);
                }
                latch.countDown();
              }

              @Override
              public void onCompleted() {
                System.out.println("Upload stream completado");
                completed.set(true);
                latch.countDown();
              }
            });

    try {
      // Enviar arquivo em chunks menores
      int chunkSize = 32 * 1024; // 32KB por chunk (reduzido ainda mais)
      int totalChunks = (int) Math.ceil((double) fileData.length / chunkSize);

      System.out.println("Enviando " + totalChunks + " chunks de " + chunkSize + " bytes cada");

      for (int i = 0; i < totalChunks; i++) {
        if (isShutdown.get()) {
          throw new Exception("Client foi shutdown durante o upload");
        }

        int start = i * chunkSize;
        int end = Math.min(start + chunkSize, fileData.length);
        byte[] chunkData = new byte[end - start];
        System.arraycopy(fileData, start, chunkData, 0, end - start);

        AudioChunk chunk = AudioChunk.newBuilder()
                .setData(ByteString.copyFrom(chunkData))
                .setFilename(filename)
                .setChunkNumber(i + 1)
                .setTotalChunks(totalChunks)
                .setContentType("audio/wav")
                .build();

        requestObserver.onNext(chunk);
        System.out.println("Enviado chunk " + (i + 1) + "/" + totalChunks);

        // Pequena pausa entre chunks para evitar sobrecarga
        Thread.sleep(50); // Aumentado para 50ms
      }

      System.out.println("Finalizando envio...");
      requestObserver.onCompleted();

      // Aguardar resposta com timeout maior
      boolean finished = latch.await(150, TimeUnit.SECONDS);

      if (!finished) {
        throw new Exception("Timeout aguardando resposta do upload");
      }

      if (uploadError[0] != null) {
        throw uploadError[0];
      }

      if (!completed.get()) {
        throw new Exception("Upload não foi completado corretamente");
      }

      if (uploadedFileId[0] == null) {
        throw new Exception("ID do arquivo não foi retornado");
      }

      return uploadedFileId[0];

    } catch (Exception e) {
      System.err.println("Erro durante o upload: " + e.getMessage());
      // Não chamar onError aqui se já houve shutdown
      if (!isShutdown.get()) {
        try {
          requestObserver.onError(e);
        } catch (Exception ignored) {
          // Ignora erro ao tentar reportar erro
        }
      }
      throw e;
    }
  }

  // Processamento completo: upload -> processo -> conversão -> análise
  public void processCompleteWorkflow(String filePath) {
    try {
      if (isShutdown.get()) {
        throw new IllegalStateException("Client is already shutdown");
      }

      System.out.println("=== INICIANDO WORKFLOW COMPLETO ===");

      // 1. Upload do arquivo
      System.out.println("\n1. UPLOAD DO ARQUIVO");
      String fileId = uploadAudio(filePath);

      // Pequena pausa após upload
      Thread.sleep(1000);

      // 2. Obter informações do arquivo
      System.out.println("\n2. INFORMAÇÕES DO ARQUIVO");
      AudioInfoRequest infoRequest = AudioInfoRequest.newBuilder()
              .setFileId(fileId)
              .build();
      AudioInfoResponse info = processingBlockingStub
              .withDeadlineAfter(30, TimeUnit.SECONDS)
              .getAudioInfo(infoRequest);

      System.out.println("Arquivo: " + info.getFilename());
      System.out.println("Formato: " + info.getFormat());
      System.out.println("Duração: " + info.getDurationSeconds() + "s");
      System.out.println("Sample Rate: " + info.getSampleRate() + " Hz");
      System.out.println("Canais: " + info.getChannels());

      // 3. Processamento de áudio
      System.out.println("\n3. PROCESSAMENTO DE ÁUDIO");

      // Primeiro, vamos tentar um processamento mais simples
      ProcessingOptions simpleOptions = ProcessingOptions.newBuilder()
              .setNormalize(true)
              .setApplyEqualizer(false) // Desabilitar equalizer primeiro
              .setApplyNoiseReduction(false) // Desabilitar noise reduction primeiro
              .setVolumeAdjustment(0.0) // Sem ajuste de volume
              .build();

      AudioProcessRequest processRequest = AudioProcessRequest.newBuilder()
              .setFileId(fileId)
              .setOptions(simpleOptions)
              .build();

      System.out.println("Tentando processamento simples (apenas normalização)...");

      AudioProcessResponse processResponse;
      String processedFileId;

      try {
        processResponse = processingBlockingStub
                .withDeadlineAfter(60, TimeUnit.SECONDS)
                .processAudio(processRequest);
        processedFileId = processResponse.getProcessedFileId();

        System.out.println("Processamento simples bem-sucedido!");

      } catch (Exception e) {
        System.err.println("Processamento simples falhou: " + e.getMessage());
        System.out.println("Tentando processamento sem nenhuma opção...");

        // Tentar sem nenhuma opção de processamento
        ProcessingOptions noOptions = ProcessingOptions.newBuilder()
                .setNormalize(false)
                .setApplyEqualizer(false)
                .setApplyNoiseReduction(false)
                .setVolumeAdjustment(0.0)
                .build();

        AudioProcessRequest noProcessRequest = AudioProcessRequest.newBuilder()
                .setFileId(fileId)
                .setOptions(noOptions)
                .build();

        try {
          processResponse = processingBlockingStub
                  .withDeadlineAfter(60, TimeUnit.SECONDS)
                  .processAudio(noProcessRequest);
          processedFileId = processResponse.getProcessedFileId();

          System.out.println("Processamento sem opções bem-sucedido!");

        } catch (Exception e2) {
          System.err.println("Todos os tipos de processamento falharam.");
          System.err.println("Erro detalhado: " + e2.getMessage());
          System.err.println("Pulando etapas de processamento e conversão...");

          // Continuar com análise usando arquivo original
          performAnalysisOnly(fileId);
          return;
        }
      }

      System.out.println("Processamento concluído!");
      System.out.println("Arquivo processado ID: " + processedFileId);
      System.out.println("Tempo de processamento: " +
              processResponse.getStats().getProcessingTimeSeconds() + "s");

      // 4. Conversão para MP3 (opcional)
      performConversion(processedFileId);

      // 5. Análise do áudio
      performAnalysisOnly(fileId);

      System.out.println("\n=== WORKFLOW COMPLETO CONCLUÍDO ===");

    } catch (Exception e) {
      System.err.println("Erro durante o workflow: " + e.getMessage());
      e.printStackTrace();
    }
  }

  // Método separado para conversão
  private void performConversion(String fileId) {
    try {
      System.out.println("\n4. CONVERSÃO PARA MP3");
      ConversionOptions conversionOptions = ConversionOptions.newBuilder()
              .setSampleRate(44100)
              .setChannels(2)
              .setBitDepth(16)
              .setQuality(8)
              .build();

      AudioConversionRequest conversionRequest = AudioConversionRequest.newBuilder()
              .setFileId(fileId)
              .setTargetFormat("mp3")
              .setOptions(conversionOptions)
              .build();

      AudioConversionResponse conversionResponse = conversionStub
              .withDeadlineAfter(60, TimeUnit.SECONDS)
              .convertAudioFormat(conversionRequest);
      String convertedFileId = conversionResponse.getConvertedFileId();

      System.out.println("Conversão concluída!");
      System.out.println("Arquivo convertido ID: " + convertedFileId);
      System.out.println("Formato: " + conversionResponse.getOriginalFormat() +
              " -> " + conversionResponse.getTargetFormat());

    } catch (Exception e) {
      System.err.println("Erro na conversão: " + e.getMessage());
      System.err.println("Continuando sem conversão...");
    }
  }

  // Método separado para análise
  private void performAnalysisOnly(String fileId) {
    try {
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
      try {
        AudioAnalysisResponse analysisResponse = analysisStub
                .withDeadlineAfter(30, TimeUnit.SECONDS)
                .analyzeFrequency(analysisRequest);
        System.out.println("Análise de frequência concluída!");
        System.out.println("Pico de frequência: " +
                String.format("%.1f", analysisResponse.getSpectrum().getPeakFrequency()) + " Hz");
        System.out.println("RMS Level: " +
                String.format("%.2f", analysisResponse.getStatistics().getRmsLevel()) + " dB");
        System.out.println("SNR: " +
                String.format("%.1f", analysisResponse.getStatistics().getSignalToNoiseRatio()) + " dB");
      } catch (Exception e) {
        System.err.println("Erro na análise de frequência: " + e.getMessage());
      }

      // Detecção de silêncio
      try {
        SilenceDetectionResponse silenceResponse = analysisStub
                .withDeadlineAfter(30, TimeUnit.SECONDS)
                .detectSilence(analysisRequest);
        System.out.println("\nDetecção de silêncio:");
        System.out.println("Segmentos de silêncio: " + silenceResponse.getSilenceSegmentsCount());
        System.out.println("Duração total de silêncio: " +
                String.format("%.1f", silenceResponse.getTotalSilenceDuration()) + "s");
        System.out.println("Porcentagem de silêncio: " +
                String.format("%.1f", silenceResponse.getSilencePercentage()) + "%");
      } catch (Exception e) {
        System.err.println("Erro na detecção de silêncio: " + e.getMessage());
      }

      // Extração de características
      try {
        AudioFeaturesResponse featuresResponse = analysisStub
                .withDeadlineAfter(30, TimeUnit.SECONDS)
                .extractFeatures(analysisRequest);
        System.out.println("\nCaracterísticas extraídas:");
        System.out.println("Tempo: " + String.format("%.1f", featuresResponse.getTempo()) + " BPM");
        System.out.println("Tom: " + featuresResponse.getKey());
        System.out.println("Loudness: " + String.format("%.1f", featuresResponse.getLoudness()) + " dB");
        System.out.println("Centroide espectral: " +
                String.format("%.1f", featuresResponse.getSpectralFeatures().getSpectralCentroid()) + " Hz");
      } catch (Exception e) {
        System.err.println("Erro na extração de características: " + e.getMessage());
      }

    } catch (Exception e) {
      System.err.println("Erro geral na análise: " + e.getMessage());
    }
  }

  // Listar todos os arquivos
  public void listFiles() {
    try {
      if (isShutdown.get()) {
        throw new IllegalStateException("Client is already shutdown");
      }

      ListAudioFilesRequest request = ListAudioFilesRequest.newBuilder()
              .setPage(1)
              .setPageSize(10)
              .build();

      ListAudioFilesResponse response = processingBlockingStub
              .withDeadlineAfter(30, TimeUnit.SECONDS)
              .listAudioFiles(request);

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

  public void testConnection() {
    try {
      if (isShutdown.get()) {
        throw new IllegalStateException("Client is already shutdown");
      }

      System.out.println("Testando conexão com servidores...");

      // Teste servidor de processamento
      try {
        ListAudioFilesRequest request = ListAudioFilesRequest.newBuilder()
                .setPage(1)
                .setPageSize(1)
                .build();

        ListAudioFilesResponse response = processingBlockingStub
                .withDeadlineAfter(10, TimeUnit.SECONDS)
                .listAudioFiles(request);
        System.out.println("✓ Conexão com servidor de processamento OK (porta 50051)");
      } catch (Exception e) {
        System.err.println("✗ Erro na conexão com servidor de processamento: " + e.getMessage());
      }

      // Teste servidor de conversão
      try {
        // Pode não ter um método de teste, então vamos apenas verificar se o canal está ativo
        if (!conversionChannel.isShutdown()) {
          System.out.println("✓ Canal de conversão está ativo (porta 50052)");
        }
      } catch (Exception e) {
        System.err.println("✗ Erro no canal de conversão: " + e.getMessage());
      }

      // Teste servidor de análise
      try {
        // Pode não ter um método de teste, então vamos apenas verificar se o canal está ativo
        if (!analysisChannel.isShutdown()) {
          System.out.println("✓ Canal de análise está ativo (porta 50053)");
        }
      } catch (Exception e) {
        System.err.println("✗ Erro no canal de análise: " + e.getMessage());
      }

    } catch (Exception e) {
      System.err.println("✗ Erro geral nos testes de conexão: " + e.getMessage());
      e.printStackTrace();
    }
  }

  // Método para diagnóstico do servidor
  public void diagnoseServer() {
    try {
      System.out.println("\n=== DIAGNÓSTICO DO SERVIDOR ===");

      // Verificar se os canais estão ativos
      System.out.println("Estado dos canais:");
      System.out.println("- Processing: " + (processingChannel.isShutdown() ? "DESLIGADO" : "ATIVO"));
      System.out.println("- Conversion: " + (conversionChannel.isShutdown() ? "DESLIGADO" : "ATIVO"));
      System.out.println("- Analysis: " + (analysisChannel.isShutdown() ? "DESLIGADO" : "ATIVO"));

      // Listar arquivos para verificar se o servidor está funcionando
      System.out.println("\nTestando listagem de arquivos...");
      listFiles();

    } catch (Exception e) {
      System.err.println("Erro no diagnóstico: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    AudioProcessingClient client = new AudioProcessingClient(
            "localhost", 50051, // Processing Server
            "localhost", 50052, // Conversion Server
            "localhost", 50053 // Analysis Server
    );

    try {
      // Teste de conectividade primeiro
      client.testConnection();

      // Diagnóstico adicional
      client.diagnoseServer();

      // Aguardar um pouco após teste de conectividade
      Thread.sleep(2000);

      // Se chegou aqui, a conexão está OK
      String audioFilePath = "teste.wav";

      // Verificar se o arquivo existe
      File testFile = new File(audioFilePath);
      if (!testFile.exists()) {
        System.err.println("Arquivo não encontrado: " + audioFilePath);
        System.err.println("Por favor, certifique-se de que o arquivo existe antes de executar o cliente.");
        return;
      }

      System.out.println("Arquivo encontrado: " + audioFilePath + " (" + testFile.length() + " bytes)");

      client.processCompleteWorkflow(audioFilePath);

      // Aguardar antes de listar arquivos
      Thread.sleep(2000);

      // Listar arquivos finais
      System.out.println("\n=== ARQUIVOS FINAIS ===");
      client.listFiles();

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        client.shutdown();
      } catch (InterruptedException e) {
        System.err.println("Erro ao fechar conexões: " + e.getMessage());
        Thread.currentThread().interrupt();
      }
    }
  }
}