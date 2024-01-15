package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.Collections;
@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @Mock
    private Model model;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListTasks() {
        when(taskService.taskFinder()).thenReturn(Collections.emptyList());
        String view = taskController.getAllTasks(model);
        assertEquals("page2", view, "valid and expected'");
        verify(model).addAttribute(eq("tasks"), any());
    }

    @Test
    void testAddTask() {
        Task task = new Task();
        String result = taskController.addTask(task);
        assertEquals("redirect:/mainPage", result);
        Mockito.verify(taskService).taskSave(task);
    }

    @Test
    void testDelTask() {
        Task task = new Task();
        String result = taskController.deleteTask(task.getId());
        assertEquals("redirect:/tasks", result);
        Mockito.verify(taskService).taskDelete(task.getId());
    }

    @Test
    void testEditTask() {
        Task task = new Task();
        String result = taskController.editTask(task.getId(),model);
        assertEquals("taskEditForm", result);
        Mockito.verify(taskService).taskDelete(task.getId());
    }

    @Test
    public void testCreateTask() throws Exception {
        // Arrange
        String title = "Test Task";
        String description = "This is a test task.";
        String status = "Pending";
        String priority = "Medium";
        String dueDate = "2022-12-31";

        // Act
        ResultActions resultActions = mockMvc.perform(post("/addTask")
                .param("title", title)
                .param("description", description)
                .param("status", status)
                .param("priority", priority)
                .param("dueDate", dueDate));

        resultActions.andExpect(redirectedUrl("/mainPage"));
    }

}
