package com.example.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.dto.TasksDto;
import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.service.TasksService;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/all")
    public List<Tasks> getTasks(){
        return tasksService.getTasks();
    }

    @PostMapping("/save")
    public Tasks saveTasks(@RequestBody TasksDto tasksdDto) {
        return tasksService.saveTasks(tasksdDto);
    }

    @GetMapping("/{id}")
    public Tasks getTasksById(@PathVariable Long id){
        return tasksService.getTasksById(id);
    }

}
