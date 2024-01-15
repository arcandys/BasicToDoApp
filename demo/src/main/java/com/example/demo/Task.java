package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private String prio;

    protected Task() {

    }

    public Task(String title, String description, String status, String priority,  LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.prio = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Task[id=%d, title='%s', description='%s', status='%s', for dueDate='%s']",
                id, title, description, status, dueDate);
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getPrio(){
        return prio;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPrio(String prio){
        this.prio = prio;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }


}
