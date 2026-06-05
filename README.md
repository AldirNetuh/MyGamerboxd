# 🎮 MyGamerBoxd API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de catálogos e avaliações de jogos. O sistema atua como o motor back-end da plataforma, seguindo a arquitetura **Cliente-Servidor (Stateless)** e expondo endpoints RESTful para operações de cadastro, consulta, atualização e remoção de jogos.
---
## 🚀 Tecnologias Utilizadas
* Java 17
* Spring Boot 3.2.x
* Spring Data JPA / Hibernate
* H2 Database (em memória)
* JUnit 5
* Mockito
* JaCoCo
* SpringDoc OpenAPI (Swagger)
* Maven
  
---
## 📋 Pré-requisitos
Antes de iniciar, certifique-se de possuir:
* Java 17 ou superior instalado
* Maven 3.8+ instalado
Ou utilize o Maven Wrapper incluído no projeto:
```bash
./mvnw
```

---
## ⚙️ Instalação
Clone o repositório e instale as dependências:
```bash
git clone https://github.com/SEU_USUARIO/mygamerboxd.git
cd mygamerboxd
./mvnw clean install
```
---

## ▶️ Executando a Aplicação

Para iniciar o servidor:

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

---

## 🔗 URLs Úteis

| Recurso    | URL                                   |
| ---------- | ------------------------------------- |
| API Base   | http://localhost:8080/api/v1          |
| Swagger UI | http://localhost:8080/swagger-ui.html |
| H2 Console | http://localhost:8080/h2-console      |

---

## 🎮 Endpoints Principais (Jogos)

| Método | Endpoint             | Descrição                        |
| ------ | -------------------- | -------------------------------- |
| GET    | `/api/v1/jogos`      | Lista todos os jogos cadastrados |
| GET    | `/api/v1/jogos/{id}` | Busca um jogo pelo ID            |
| POST   | `/api/v1/jogos`      | Cadastra um novo jogo            |
| PUT    | `/api/v1/jogos/{id}` | Atualiza um jogo existente       |
| DELETE | `/api/v1/jogos/{id}` | Remove um jogo do banco          |

### Códigos de Resposta

| Código | Significado                              |
| ------ | ---------------------------------------- |
| 200    | Operação realizada com sucesso           |
| 201    | Recurso criado                           |
| 204    | Recurso removido sem conteúdo de retorno |
| 404    | Recurso não encontrado                   |
| 400    | Dados inválidos na requisição            |

---

## 📦 Exemplo de Uso (cURL)

Criando um novo jogo:

```bash
curl -X POST http://localhost:8080/api/v1/jogos \
-H "Content-Type: application/json" \
-d '{
  "titulo": "The Witcher 3",
  "descricao": "RPG de mundo aberto"
}'
```

---

## 🧪 Testes e Cobertura

Para executar os testes unitários:

```bash
./mvnw clean test
```

O relatório de cobertura JaCoCo será gerado em:

```text
target/site/jacoco/index.html
```

---

## 📊 Nota de Engenharia

O esforço de testes foi concentrado estrategicamente na camada **Strategy**, responsável pelas regras de cálculo de notas e pelo comportamento polimórfico do sistema.

Classes de transporte (**DTOs**) e componentes predominantemente estruturais foram classificados como débito técnico planejado, justificando a diferença entre a cobertura global e a cobertura crítica de negócio.

---

## 📖 Documentação da API

Após iniciar a aplicação, a documentação interativa estará disponível através do Swagger:

```text
http://localhost:8080/swagger-ui.html
```

---
## 👤 Autor

* Aldir Neto
  
---

## 📄 Licença
Este projeto foi desenvolvido para fins acadêmicos e educacionais.
