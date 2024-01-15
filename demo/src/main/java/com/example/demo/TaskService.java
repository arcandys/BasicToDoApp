package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> taskFinder(){
        return taskRepository.findAll();
    }

    public Optional<Task> taskFinderById(Long id){
        return taskRepository.findById(id);
    }

    public void taskDelete(Long id){
         taskRepository.deleteById(id);
    }

    public void taskSave(Task task){
        taskRepository.save(task);
    }
}