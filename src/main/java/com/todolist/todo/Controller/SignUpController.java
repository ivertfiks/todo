package com.todolist.todo.Controller;


import com.todolist.todo.DTO.CreateUserRequest;
import com.todolist.todo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody CreateUserRequest createUserRequest){
            userService.createUser(createUserRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
