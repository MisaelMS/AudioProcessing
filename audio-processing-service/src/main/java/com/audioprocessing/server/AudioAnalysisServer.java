package com.audioprocessing.server;

import com.audioprocessing.grpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AudioAnalysisServer {
  private static final int PORT = 50053;
  private Server server;

  public static void main(String[] args) throws Exception {
    AudioAnalysisServer server = new AudioAnalysisServer();
    server.start();
    server.blockUntilShutdown();
  }

  private void start() throws Exception {
    server = NettyServerBuilder
            .forAddress(new InetSocketAddress("0.0.0.0", PORT))
            .addService(new AudioAnalysisServiceImpl())
            .build()
            .start();

    System.out.println("Servidor de Análise de Áudio iniciado na porta " + PORT);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("Desligando servidor de análise gRPC...");
      AudioAnalysisServer.this.stop();
      System.err.println("Servidor de análise desligado.");
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

  private class AudioAnalysisServiceImpl extends AudioAnalysisServiceGrpc.AudioAnalysisServiceImplBase {

    @Override
    public void analyzeFrequency(AudioAnalysisRequest request, StreamObserver<AudioAnalysisResponse> responseObserver) {
      String fileId = request.getFileId();
      AnalysisOptions options = request.getOptions();

      try {
        System.out.println("Iniciando análise de frequência para arquivo: " + fileId);

        // Simular análise de frequência
        Thread.sleep(2000); // Simular processamento

        // Gerar espectro de frequência simulado
        FrequencySpectrum spectrum = generateFrequencySpectrum();

        // Gerar forma de onda simulada se solicitado
        List<Double> waveformSamples = new ArrayList<>();
        if (options.getIncludeWaveform()) {
          waveformSamples = generateWaveformSamples();
        }

        // Gerar estatísticas de áudio
        AudioStatistics statistics = generateAudioStatistics();

        AudioAnalysisResponse response = AudioAnalysisResponse.newBuilder()
            .setFileId(fileId)
            .setSpectrum(spectrum)
            .addAllWaveformSamples(waveformSamples)
            .setStatistics(statistics)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Análise de frequência concluída para arquivo: " + fileId);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        responseObserver.onError(new RuntimeException("Análise interrompida", e));
      } catch (Exception e) {
        System.err.println("Erro durante análise de frequência: " + e.getMessage());
        responseObserver.onError(e);
      }
    }

    @Override
    public void detectSilence(AudioAnalysisRequest request, StreamObserver<SilenceDetectionResponse> responseObserver) {
      String fileId = request.getFileId();

      try {
        System.out.println("Iniciando detecção de silêncio para arquivo: " + fileId);

        // Simular detecção de silêncio
        Thread.sleep(1500);

        // Gerar segmentos de silêncio simulados
        List<SilenceSegment> silenceSegments = generateSilenceSegments();

        // Calcular estatísticas de silêncio
        double totalSilenceDuration = silenceSegments.stream()
            .mapToDouble(SilenceSegment::getDuration)
            .sum();

        double totalDuration = 180.0; // Duração total simulada
        double silencePercentage = (totalSilenceDuration / totalDuration) * 100;

        SilenceDetectionResponse response = SilenceDetectionResponse.newBuilder()
            .setFileId(fileId)
            .addAllSilenceSegments(silenceSegments)
            .setTotalSilenceDuration(totalSilenceDuration)
            .setSilencePercentage(silencePercentage)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Detecção de silêncio concluída: " + silenceSegments.size() +
            " segmentos encontrados (" + String.format("%.1f", silencePercentage) + "%)");

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        responseObserver.onError(new RuntimeException("Detecção interrompida", e));
      } catch (Exception e) {
        System.err.println("Erro durante detecção de silêncio: " + e.getMessage());
        responseObserver.onError(e);
      }
    }

    @Override
    public void extractFeatures(AudioAnalysisRequest request, StreamObserver<AudioFeaturesResponse> responseObserver) {
      String fileId = request.getFileId();

      try {
        System.out.println("Iniciando extração de características para arquivo: " + fileId);

        // Simular extração de características
        Thread.sleep(3000);

        // Gerar coeficientes MFCC simulados
        List<Double> mfccCoefficients = generateMFCCCoefficients();

        // Gerar características espectrais
        SpectralFeatures spectralFeatures = generateSpectralFeatures();

        // Gerar outras características
        double tempo = 120.0 + ThreadLocalRandom.current().nextDouble(-20, 20); // BPM
        String[] keys = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
        String[] modes = { "major", "minor" };
        String key = keys[ThreadLocalRandom.current().nextInt(keys.length)] + " " +
            modes[ThreadLocalRandom.current().nextInt(modes.length)];
        double loudness = -10.0 + ThreadLocalRandom.current().nextDouble(-15, 5); // dB

        AudioFeaturesResponse response = AudioFeaturesResponse.newBuilder()
            .setFileId(fileId)
            .setTempo(tempo)
            .setKey(key)
            .setLoudness(loudness)
            .addAllMfccCoefficients(mfccCoefficients)
            .setSpectralFeatures(spectralFeatures)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        System.out.println("Extração de características concluída: Tempo=" +
            String.format("%.1f", tempo) + " BPM, Tom=" + key);

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        responseObserver.onError(new RuntimeException("Extração interrompida", e));
      } catch (Exception e) {
        System.err.println("Erro durante extração de características: " + e.getMessage());
        responseObserver.onError(e);
      }
    }

    private FrequencySpectrum generateFrequencySpectrum() {
      List<Double> frequencies = new ArrayList<>();
      List<Double> magnitudes = new ArrayList<>();

      // Gerar espectro de frequência simulado (0-22050 Hz)
      for (int i = 0; i < 1024; i++) {
        double freq = (double) i * 22050.0 / 1024.0;
        frequencies.add(freq);

        // Simular magnitude com picos em certas frequências
        double magnitude = Math.random() * 0.1; // Ruído base

        // Adicionar picos simulados
        if (freq > 80 && freq < 120)
          magnitude += 0.3; // Baixo
        if (freq > 400 && freq < 800)
          magnitude += 0.4; // Médios
        if (freq > 2000 && freq < 4000)
          magnitude += 0.2; // Agudos

        magnitudes.add(magnitude);
      }

      // Encontrar pico de frequência
      double peakFreq = 0;
      double maxMagnitude = 0;
      for (int i = 0; i < frequencies.size(); i++) {
        if (magnitudes.get(i) > maxMagnitude) {
          maxMagnitude = magnitudes.get(i);
          peakFreq = frequencies.get(i);
        }
      }

      return FrequencySpectrum.newBuilder()
          .addAllFrequencies(frequencies)
          .addAllMagnitudes(magnitudes)
          .setPeakFrequency(peakFreq)
          .build();
    }

    private List<Double> generateWaveformSamples() {
      List<Double> samples = new ArrayList<>();

      // Gerar 1000 amostras de forma de onda simulada
      for (int i = 0; i < 1000; i++) {
        double time = (double) i / 44100.0; // Tempo em segundos
        double sample = 0.5 * Math.sin(2 * Math.PI * 440 * time) + // Lá (440 Hz)
            0.3 * Math.sin(2 * Math.PI * 880 * time) + // Harmônico
            0.1 * Math.random() - 0.05; // Ruído
        samples.add(sample);
      }

      return samples;
    }

    private AudioStatistics generateAudioStatistics() {
      return AudioStatistics.newBuilder()
          .setRmsLevel(-12.5 + ThreadLocalRandom.current().nextDouble(-3, 3))
          .setPeakLevel(-3.2 + ThreadLocalRandom.current().nextDouble(-2, 2))
          .setDynamicRange(18.5 + ThreadLocalRandom.current().nextDouble(-5, 5))
          .setSignalToNoiseRatio(45.2 + ThreadLocalRandom.current().nextDouble(-10, 10))
          .build();
    }

    private List<SilenceSegment> generateSilenceSegments() {
      List<SilenceSegment> segments = new ArrayList<>();

      // Gerar 3-7 segmentos de silêncio aleatórios
      int numSegments = ThreadLocalRandom.current().nextInt(3, 8);
      double totalDuration = 180.0; // Duração total de 3 minutos

      for (int i = 0; i < numSegments; i++) {
        double startTime = ThreadLocalRandom.current().nextDouble(0, totalDuration - 5);
        double duration = ThreadLocalRandom.current().nextDouble(0.5, 3.0);
        double endTime = Math.min(startTime + duration, totalDuration);

        SilenceSegment segment = SilenceSegment.newBuilder()
            .setStartTime(startTime)
            .setEndTime(endTime)
            .setDuration(endTime - startTime)
            .build();

        segments.add(segment);
      }

      // Ordenar por tempo de início
      segments.sort((a, b) -> Double.compare(a.getStartTime(), b.getStartTime()));

      return segments;
    }

    private List<Double> generateMFCCCoefficients() {
      List<Double> coefficients = new ArrayList<>();

      // Gerar 13 coeficientes MFCC típicos
      for (int i = 0; i < 13; i++) {
        double coeff = ThreadLocalRandom.current().nextGaussian() * 10.0;
        coefficients.add(coeff);
      }

      return coefficients;
    }

    private SpectralFeatures generateSpectralFeatures() {
      return SpectralFeatures.newBuilder()
          .setSpectralCentroid(2500.0 + ThreadLocalRandom.current().nextDouble(-500, 500))
          .setSpectralBandwidth(1800.0 + ThreadLocalRandom.current().nextDouble(-300, 300))
          .setSpectralRolloff(8000.0 + ThreadLocalRandom.current().nextDouble(-1000, 1000))
          .setZeroCrossingRate(0.15 + ThreadLocalRandom.current().nextDouble(-0.05, 0.05))
          .build();
    }
  }
}