# 🎮 MyGamerBoxd API

API REST para gerenciamento e catalogação de coleções de jogos, desenvolvida com foco em **Clean Architecture**, **SOLID**, **testabilidade** e **manutenibilidade**.

O projeto permite o cadastro e gerenciamento de jogos, gêneros e plataformas, fornecendo uma base robusta para aplicações de catalogação e avaliação de games.

---

## 🚀 Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot 3.2.x
* Spring Data JPA
* Hibernate

### Banco de Dados

* H2 Database (In-Memory)

### Qualidade de Software

* JUnit 5
* Mockito
* JaCoCo

### Documentação

* SpringDoc OpenAPI (Swagger)

### Build & Dependências

* Apache Maven

---

## 🏛️ Arquitetura

O projeto foi estruturado seguindo os princípios de **Clean Architecture**, promovendo separação de responsabilidades e baixo acoplamento entre as camadas.

### Principais Decisões de Design

#### 🔒 Imutabilidade

Utilização de **Java Records** para DTOs, reduzindo boilerplate e garantindo maior consistência e segurança na transferência de dados.

#### 🔄 Extensibilidade

Aplicação do padrão **Strategy** para regras de cálculo e classificação, permitindo adicionar novos comportamentos sem modificar implementações existentes, respeitando o princípio **Open/Closed (OCP)**.

#### 🎯 Integridade dos Dados

Configuração precisa dos campos numéricos com:

```java
@Column(precision = 4, scale = 2)
```

garantindo consistência aritmética para avaliações armazenadas no banco de dados.

---

## ✨ Funcionalidades

* Cadastro de jogos
* Associação de gêneros
* Associação de plataformas
* Avaliação de jogos
* Documentação automática via Swagger
* Persistência utilizando JPA/Hibernate
* Testes unitários para regras de negócio

---

## ⚙️ Como Executar

### Pré-requisitos

* Java 17+
* Maven 3.8+

### Clone o projeto

```bash
git clone https://github.com/SEU_USUARIO/mygamerboxd.git
cd mygamerboxd
```

### Executar testes

```bash
./mvnw clean test
```

### Iniciar aplicação

```bash
./mvnw spring-boot:run
```

---

## 📖 Documentação da API

Após iniciar a aplicação, a documentação estará disponível em:

### Swagger UI

```text
http://localhost:8080/swagger-ui.html
```

### H2 Console

```text
http://localhost:8080/h2-console
```

---

## 📌 Exemplo de Requisição

### POST `/api/v1/jogos`

```json
{
  "titulo": "Elden Ring",
  "generos": [1],
  "plataformas": [1]
}
```

---

## 🧪 Qualidade e Testes

O projeto utiliza **JaCoCo** para análise de cobertura de testes.

A estratégia de testes foi concentrada principalmente na camada de regras de negócio (**Strategy Pattern**), onde está localizada a lógica mais crítica da aplicação, alcançando:

* ✅ 100% de cobertura dos algoritmos de cálculo
* ✅ Testes unitários com JUnit 5
* ✅ Mocking com Mockito
* ✅ Relatórios automatizados via JaCoCo

### Executar testes

```bash
./mvnw clean test
```

### Gerar relatório

```bash
target/site/jacoco/index.html
```

---

## 📂 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   └── strategy
│   └── resources
└── test
```

---

## 👨‍💻 Autor

**Aldir Neto**

Segue com o link do vídeo para a avaliação *https://drive.google.com/file/d/1VQI3Gh-9u8fxYhBbkCQV4qZ1qvpPPFFE/view?usp=drive_link*
