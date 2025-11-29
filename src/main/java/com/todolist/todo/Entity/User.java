package com.todolist.todo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    public User(String username, String email) {
        this.displayName = username;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToMany
    List<TaskSpace> taskSpaceList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "credential_id", referencedColumnName = "id", unique = true)
    private Credential credential;

    @Column
    String displayName;

    String email;

}
