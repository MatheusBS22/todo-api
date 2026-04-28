package com.mbsousa.ToDoApi.dto;

import lombok.Data;
import java.util.List;

@Data
public class TaskListResponseDto {
    private List<TaskResponseDto> tasks;
    private int TotalCount;


    public TaskListResponseDto(List<TaskResponseDto> tasks){
        this.tasks = tasks;
        this.TotalCount = tasks.size();
    }
}
