package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @GetMapping(value = "getTasks")
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }

    @GetMapping(value = "getTask")
    public TaskDto getTask(Long taskId){
        return new TaskDto(1L, "test title", "test_content");
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
