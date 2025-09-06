package com.todolist.todo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true)
    String username;

    String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Task> tasks;
}
