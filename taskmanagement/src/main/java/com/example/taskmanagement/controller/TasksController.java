package com.example.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagement.dto.TasksDto;
import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.service.TasksService;

import jakarta.validation.Valid;

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
    public ResponseEntity<Tasks> saveTasks(@Valid @RequestBody TasksDto tasksDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tasksService.saveTasks(tasksDto));
        
    }

    @GetMapping("/{id}")
    public Tasks getTasksById(@PathVariable Long id){
        return tasksService.getTasksById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable Long id, @RequestBody TasksDto tasksDto){
        return ResponseEntity.status(HttpStatus.OK).body(tasksService.updateTasks(id, tasksDto));
    }

    @PatchMapping("/{id}/status/complete")
    public ResponseEntity<Tasks> updateStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tasksService.updateStatus(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTasks(@PathVariable Long id){
        tasksService.deleteTasks(id);
        return ResponseEntity.noContent().build();
    }

}
