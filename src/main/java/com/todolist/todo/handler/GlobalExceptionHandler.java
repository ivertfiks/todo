package com.todolist.todo.handler;

import com.todolist.todo.DTO.GenericError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericError> handleConstraintViolation(ConstraintViolationException ex) {
        LocalDateTime localDateTime = LocalDateTime.now();

        // todo create and return ResponseEntity<GenericError>
    }

}
