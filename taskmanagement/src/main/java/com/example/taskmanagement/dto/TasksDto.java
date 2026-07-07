package com.example.taskmanagement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.taskmanagement.model.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDto {

    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;
 
}
