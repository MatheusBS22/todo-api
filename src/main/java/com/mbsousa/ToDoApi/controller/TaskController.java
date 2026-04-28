package com.mbsousa.ToDoApi.controller;

import com.mbsousa.ToDoApi.dto.TaskListResponseDto;
import com.mbsousa.ToDoApi.dto.TaskRequestDto;
import com.mbsousa.ToDoApi.dto.TaskResponseDto;
import com.mbsousa.ToDoApi.response.StandardResponseApi;
import com.mbsousa.ToDoApi.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tasks", description = "Gerenciamento de tarefas")
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    private <T> ResponseEntity<StandardResponseApi<T>> success(T data, String message) {
        return ResponseEntity.ok(new StandardResponseApi<>(data, message, null, 200));
    }

    private <T> ResponseEntity<StandardResponseApi<T>> created(T data, String message) {
        return ResponseEntity
                .status(201)
                .body(new StandardResponseApi<>(data, message, null, 201));
    }

    @Operation(summary = "Criar tarefa")
    @PostMapping
    public ResponseEntity<StandardResponseApi<TaskResponseDto>> create(@RequestBody @Valid TaskRequestDto dto) {
        TaskResponseDto task = taskService.create(dto);
        return created(task, "Tarefa criada com sucesso");
    }

    @Operation(summary = "Atualiza uma tarefa pelo ID")
    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseApi<TaskResponseDto>> update(@PathVariable Long id, @RequestBody @Valid TaskRequestDto dto) {
        return success(taskService.update(id, dto), "Tarefa atualizada com sucesso");
    }

    @Operation(summary = "Atualiza parte de uma tarefa pelo ID")
    @PatchMapping("/{id}/complete")
    public ResponseEntity<StandardResponseApi<TaskResponseDto>> update(@PathVariable Long id) {
        return success(taskService.complete(id), "Tarefa completada");
    }

    @Operation(summary = "Deleta uma tarefa pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseApi<Void>> delete(@PathVariable Long id) {
        taskService.delete(id);
        return success(null, "Tarefa deletada com sucesso");
    }

    @Operation(summary = "Lista todas as tarefas")
    @GetMapping
    public ResponseEntity<StandardResponseApi<TaskListResponseDto>> list() {
        return success(taskService.listAll(), "Lista de tarefas retornada");
    }

    @Operation(summary = "Retorna ua tarefa pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseApi<TaskResponseDto>> FindById(@PathVariable Long id) {
        return success(taskService.findById(id), "Tarefa Retornada");
    }
}