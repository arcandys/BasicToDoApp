package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/mainPage")
    public String task(Model model) {
        List<Task> tasks = taskService.taskFinder();
        model.addAttribute("tasks", tasks);
        return "page2";
    }

    @GetMapping("/additionForm")
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/addTask")
    public String addTask(Task task) {
        taskService.taskSave(task);
        return "redirect:/mainPage";
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.taskFinder();
        model.addAttribute("tasks", tasks);
        return "page2";
    }

    @PostMapping("/taskDelete")
    public String deleteTask(@RequestParam Long id) {
        taskService.taskDelete(id);
        return "redirect:/tasks";
    }

    @PostMapping("/editTask")
    public String editTask(@RequestParam Long id, Model model) {
        Long var = id;
        Task task = taskService.taskFinderById(id).orElse(null);
        model.addAttribute("task", task);
        taskService.taskDelete(var);
        return "taskEditForm";
    }

    @PostMapping("/sendUpdate")
    public String updateTask(@Valid Task task) {
        taskService.taskSave(task);
        return "redirect:/tasks";
    }

    @GetMapping("/seeTaskDetails")
    public String seeTaskDetails(@RequestParam Long id, Model model) {
        Optional<Task> taskOptional = taskService.taskFinderById(id);
        Task task = taskOptional.get();
        model.addAttribute("task", task);
        return "taskDetails";
    }
}