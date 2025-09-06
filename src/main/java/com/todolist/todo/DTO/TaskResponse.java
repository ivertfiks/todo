package com.todolist.todo.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskResponse {

    private final Integer id;
    private final String title;
    private final String description;
    private final Boolean isComplete;
    private final LocalDate dueDate;
    private final LocalDateTime createdAt;

}
