package com.example.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanagement.model.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
