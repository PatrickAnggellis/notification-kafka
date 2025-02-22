# 📬 Notification Kafka Project

## 🌟 Descrição do Projeto

Este projeto é uma demonstração robusta de um serviço de notificações utilizando **Spring Boot** e **Apache Kafka**. 

A aplicação permite o envio e recebimento de notificações de usuários de forma eficiente e escalável, utilizando as melhores práticas de mensageria distribuída.

## 🛠 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- ☕ Java 17
- 🏗 Maven
- 🐳 Docker
- 🐳 Docker Compose

## 🚀 Configuração do Ambiente

### 1. Instalação do Docker

Baixe e instale o Docker Desktop para Windows:
- [Download Docker Desktop](https://www.docker.com/products/docker-desktop)

**Importante:** Certifique-se de que o Docker esteja rodando antes de iniciar o projeto.

### 2. Configuração do Kafka com Docker

#### Crie um arquivo `docker-compose.yml` na raiz do projeto:

```yaml
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  
  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    depends_on:
      - zookeeper
```

#### Iniciar o Kafka:

```bash
docker-compose up -d
```

#### Verificar containers em execução:

```bash
docker ps
```

## 🔧 Compilação e Execução do Projeto

### 1. Compilar o Projeto

```bash
mvn clean install
```

### 2. Executar a Aplicação

```bash
mvn spring-boot:run
```

## 🧪 Testando a Aplicação

### Usando Postman ou cURL

#### Criar um Usuário e Enviar Notificação

```bash
curl -X POST http://localhost:8080/usuarios \
     -H "Content-Type: application/json" \
     -d '{
         "nome": "Patrick Anggelis", 
         "email": "patrick@example.com", 
         "preferencia": "email"
     }'
```

### Verificar Logs

No console da aplicação, você verá logs de envio e recebimento da notificação:

```
Enviando notificação para o tópico notificacoes: Usuario{nome=Patrick Anggelis, ...}
Notificação recebida: Usuario{nome=Patrick Anggelis, ...}
```

## ⚙️ Configurações Importantes

### Kafka (application.properties)

- **Servidores:** `localhost:9092`
- **Grupo de Consumo:** `notification-group`
- **Serialização:** JSON
- **Pacotes Confiáveis:** `com.app.notificacao_kafka.model`

## 🔍 Troubleshooting

### Problemas Comuns

1. **Porta 9092 em uso**
   - Verifique se não há outro serviço usando a porta
   - Pare outros serviços Kafka ou altere a porta no `docker-compose.yml`

2. **Falha na Conexão com Kafka**
   - Certifique-se que o Docker está rodando
   - Verifique se os containers estão ativos com `docker ps`
   - Reinicie os containers com `docker-compose down` e `docker-compose up -d`

## 🛠️ Tecnologias Utilizadas

- 🍃 Spring Boot
- 🚀 Apache Kafka
- 🐳 Docker
- 💾 H2 Database
- 🔹 Lombok

## 🤝 Contribuição

Pull requests são bem-vindos! 

Para mudanças importantes, abra um issue primeiro para discutir o que você gostaria de mudar.

## 📄 Licença

[MIT](https://choosealicense.com/licenses/mit/)

---

**Desenvolvido com ❤️ por Patrick Anggelis**