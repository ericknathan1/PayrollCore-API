# 💰 PayrollCore API: Sistema de Gestão de Funcionários e Folha de Pagamento

## 📋 Sobre o Projeto

O **PayrollCore** é um sistema *backend* robusto, desenvolvido em **Spring Boot** e **Java**, projetado para gerenciar o cadastro de funcionários, a autenticação segura e o registro das folhas de pagamento mensais.

O projeto foca em segurança e controle de acesso, utilizando a arquitetura de **API RESTful** para expor os endpoints de gestão.

## ✨ Funcionalidades Principais

* **Autenticação Segura (JWT):** Login de funcionários e geração de tokens de acesso para garantir que apenas usuários válidos possam interagir com a API.
* **Controle de Acesso (RBAC):** Implementação de níveis de permissão (Gerente e Colaborador) para proteger rotas sensíveis.
    * **Gerentes** podem listar todos os funcionários e criar novas folhas de pagamento.
    * **Colaboradores** podem consultar suas próprias folhas de pagamento.
* **Gestão de Funcionários:** Endpoints para cadastro e alteração do status (ativo/inativo) dos colaboradores.
* **Folha de Pagamento:** Registro e consulta das informações salariais mensais de cada funcionário.
* **Documentação Interativa:** Utiliza **Swagger/OpenAPI** para documentar automaticamente todos os endpoints da API, facilitando testes e integrações.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x
* **Segurança:** Spring Security, JWT (JSON Web Token)
* **Persistência:** Spring Data JPA, MySQL
* **Mapeamento:** ModelMapper (para DTOs)

## 🚀 Como Executar Localmente

### Pré-requisitos
* Java 17 (ou superior)
* Maven
* Servidor MySQL configurado

### Configuração
1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/ericknathan1/PayrollCore-API.git
    ```
2.  **Configurar o Banco de Dados:**
    Atualize o arquivo `src/main/resources/application.properties` com as credenciais do seu banco de dados MySQL.
3.  **Executar:**
    Inicie a aplicação utilizando o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

### Endpoints
A API estará disponível em `http://localhost:8080` (porta padrão do Spring Boot).
A documentação interativa (Swagger UI) pode ser acessada em: `http://localhost:8080/swagger-ui.html`

---
Desenvolvido por: [ericknathan1]
