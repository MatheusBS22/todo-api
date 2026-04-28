package com.mbsousa.ToDoApi.service;
import com.mbsousa.ToDoApi.dto.TaskListResponseDto;
import com.mbsousa.ToDoApi.dto.TaskRequestDto;
import com.mbsousa.ToDoApi.dto.TaskResponseDto;
import com.mbsousa.ToDoApi.entity.Task;
import com.mbsousa.ToDoApi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.mbsousa.ToDoApi.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto create(TaskRequestDto dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());

        Task saved = taskRepository.save(task);
        return toResponse(saved);
    };


    public TaskResponseDto update(long id, TaskRequestDto dto){
        Task existingTask = taskRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Task Não encontrada"));

        existingTask.setTitle(dto.getTitle());
        existingTask.setDescription(dto.getDescription());
        existingTask.setStatus(dto.getStatus());

        Task Updated = taskRepository.save(existingTask);
        return toResponse(Updated);
    };

    public void delete(long id){
        if(!taskRepository.existsById(id)) {
                throw new ResourceNotFoundException("Task Não encontrada");
        }
        taskRepository.deleteById(id);

    };

    public TaskListResponseDto listAll() {
        List<TaskResponseDto> tasks = taskRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

        return new TaskListResponseDto(tasks);
    }

    public TaskResponseDto findById(Long id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada nenhuma tarefa com ID "+ id));

        return(toResponse(task));
    }

    public TaskResponseDto complete(Long id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada nenhuma tarefa com ID "+ id));

        task.setStatus(true);

        Task taskUpdated = taskRepository.save(task);
        return toResponse(taskUpdated);
    }

    private TaskResponseDto toResponse(Task task) {
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());

        return dto;
    };
}
