package com.example.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.service.TasksService;

@RestController
public class TasksController {

    @Autowired
    private TasksService tasksService;

    public Tasks saveTasks(){
        return tasksService.saveTasks(null);
    }

}
