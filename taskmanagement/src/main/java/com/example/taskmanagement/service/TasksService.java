package com.example.taskmanagement.service;

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
        tasks.setId(tasksDto.getId());
        tasks.setTitle(tasksDto.getTitle());
        tasks.setDescription(tasksDto.getDescription());
        tasks.setDueDate(tasksDto.getDueDate());
        tasks.setStatus(tasksDto.getStatus());
        tasks.setCreatedAt(tasksDto.getCreatedAt());
        tasks.setUpdatedAt(tasksDto.getUpdatedAt());
        return tasks;
    }

    public Tasks saveTasks(TasksDto tasksdDto){
        return tasksRepository.save(convertToEntity(tasksdDto));
    }

    
}
