#!/bin/bash

# build_and_run.sh - Script para compilar e executar o sistema de processamento de áudio

echo "=== Sistema Distribuído de Processamento de Áudio ==="
echo "Compilando e executando serviços gRPC..."

# Definir diretórios
PROJECT_DIR="audio-processing-service"
SRC_DIR="$PROJECT_DIR/src/main/java"
PROTO_DIR="$PROJECT_DIR/src/main/proto"
BUILD_DIR="$PROJECT_DIR/build"
LIB_DIR="$PROJECT_DIR/lib"

# Criar estrutura de diretórios
mkdir -p $SRC_DIR/com/audioprocessing/server
mkdir -p $SRC_DIR/com/audioprocessing/client
mkdir -p $PROTO_DIR
mkdir -p $BUILD_DIR
mkdir -p $LIB_DIR

echo "Estrutura de diretórios criada."

# Função para baixar dependências
download_dependencies() {
    echo "Baixando dependências gRPC..."
    
    # URLs das dependências (versões compatíveis)
    GRPC_VERSION="1.53.0"
    PROTOBUF_VERSION="3.21.12"
    
    # Lista de JARs necessários
    JARS=(
        "https://repo1.maven.org/maven2/io/grpc/grpc-netty-shaded/$GRPC_VERSION/grpc-netty-shaded-$GRPC_VERSION.jar"
        "https://repo1.maven.org/maven2/io/grpc/grpc-protobuf/$GRPC_VERSION/grpc-protobuf-$GRPC_VERSION.jar"
        "https://repo1.maven.org/maven2/io/grpc/grpc-stub/$GRPC_VERSION/grpc-stub-$GRPC_VERSION.jar"
        "https://repo1.maven.org/maven2/com/google/protobuf/protobuf-java/$PROTOBUF_VERSION/protobuf-java-$PROTOBUF_VERSION.jar"
        "https://repo1.maven.org/maven2/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar"
        "https://repo1.maven.org/maven2/com/google/guava/guava/31.1-jre/guava-31.1-jre.jar"
        "https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar"
    )
    
    for jar in "${JARS[@]}"; do
        filename=$(basename "$jar")
        if [ ! -f "$LIB_DIR/$filename" ]; then
            echo "Baixando $filename..."
            curl -L -o "$LIB_DIR/$filename" "$jar"
        else
            echo "$filename já existe."
        fi
    done
    
    echo "Dependências baixadas."
}

# Função para gerar código gRPC
generate_grpc_code() {
    echo "Gerando código gRPC a partir do arquivo .proto..."
    
    # Verificar se protoc está instalado
    if ! command -v protoc &> /dev/null; then
        echo "ERRO: protoc não está instalado."
        echo "Instale o Protocol Buffers compiler:"
        echo "Ubuntu/Debian: sudo apt-get install protobuf-compiler"
        echo "macOS: brew install protobuf"
        echo "Windows: Baixe de https://github.com/protocolbuffers/protobuf/releases"
        exit 1
    fi
    
    # Verificar se o plugin gRPC Java está disponível
    if ! command -v protoc-gen-grpc-java &> /dev/null; then
        echo "AVISO: protoc-gen-grpc-java não encontrado."
        echo "Tentando usar plugin do classpath..."
    fi
    
    # Gerar código Java
    protoc --proto_path=$PROTO_DIR \
           --java_out=$SRC_DIR \
           --grpc-java_out=$SRC_DIR \
           $PROTO_DIR/audio_service.proto
    
    if [ $? -eq 0 ]; then
        echo "Código gRPC gerado com sucesso."
    else
        echo "ERRO: Falha ao gerar código gRPC."
        exit 1
    fi
}

# Função para compilar o projeto
compile_project() {
    echo "Compilando projeto Java..."
    
    # Construir classpath
    CLASSPATH="$BUILD_DIR"
    for jar in $LIB_DIR/*.jar; do
        CLASSPATH="$CLASSPATH:$jar"
    done
    
    # Compilar todos os arquivos Java
    find $SRC_DIR -name "*.java" -exec javac -cp "$CLASSPATH" -d "$BUILD_DIR" {} +
    
    if [ $? -eq 0 ]; then
        echo "Compilação concluída com sucesso."
    else
        echo "ERRO: Falha na compilação."
        exit 1
    fi
}

# Função para executar servidores
start_servers() {
    echo "Iniciando servidores..."
    
    # Construir classpath
    CLASSPATH="$BUILD_DIR"
    for jar in $LIB_DIR/*.jar; do
        CLASSPATH="$CLASSPATH:$jar"
    done
    
    # Iniciar servidor de processamento
    echo "Iniciando AudioProcessingServer (porta 50051)..."
    java -cp "$CLASSPATH" com.audioprocessing.server.AudioProcessingServer &
    PROC_PID=$!
    
    # Aguardar inicialização
    sleep 2
    
    # Iniciar servidor de conversão
    echo "Iniciando AudioConversionServer (porta 50052)..."
    java -cp "$CLASSPATH" com.audioprocessing.server.AudioConversionServer &
    CONV_PID=$!
    
    # Aguardar inicialização
    sleep 2
    
    # Iniciar servidor de análise
    echo "Iniciando AudioAnalysisServer (porta 50053)..."
    java -cp "$CLASSPATH" com.audioprocessing.server.AudioAnalysisServer &
    ANAL_PID=$!
    
    # Aguardar inicialização
    sleep 3
    
    echo "Todos os servidores iniciados!"
    echo "AudioProcessingServer PID: $PROC_PID"
    echo "AudioConversionServer PID: $CONV_PID"
    echo "AudioAnalysisServer PID: $ANAL_PID"
    
    # Salvar PIDs para posterior cleanup
    echo "$PROC_PID" > /tmp/audio_proc_pid
    echo "$CONV_PID" > /tmp/audio_conv_pid
    echo "$ANAL_PID" > /tmp/audio_anal_pid
}

# Função para executar cliente de teste
run_client() {
    echo "Executando cliente de teste..."
    
    # Construir classpath
    CLASSPATH="$BUILD_DIR"
    for jar in $LIB_DIR/*.jar; do
        CLASSPATH="$CLASSPATH:$jar"
    done
    
    # Aguardar servidores estarem prontos
    sleep 5
    
    # Executar cliente
    java -cp "$CLASSPATH" com.audioprocessing.client.AudioProcessingClient
}

# Função para parar servidores
stop_servers() {
    echo "Parando servidores..."
    
    if [ -f /tmp/audio_proc_pid ]; then
        kill $(cat /tmp/audio_proc_pid) 2>/dev/null
        rm /tmp/audio_proc_pid
    fi
    
    if [ -f /tmp/audio_conv_pid ]; then
        kill $(cat /tmp/audio_conv_pid) 2>/dev/null
        rm /tmp/audio_conv_pid
    fi
    
    if [ -f /tmp/audio_anal_pid ]; then
        kill $(cat /tmp/audio_anal_pid) 2>/dev/null
        rm /tmp/audio_anal_pid
    fi
    
    echo "Servidores parados."
}

# Função para limpeza
cleanup() {
    echo "Limpando processos..."
    stop_servers
    exit 0
}

# Capturar sinais para limpeza
trap cleanup SIGINT SIGTERM

# Menu principal
case "$1" in
    "setup")
        download_dependencies
        ;;
    "generate")
        generate_grpc_code
        ;;
    "compile")
        compile_project
        ;;
    "servers")
        start_servers
        echo "Pressione Ctrl+C para parar os servidores..."
        wait
        ;;
    "client")
        run_client
        ;;
    "full")
        download_dependencies
        generate_grpc_code
        compile_project
        start_servers
        run_client
        stop_servers
        ;;
    "stop")
        stop_servers
        ;;
    *)
        echo "Uso: $0 {setup|generate|compile|servers|client|full|stop}"
        echo ""
        echo "Comandos:"
        echo "  setup    - Baixar dependências"
        echo "  generate - Gerar código gRPC"
        echo "  compile  - Compilar projeto"
        echo "  servers  - Iniciar servidores"
        echo "  client   - Executar cliente de teste"
        echo "  full     - Executar workflow completo"
        echo "  stop     - Parar servidores"
        echo ""
        echo "Exemplo de uso completo:"
        echo "  ./build_and_run.sh full"
        exit 1
        ;;
esac