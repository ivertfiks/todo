package com.todolist.todo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class TaskSpace {
    @Id
    int id;
    String name;
    @ManyToOne
    @JoinColumn(name = "user.id")
    User owner;
    @ManyToMany
    @JoinTable(name = "user_to_taskspace",
            joinColumns = @JoinColumn(name = "taskspace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    User user;
    String role;
    @OneToMany
    Task task;

}
