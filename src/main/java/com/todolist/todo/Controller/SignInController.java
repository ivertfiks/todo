package com.todolist.todo.Controller;

import com.todolist.todo.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignInController {

    private final UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<Void> loginUser() {
        return ResponseEntity.ok().build();
    }

}
