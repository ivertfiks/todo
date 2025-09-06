package com.todolist.todo.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class GenericError {

    private final LocalDateTime localDateTime;
    private final String path;
    private final Map<String, String> errors;

}
