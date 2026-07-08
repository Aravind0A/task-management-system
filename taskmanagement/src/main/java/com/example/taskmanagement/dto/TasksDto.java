package com.example.taskmanagement.dto;

import java.time.LocalDate;
import com.example.taskmanagement.model.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDto {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    @Future(message = "Due date must be a future date")
    private LocalDate dueDate;
    @NotNull
    private Status status;
 
}
