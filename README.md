# MyGamerBoxd API

API REST desenvolvida em Java com Spring Boot para o gerenciamento de catálogos e avaliações de jogos. O sistema atua como o motor back-end da plataforma, expondo endpoints para cadastro de usuários, jogos e processamento de notas.

## 🛠️ Tecnologias Utilizadas
* **Java** * **Spring Boot**
* **Swagger (OpenAPI)** para documentação e testes
* **Maven** para gerenciamento de dependências

## 🧠 Arquitetura e Conceitos Aplicados

O projeto foi projetado sob o modelo **Cliente-Servidor**, atuando em conjunto com os princípios de Programação Orientada a Objetos (POO) e boas práticas de software:

* **Arquitetura Cliente-Servidor (Objetivo Principal):** A API atua como o **Servidor** centralizado, responsável pelo processamento de requisições, validação de regras de negócio e gestão de dados. Isso garante o desacoplamento total, permitindo que múltiplos **Clientes** (como a futura interface em HTML/JS) consumam os recursos via requisições HTTP (REST) de forma independente.
* **Herança e Classes Abstratas:** Centralização da lógica de usuários através da classe mãe abstrata `Usuario`, estendida pelas classes filhas `Jogador` e `Admin`. Isso garante a separação de privilégios e elimina a repetição de código.
* **Polimorfismo e Interfaces:** Implementação da interface `CalculadoraScore` para o processamento de avaliações. O sistema utiliza Injeção de Dependência do Spring Boot para definir em tempo de execução o tipo de cálculo (Aritmético ou Ponderado), garantindo flexibilidade e manutenção limpa.
* **Tratamento de Exceptions:** Interceptação estruturada de falhas (como buscas por IDs inexistentes), garantindo retornos HTTP padronizados e previsíveis (ex: `404 Not Found`), protegendo a integridade da comunicação entre cliente e servidor.
