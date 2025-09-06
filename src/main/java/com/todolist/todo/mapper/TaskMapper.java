package com.todolist.todo.mapper;

import com.todolist.todo.DTO.TaskResponse;
import com.todolist.todo.Entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

//    @Mapping(source = "created_at", target = "createdAt")
    TaskResponse toTaskResponse(Task task);

}
