package com.example.taskmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.taskmanagement.dto.TasksDto;
import com.example.taskmanagement.model.Status;
import com.example.taskmanagement.model.Tasks;
import com.example.taskmanagement.repository.TasksRepository;

@ExtendWith(MockitoExtension.class)
public class TasksServiceTest {

    @Mock
    private TasksRepository tasksRepository;
    @InjectMocks
    private TasksService tasksService;
    private Tasks task;
    private TasksDto taskDto;

    @BeforeEach
    void setUp() {

        LocalDate dueDate = LocalDate.now().plusDays(7);
        task = new Tasks();
        task.setId(1L);
        task.setTitle("Learn Spring Boot");
        task.setDescription("Practice CRUD");
        task.setDueDate(dueDate);
        task.setStatus(Status.PENDING);

        taskDto = new TasksDto();
        taskDto.setTitle("Learn Spring Boot");
        taskDto.setDescription("Practice CRUD");
        taskDto.setDueDate(dueDate);
        taskDto.setStatus(Status.PENDING);
    }

    @Test
    void shouldSaveTask() {

        when(tasksRepository.save(any(Tasks.class))).thenReturn(task);
        Tasks savedTask = tasksService.saveTasks(taskDto);
        assertNotNull(savedTask);
        assertEquals("Learn Spring Boot", savedTask.getTitle());
        assertEquals(Status.PENDING, savedTask.getStatus());    
    }

    @Test
    void shouldReturnTaskById() {

    when(tasksRepository.findById(1L))
            .thenReturn(Optional.of(task));

    Tasks result = tasksService.getTasksById(1L);

    assertEquals(1L, result.getId());
    assertEquals("Learn Spring Boot", result.getTitle());

    }

    @Test
    void shouldDeleteTask() {

        when(tasksRepository.findById(1L))
                .thenReturn(Optional.of(task));

        tasksService.deleteTasks(1L);
    }

}

