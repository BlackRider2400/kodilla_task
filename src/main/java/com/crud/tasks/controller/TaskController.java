package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping(value = "getTasks")
    public List<TaskDto> getTasks(){
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask")
    public TaskDto getTask(Long taskId){
        Task task = service.getTaskById(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask(Long taskId){

    }

    @PostMapping(value = "updateTask")
    public TaskDto updateTask(TaskDto task){
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @PutMapping(value = "createMapping")
    public void createTask(TaskDto task){

    }

}
