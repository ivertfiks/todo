package com.todolist.todo.handler;

import com.todolist.todo.DTO.GenericError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericError> handleValidationExceptions(MethodArgumentNotValidException ex,
                                                                          HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        var errorDto = new GenericError(LocalDateTime.now(), request.getRequestURI(), errors);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericError> handleIllegalArguments(IllegalArgumentException ex,
                                                                HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        var errorDto = new GenericError(LocalDateTime.now(), request.getRequestURI(), errors);
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

}
