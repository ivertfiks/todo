package com.todolist.todo.Controller;

import com.todolist.todo.DTO.CreateTaskRequest;
import com.todolist.todo.DTO.CreateTaskResponse;
import com.todolist.todo.DTO.TaskResponse;
import com.todolist.todo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

//    @GetMapping
//    public String getTasksByPriority(@RequestParam String priority,
//                                     @RequestParam LocalDate dueDate) {
//        return taskService
//    }

    @PostMapping
    public ResponseEntity<CreateTaskResponse> createTask(@RequestBody CreateTaskRequest taskRequest) {
        System.out.println(taskRequest.getTitle() + " " + taskRequest.getDescription());
        return new ResponseEntity<>(taskService.createTask(taskRequest), HttpStatus.CREATED);
    }

}
