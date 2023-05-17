package com.example.ejemplo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplo.models.AssignedTask;

@Repository
public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Integer> {

}