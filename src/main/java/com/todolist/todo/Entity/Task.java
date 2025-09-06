package com.todolist.todo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String description;

    @Column(name = "is_compete")
    Boolean isComplete;

    @Column(name = "due_date")
    LocalDate dueDate;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    User user;

    public Task(String title, String description, Boolean isComplete, LocalDate dueDate, User user) {
        this.title = title;
        this.description = description;
        this.isComplete = isComplete;
        this.dueDate = dueDate;
        this.user = user;
    }


}
