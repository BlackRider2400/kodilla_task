package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {
    @InjectMocks
    private TaskController taskController;

    @Mock
    private DbService dbService;

    @Mock
    private TaskMapper taskMapper;

    @Test
    void getTasks() {
        //Given
        when(dbService.getAllTasks()).thenReturn(new ArrayList<Task>());

        //When
        List<TaskDto> taskDtos = taskController.getTasks();

        //Then
        assertTrue(taskDtos.isEmpty());
    }

    @Test
    void getTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "test", "testing");
        Optional<Task> taskOptional = Optional.of(task);
        TaskDto mappedTaskDto = new TaskDto(1L, "test", "testing");
        Task mappedTask = new Task(1L, "test", "testing");

        when(dbService.getTask(1L)).thenReturn(taskOptional);
        when(taskMapper.mapToTaskDto(task)).thenReturn(mappedTaskDto);

        //When
        TaskDto taskDto = taskController.getTask(1L);

        //Then
        assertEquals(taskDto.getTitle(), task.getTitle());
    }

    @Test
    void updateTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test", "testing");
        TaskDto mappedTaskDto = new TaskDto(1L, "test", "testing");
        Task task = new Task(1L, "test", "testing");
        Task mappedTask = new Task(1L, "test", "testing");

        when(dbService.saveTask(mappedTask)).thenReturn(task);
        when(taskMapper.mapToTask(taskDto)).thenReturn(mappedTask);
        when(taskMapper.mapToTaskDto(task)).thenReturn(mappedTaskDto);
        //When
        TaskDto testTaskDto = taskController.updateTask(taskDto);

        //Then
        assertEquals(testTaskDto.getTitle(), taskDto.getTitle());
    }
}