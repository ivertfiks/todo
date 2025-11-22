package com.todolist.todo.Service;

import com.todolist.todo.Repository.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialService {

    private final CredentialRepository CredentialRepository;


}
