package com.todolist.todo.Service;

import com.todolist.todo.DTO.CreateUserRequest;
import com.todolist.todo.DTO.CreateUserResponse;
import com.todolist.todo.Entity.User;
import com.todolist.todo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest){
        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getEmail()
        );
        userRepository.save(user);
        return new CreateUserResponse(user.getId());
    }

}
