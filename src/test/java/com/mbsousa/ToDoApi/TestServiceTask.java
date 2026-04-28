package com.mbsousa.ToDoApi;

import com.mbsousa.ToDoApi.dto.TaskRequestDto;
import com.mbsousa.ToDoApi.dto.TaskResponseDto;
import com.mbsousa.ToDoApi.entity.Task;
import com.mbsousa.ToDoApi.exception.ResourceNotFoundException;
import com.mbsousa.ToDoApi.repository.TaskRepository;
import com.mbsousa.ToDoApi.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

	@Mock
	private TaskRepository taskRepository;

	@InjectMocks
	private TaskService taskService;

	private Task task;
	private TaskRequestDto requestDto;

	@BeforeEach
	void setUp() {
		task = new Task();
		task.setId(1L);
		task.setTitle("Estudar Spring");
		task.setDescription("Ver aula de testes");
		task.setStatus(false);

		requestDto = new TaskRequestDto();
		requestDto.setTitle("Estudar Spring");
		requestDto.setDescription("Ver aula de testes");
		requestDto.setStatus(false);
	}

	@Test
	void deveCriarTarefaComSucesso() {
		when(taskRepository.save(any(Task.class))).thenReturn(task);

		TaskResponseDto response = taskService.create(requestDto);

		assertNotNull(response);
		assertEquals("Estudar Spring", response.getTitle());
		verify(taskRepository, times(1)).save(any(Task.class));
	}

	@Test
	void deveListarTodasAsTarefas() {
		when(taskRepository.findAll()).thenReturn(List.of(task));

		var response = taskService.listAll();

		assertNotNull(response);
		assertEquals(1, response.getTotalCount());
	}

	@Test
	void deveBuscarTarefaPorIdComSucesso() {
		when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

		TaskResponseDto response = taskService.findById(1L);

		assertNotNull(response);
		assertEquals("Estudar Spring", response.getTitle());
	}

	@Test
	void deveLancarExcecaoQuandoTarefaNaoEncontrada() {
		when(taskRepository.findById(99L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> taskService.findById(99L));
	}

	@Test
	void deveMarcarTarefaComoConcluida() {
		when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
		when(taskRepository.save(any(Task.class))).thenReturn(task);

		TaskResponseDto response = taskService.complete(1L);

		assertNotNull(response);
		verify(taskRepository, times(1)).save(any(Task.class));
	}

	@Test
	void deveDeletarTarefaComSucesso() {
		when(taskRepository.existsById(1L)).thenReturn(true);
		doNothing().when(taskRepository).deleteById(1L);

		assertDoesNotThrow(() -> taskService.delete(1L));
		verify(taskRepository, times(1)).deleteById(1L);
	}
}