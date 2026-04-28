package com.mbsousa.ToDoApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Retorna o Dto das Tarefas")
public class TaskResponseDto {
    @Schema(example = "4")
    private Long id;

    @Schema(example = "Estudar uma nova lingua")
    private String title;

    @Schema(example = "Estudar Russo por 2H")
    private String description;

    @Schema(example = "False")
    private Boolean status;

    @Schema(example = "False")
    private LocalDateTime createdAt;

    @Schema(example = "False")
    private LocalDateTime updatedAt;

}
