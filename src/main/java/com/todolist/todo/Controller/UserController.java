package com.todolist.todo.Controller;

import com.todolist.todo.DTO.CreateUserRequest;
import com.todolist.todo.DTO.CreateUserResponse;
import com.todolist.todo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        //
        return new ResponseEntity<>(userService.createUser(createUserRequest), HttpStatus.CREATED);
    }
}
