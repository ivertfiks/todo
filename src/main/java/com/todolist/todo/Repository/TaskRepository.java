package com.todolist.todo.Repository;

import com.todolist.todo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findTaskById(Integer id);
//    @Query("select * from Tasks")
}
