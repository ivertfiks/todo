package com.todolist.todo.DTO;

import java.time.LocalDateTime;
import java.util.Map;

public record GenericError (

    LocalDateTime localDateTime,
    String path,
    Map<String, String> errors

) {}

// GenericError[localDateTime="10/10/2025", path="..."]

