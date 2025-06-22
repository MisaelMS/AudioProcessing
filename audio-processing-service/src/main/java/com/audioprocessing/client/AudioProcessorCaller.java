package com.audioprocessing.client;

import com.audioprocessing.client.AudioProcessingClient;
import java.io.File;
import java.util.Scanner;

public class AudioProcessorCaller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Exemplo 1: Processar um arquivo específico
            System.out.println("=== EXEMPLO DE USO DO AUDIOPROCESSINGCLIENT ===\n");

            // Pedir caminho do arquivo ao usuário
            System.out.print("Digite o caminho do arquivo de áudio (ou ENTER para usar 'teste.wav'): ");
            String filePath = scanner.nextLine().trim();

            if (filePath.isEmpty()) {
                filePath = "teste.wav";
            }

            // Verificar se o arquivo existe
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                System.err.println("Arquivo não encontrado: " + filePath);
                System.err.println("Criando um arquivo de exemplo...");
                createExampleAudioFile(filePath);
            }

            System.out.println("Processando arquivo: " + filePath);

            // Chamar o método estático do AudioProcessingClient
            AudioProcessingClient.processAudioFile(filePath);

            System.out.println("Processamento concluído!");

        } catch (Exception e) {
            System.err.println("Erro durante o processamento: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    /**
     * Exemplo de processamento de múltiplos arquivos
     */
    public static void processMultipleFiles(String[] filePaths) {
        System.out.println("=== PROCESSAMENTO DE MÚLTIPLOS ARQUIVOS ===\n");

        for (int i = 0; i < filePaths.length; i++) {
            String filePath = filePaths[i];

            try {
                System.out.println("Processando arquivo " + (i + 1) + "/" + filePaths.length + ": " + filePath);

                // Verificar se o arquivo existe
                File audioFile = new File(filePath);
                if (!audioFile.exists()) {
                    System.err.println("Arquivo não encontrado: " + filePath + " - Pulando...");
                    continue;
                }

                // Processar o arquivo
                AudioProcessingClient.processAudioFile(filePath);

                System.out.println("Arquivo processado com sucesso: " + filePath);

                // Pequena pausa entre arquivos
                Thread.sleep(2000);

            } catch (Exception e) {
                System.err.println("Erro ao processar " + filePath + ": " + e.getMessage());
                // Continua com o próximo arquivo
            }
        }

        System.out.println("🏁 Processamento de todos os arquivos concluído!");
    }

    /**
     * Exemplo de uso programático
     */
    public static void programmaticExample() {
        // Lista de arquivos para processar
        String[] audioFiles = {
                "audio1.wav",
                "audio2.mp3",
                "audio3.wav"
        };

        // Processar todos os arquivos
        processMultipleFiles(audioFiles);
    }

    /**
     * Criar um arquivo de áudio de exemplo (simulado)
     * Na prática, você colocaria aqui um arquivo real
     */
    private static void createExampleAudioFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                // Aqui você criaria um arquivo de áudio real
                // Por agora, vamos apenas simular
                System.out.println("Para testar, você precisa colocar um arquivo de áudio real em: " + filePath);
                System.out.println("Formatos suportados: .wav, .mp3, .flac, etc.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao criar arquivo de exemplo: " + e.getMessage());
        }
    }
}