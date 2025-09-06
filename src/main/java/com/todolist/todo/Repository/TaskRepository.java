package com.todolist.todo.Repository;

import com.todolist.todo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findTaskById(Integer id);
//    @Query("select * from Tasks")
}
