package com.todolist.todo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserRequest {

    // @NotNull
    // @NotEmpty
    // @NotBlank

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "username length must be at least 3 characters and max of 20 characters")
    private final String username;
    @Email
    private final String email;

}
