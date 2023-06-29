package com.example.ejemplo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplo.models.FinishedTask;

@Repository
public interface FinishedTaskRepository extends JpaRepository<FinishedTask, Integer>{
    
}
