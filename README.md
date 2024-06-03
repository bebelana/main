# Projeto de Cálculo de Dígito Único

Este projeto implementa um serviço de cálculo de dígito único, incluindo um CRUD para usuários com dados criptografados usando RSA. Também possui um cache em memória para otimizar o cálculo do dígito único.

## Tecnologias Utilizadas

- Java 8+
- Spring Boot
- JPA com H2 Database
- Maven
- JUnit para testes unitários
- Swagger para documentação da API
- Postman para testes de integração

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte do projeto.
  - `model`: Modelos de dados (User e UniqueDigitCalculation).
  - `repository`: Repositórios JPA.
  - `service`: Serviços para lógica de negócio.
  - `controller`: Controladores REST.
  - `config`: Configurações adicionais, incluindo SwaggerConfig.
  - `util`: Utilitários, incluindo criptografia RSA.
- `src/test/java`: Contém os testes unitários.

## Funcionalidades

- **Cálculo de Dígito Único**: Calcula o dígito único de um número concatenado `c` vezes.
- **CRUD de Usuários**: Criação, leitura, atualização e exclusão de usuários.
- **Cache**: Armazena os últimos 10 cálculos realizados para otimizar a performance.
- **Criptografia RSA**: Criptografa nome e email dos usuários.
- **Documentação da API**: Disponível via Swagger.

## Executando o Projeto

### Pré-requisitos

- Java 8+
- Maven

### Passos para Execução

- mvn clean install
- mvn spring-boot:run

