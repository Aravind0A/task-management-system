package com.example.taskmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Tasks updateStatus(Long id){
        Tasks exist = tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id) );
        if(exist != null){
            exist.setStatus(Status.COMPLETED);
            exist.setUpdatedAt(LocalDateTime.now());
            tasksRepository.save(exist);
            return exist;
        } else{
            throw new TasksNotFoundException("Task not found with id: " + id);
        }
    }

    public ResponseEntity<?> deleteTasks(Long id){
        Tasks exist = tasksRepository.findById(id)
            .orElseThrow(() -> 
                new TasksNotFoundException("Task not found with id: " + id));
        if(exist == null){
            throw new TasksNotFoundException("Task not found with id: " + id);
        } else{
            tasksRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    
}
