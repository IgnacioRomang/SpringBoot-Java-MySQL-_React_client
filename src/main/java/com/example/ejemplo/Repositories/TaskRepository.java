package com.example.ejemplo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplo.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
