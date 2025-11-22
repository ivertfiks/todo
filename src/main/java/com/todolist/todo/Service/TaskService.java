package com.todolist.todo.Service;

import com.todolist.todo.DTO.CreateTaskRequest;
import com.todolist.todo.DTO.CreateTaskResponse;
import com.todolist.todo.DTO.TaskResponse;
import com.todolist.todo.Entity.Task;
import com.todolist.todo.Entity.User;
import com.todolist.todo.Repository.TaskRepository;
import com.todolist.todo.Repository.UserRepository;
import com.todolist.todo.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    public CreateTaskResponse createTask(CreateTaskRequest taskRequest) {
        User user = userRepository.findById(taskRequest.getUserId()).orElseThrow(() -> new IllegalArgumentException("User is not exist"));
        Task newTask = new Task(
                taskRequest.getTitle(),
                taskRequest.getDescription(),
                taskRequest.getIsComplete(),
                taskRequest.getDueDate(),
                user
        );
        Task savedTask = taskRepository.save(newTask);
        return new CreateTaskResponse(savedTask.getId());
    }

    public TaskResponse getTaskById(Integer id) {
        Task tempTask = taskRepository.findTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task with given id not found: " + id));
        return taskMapper.toTaskResponse(tempTask);
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toTaskResponse)
                .toList();
    }

}
