package com.todolist.todo.Service;

import com.todolist.todo.DTO.CreateUserRequest;
import com.todolist.todo.DTO.CreateUserResponse;
import com.todolist.todo.Entity.Credential;
import com.todolist.todo.Entity.User;
import com.todolist.todo.Repository.CredentialRepository;
import com.todolist.todo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public CreateUserResponse createUser(CreateUserRequest createUserRequest){

        if(!createUserRequest.getPassword().equals(createUserRequest.getRepeatedPassword()))
            throw new InputMismatchException("password don't match");

        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getEmail()
        );

        Optional<Credential> tempUser = credentialRepository.findByUsername(createUserRequest.getUsername());
        if(!tempUser.isEmpty()){
            throw new IllegalArgumentException();
        }

        credentialRepository.findByUsername(createUserRequest.getUsername())
                .ifPresent(cred -> {
                    throw new IllegalArgumentException("Username " + cred.getUsername() + " already exists");
                });
//                .orElseThrow(() -> new IllegalArgumentException());

        user = userRepository.save(user);

        String encodedPass = passwordEncoder.encode(createUserRequest.getPassword());

        Credential credential = new Credential(
                user,
                createUserRequest.getUsername(),
                encodedPass
        );
        credentialRepository.save(credential);
//        throw new RuntimeException("This breaks the code intentionally");
        return new CreateUserResponse(user.getId());
    }

}
