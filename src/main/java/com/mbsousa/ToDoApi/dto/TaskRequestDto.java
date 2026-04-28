package com.mbsousa.ToDoApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO para criação de tarefas")
public class TaskRequestDto {

    @Schema(example = "Estudar Spring")
    @NotBlank(message = "É necessário que exista um título")
    private String title;

    @Schema(example = "Estudar por 3h")
    private String description;

    @Schema(example = "True")
    @NotNull(message = "É necessário que exista um status")
    private Boolean status;
}
