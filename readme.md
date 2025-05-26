# 🚀 Desafio Backend - Desenvolvedor Júnior Itaú Unibanco

Este projeto foi desenvolvido como resposta ao **Desafio de Programação do Itaú Unibanco** para a vaga de **Desenvolvedor Júnior Backend**. A proposta consiste em criar uma API RESTful capaz de registrar transações financeiras e retornar estatísticas baseadas nas transações realizadas nos últimos 60 segundos.

---

## 📋 Descrição do Desafio

A API deve:

- Registrar transações financeiras
- Calcular estatísticas das transações nos últimos 60 segundos
- Armazenar os dados **em memória**
- Expor endpoints REST com payloads **estritamente definidos**
- Ser desenvolvida com **Java + Spring Boot**
- **Não utilizar banco de dados** nem cache

---

## 🛠 Tecnologias e Ferramentas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **SLF4J / Logback** (Logs)
- **Docker**
- **Swagger/OpenAPI** (Documentação de API)
- **Spring Actuator** (Healthcheck)

---

## 📦 Endpoints da API

### ✅ Criar Transação
`POST /transacao`

```json
{
  "valor": 123.45,
  "dataHora": "2024-08-07T12:34:56.789-03:00"
}
```

## Respostas:

201 Created → Transação válida

422 Unprocessable Entity → Valor negativo ou data no futuro

400 Bad Request → JSON malformado

📊 Estatísticas
GET /estatistica

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.46,
  "min": 12.34,
  "max": 456.78
}
```
Retorna as estatísticas das transações feitas nos últimos 60 segundos

Se não houverem transações, retorna tudo com valor 0

### 🧹 Deletar Transações

```json
DELETE /transacao
```

Remove todas as transações da memória
```json
204 No Content
```

### 📄 Documentação com Swagger

Você pode visualizar e testar todos os endpoints acessando:

http://localhost:8080/swagger-ui.html


### Extras Implementados

✅ Logs  
✅ Docker  
✅ Healthcheck  
✅ Swagger

### 🐳 Como executar com Docker
1º Construir a imagem
```json
docker build -t transacao-api .
```

2º Rodar o container
```json
docker run -p 8080:8080 transacao-api
```
A aplicação estará disponível em http://localhost:8080.


### 📁 Estrutura do Projeto

```json
src/
├── controller/       # Endpoints da API
├── dto/              # Objetos de requisição e resposta
├── model/            # Entidade de domínio
├── repository/       # Simula persistência em memória
├── service/          # Lógica de negócio
└── resources/
    └── application.properties

```