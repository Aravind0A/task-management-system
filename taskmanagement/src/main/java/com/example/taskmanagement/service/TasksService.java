package com.example.taskmanagement.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanagement.dto.TasksDto;
import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.repository.TasksRepository;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    private Tasks convertToEntity(TasksDto tasksDto) {
        Tasks tasks = new Tasks();
        tasks.setTitle(tasksDto.getTitle());
        tasks.setDescription(tasksDto.getDescription());
        tasks.setDueDate(tasksDto.getDueDate());
        tasks.setStatus(tasksDto.getStatus());
        tasks.setCreatedAt(LocalDateTime.now());
        tasks.setUpdatedAt(LocalDateTime.now());
        return tasks;
    }

    public Tasks saveTasks(TasksDto tasksDto){
        return tasksRepository.save(convertToEntity(tasksDto));
    }

    public List<Tasks> getTasks() {
        return tasksRepository.findAll();
    }

    public Tasks getTasksById(Long id){
        return tasksRepository.findById(id).orElse(null);
    }
    
}
