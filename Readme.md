# ToDo API

API REST para gerenciamento de tarefas construída com Spring-Boot 4.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 4.0.4
- PostgreSQL
- Spring Data JPA / Hibernate
- Bean Validation
- Lombok
- SpringDoc OpenAPI (Swagger)

## 🚀 Como rodar localmente

### Pré-requisitos
- Java 21
- PostgreSQL rodando localmente

### Configuração

1. Clone o repositório
```bash
git clone https://github.com/mbsousa/ToDoApp_FirstProject.git
cd ToDoApp_FirstProject
```

2. Crie o banco de dados
```sql
CREATE DATABASE todoapp;
```

3. Configure as variáveis de ambiente
   DB_USERNAME=seu_usuario
   DB_PASSWORD=sua_senha

4. Rode a aplicação
```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## 📚 Documentação

Acesse o Swagger UI em:
http://localhost:8080/swagger-ui/index.html

## 📋 Endpoints

### Info
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /api/info | Informações da API |

### Tarefas
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /api/v1/task | Criar tarefa |
| GET | /api/v1/task | Listar todas as tarefas |
| GET | /api/v1/task/{id} | Buscar tarefa por ID |
| PUT | /api/v1/task/{id} | Atualizar tarefa |
| PATCH | /api/v1/task/{id}/complete | Marcar tarefa como concluída |
| DELETE | /api/v1/task/{id} | Deletar tarefa |

## 🧪 Testes

```bash
./mvnw test
```