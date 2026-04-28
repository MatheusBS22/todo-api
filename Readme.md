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
git clone https://github.com/MatheusBS22/todo-api
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

### Criar tarefa
```json
POST /api/v1/task
{
  "title": "Estudar Spring Boot",
  "description": "Ver aula sobre testes unitários",
  "status": false
}
```

### Resposta de sucesso
```json
{
  "data": {
    "id": 1,
    "title": "Estudar Spring Boot",
    "description": "Ver aula sobre testes unitários",
    "status": false,
    "createdAt": "2026-04-27T19:41:08",
    "updatedAt": "2026-04-27T19:41:08"
  },
  "message": "Tarefa criada com sucesso",
  "error": null,
  "status": 201
}
```

### Atualizar tarefa
```json
PUT /api/v1/task/1
{
  "title": "Estudar Spring Boot",
  "description": "Ver aula sobre testes unitários",
  "status": true
}
```

### Resposta de erro — tarefa não encontrada
```json
{
  "data": null,
  "message": null,
  "error": "Task com ID 99 não encontrada",
  "status": 404
}
```

## 🧪 Testes

```bash
./mvnw test
```
