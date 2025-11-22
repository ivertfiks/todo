package com.todolist.todo.Service;

import com.todolist.todo.Entity.Credential;
import com.todolist.todo.Repository.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final CredentialRepository credentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credential> credential = credentialRepository.findByUsername(username);
        return credential.orElseThrow(() -> new UsernameNotFoundException("User with " + username + " didn't find"));
    }
}
