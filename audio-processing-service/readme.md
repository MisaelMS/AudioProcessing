# Sistema de Processamento de Áudio - gRPC

Este é um sistema distribuído de processamento de áudio implementado com gRPC em Java. O sistema é composto por três serviços principais que trabalham em conjunto para fornecer funcionalidades completas de processamento de áudio.

## 🏗️ Arquitetura do Sistema

### Serviços

1. **AudioProcessingService** (Porta 50051)
   - Upload e download de arquivos de áudio
   - Processamento básico (normalização, equalização, redução de ruído)
   - Gerenciamento de metadados dos arquivos

2. **AudioConversionService** (Porta 50052)
   - Conversão entre diferentes formatos de áudio
   - Conversão em lote
   - Suporte a múltiplos formatos (MP3, WAV, FLAC, AAC, OGG, M4A, WMA)

3. **AudioAnalysisService** (Porta 50053)
   - Análise de frequência e espectro
   - Detecção de silêncio
   - Extração de características (tempo, tom, MFCC, etc.)

## 📋 Pré-requisitos

- **Java 11** ou superior
- **Apache Maven** 3.6 ou superior
- **Sistema operacional**: Linux, macOS ou Windows

### Verificação dos pré-requisitos

```bash
java -version    # Deve mostrar Java 11+
mvn --version    # Deve mostrar Maven 3.6+
```

## 🚀 Como Compilar e Executar

### Opção 1: Usando o Script Automatizado (Recomendado)

1. **Torne o script executável:**
   ```bash
   chmod +x build.sh
   ```

2. **Execute o script:**
   ```bash
   ./build.sh
   ```

3. **Selecione a opção 6** para setup completo, ou siga as opções individuais.

### Opção 2: Compilação Manual

1. **Crie a estrutura de diretórios:**
   ```bash
   mkdir -p src/main/proto
   mkdir -p src/main/java/com/audioprocessing/{server,client}
   mkdir -p {audio_files,processed_files}
   ```

2. **Organize os arquivos:**
   ```bash
   # Mover o arquivo proto
   mv audio_service.proto src/main/proto/
   
   # Mover os arquivos Java
   mv AudioProcessingServer.java src/main/java/com/audioprocessing/server/
   mv AudioConversionServer.java src/main/java/com/audioprocessing/server/
   mv AudioAnalysisServer.java src/main/java/com/audioprocessing/server/
   mv AudioProcessingClient.java src/main/java/com/audioprocessing/client/
   ```

3. **Gerar classes do protobuf:**
   ```bash
   mvn protobuf:compile protobuf:compile-custom
   ```

4. **Compilar o projeto:**
   ```bash
   mvn clean compile
   ```

5. **Criar JAR executável:**
   ```bash
   mvn package
   ```

## 🎮 Execução do Sistema

### Iniciando os Servidores

Abra **4 terminais diferentes** e execute cada comando em um terminal:

```bash
# Terminal 1 - Servidor de Processamento
java -cp target/audio-processing-service-1.0.0-jar-with-dependencies.jar com.audioprocessing.server.AudioProcessingServer

# Terminal 2 - Servidor de Conversão
java -cp target/audio-processing-service-1.0.0-jar-with-dependencies.jar com.audioprocessing.server.AudioConversionServer

# Terminal 3 - Servidor de Análise
java -cp target/audio-processing-service-1.0.0-jar-with-dependencies.jar com.audioprocessing.server.AudioAnalysisServer

# Terminal 4 - Cliente
java -cp target/audio-processing-service-1.0.0-jar-with-dependencies.jar com.audioprocessing.client.AudioProcessingClient
```

### Usando Maven Profiles

Alternativamente, você pode usar os profiles do Maven:

```bash
# Em terminais separados
mvn exec:java -Pprocessing-server
mvn exec:java -Pconversion-server
mvn exec:java -Panalysis-server
mvn exec:java -Pclient
```

## 📁 Estrutura do Projeto

```
audio-processing-service/
├── pom.xml                           # Configuração Maven
├── build.sh                          # Script de build
├── README.md                         # Esta documentação
├── src/
│   ├── main/
│   │   ├── proto/
│   │   │   └── audio_service.proto   # Definições gRPC
│   │   └── java/com/audioprocessing/
│   │       ├── server/
│   │       │   ├── AudioProcessingServer.java
│   │       │   ├── AudioConversionServer.java
│   │       │   └── AudioAnalysisServer.java
│   │       └── client/
│   │           └── AudioProcessingClient.java
│   └── test/java/                    # Testes unitários
├── target/                           # Arquivos compilados
├── audio_files/                      # Arquivos de áudio originais
├── processed_files/                  # Arquivos processados
└── logs/                            # Logs do sistema
```

## 🔧 Funcionalidades

### 1. Upload e Download de Arquivos
- Upload streaming de arquivos grandes
- Download em chunks
- Metadados automáticos

### 2. Processamento de Áudio
- **Normalização**: Ajuste automático de níveis
- **Equalização**: Controle de graves, médios e agudos  
- **Redução de Ruído**: Filtros de limpeza
- **Ajuste de Volume**: Controle fino do volume

### 3. Conversão de Formatos
- Suporte a: MP3, WAV, FLAC, AAC, OGG, M4A, WMA
- Conversão individual ou em lote
- Opções de qualidade configuráveis

### 4. Análise de Áudio
- **Análise de Frequência**: Espectro completo
- **Detecção de Silêncio**: Segmentos automáticos
- **Extração de Features**: Tempo, tom, MFCC, características espectrais

## 📊 Exemplo de Uso

O cliente demonstra um workflow completo:

1. **Upload** de um arquivo de áudio
2. **Obtenção** de informações do arquivo
3. **Processamento** com normalização e equalização
4. **Conversão** para formato MP3
5. **Análise** completa do áudio
6. **Listagem** de todos os arquivos

## 🐛 Solução de Problemas

### Erro de Compilação do Protobuf
```bash
# Limpar e regenerar
mvn clean
mvn protobuf:compile protobuf:compile-custom
```

### Porta já em uso
```bash
# Verificar processos usando as portas
lsof -i :50051
lsof -i :50052  
lsof -i :50053

# Matar processos se necessário
pkill -f AudioProcessingServer
```

### Arquivo não encontrado
- Certifique-se de que existe um arquivo `test_audio.wav` no diretório raiz
- Ou modifique o caminho no `AudioProcessingClient.java`

### Problemas de dependências
```bash
# Forçar download das dependências
mvn dependency:purge-local-repository
mvn clean install
```

## 🔍 Logs e Debug

Os servidores geram logs detalhados no console. Para debug:

1. **Habilite logs detalhados** modificando o nível no código
2. **Monitore as portas** com `netstat -tlnp | grep 500`
3. **Verifique conexões** com `telnet localhost 50051`

## 📝 Personalização

### Adicionando novos formatos de áudio
Edite `AudioConversionServer.java` e adicione o formato no `SUPPORTED_FORMATS`.

### Modificando parâmetros de processamento
Ajuste as opções em `ProcessingOptions` no arquivo proto.

### Alterando portas dos serviços
Modifique as constantes `PORT` em cada servidor.

## 🤝 Contribuição

1. Fork do projeto
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

**Desenvolvido com ❤️ usando gRPC e Java**