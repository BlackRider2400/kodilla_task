package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskController taskController;

    @Test
    void getTasks() throws Exception {
        //Given
        List<TaskDto> taskDtos = new ArrayList<>(List.of(new TaskDto(1L, "test", "testing")));
        when(taskController.getTasks()).thenReturn(taskDtos);
        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/task/getTasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("test")));
    }

    @Test
    void getTask() throws TaskNotFoundException, Exception {
        //Given
        Long id = 1L;
        TaskDto taskDto = new TaskDto(1L, "test", "testing");
        when(taskController.getTask(id)).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/v1/task/getTask?taskId=" + id)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("test")));
    }

    @Test
    void updateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test", "testing");
        when(taskController.updateTask(taskDto)).thenReturn(taskDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                    .put("/v1/task/updateTask")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonContent)
                    .characterEncoding("UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}