package com.example.taskmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.taskmanagement.dto.TasksDto;
import com.example.taskmanagement.exception.TasksNotFoundException;
import com.example.taskmanagement.model.Status;
import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.repository.TasksRepository;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    // Converts the request DTO into a Task entity before saving
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

    //Save a new task
    public Tasks saveTasks(TasksDto tasksDto){
        return tasksRepository.save(convertToEntity(tasksDto));
    }

    public List<Tasks> getTasks() {
        return tasksRepository.findAll();
    }

    // Retrieve task or throw an exception if it does not exist
    public Tasks getTasksById(Long id){
        return tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id));
    }

    public Tasks updateTasks(Long id, TasksDto tasksDto){
        Tasks existingTasks = tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id));

            existingTasks.setTitle(tasksDto.getTitle());
            existingTasks.setDescription(tasksDto.getDescription());
            existingTasks.setDueDate(tasksDto.getDueDate());
            existingTasks.setStatus(tasksDto.getStatus());
            existingTasks.setUpdatedAt(LocalDateTime.now());
            tasksRepository.save(existingTasks);
            return existingTasks;
    }

    // Update only the task status to COMPLETED
    public Tasks updateStatus(Long id){
        Tasks exist = tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id) );
            exist.setStatus(Status.COMPLETED);
            exist.setUpdatedAt(LocalDateTime.now());
            tasksRepository.save(exist);
            return exist;
        } 

    public void deleteTasks(Long id){
        Tasks exist = tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id));
        
            tasksRepository.delete(exist);
        
    }

    
}
