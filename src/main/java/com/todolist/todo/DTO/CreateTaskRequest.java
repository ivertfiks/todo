package com.todolist.todo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {

    private final String title;
    private final String description;
    private final Boolean isComplete;
    private final LocalDate dueDate;
    private final Integer userId;

}
