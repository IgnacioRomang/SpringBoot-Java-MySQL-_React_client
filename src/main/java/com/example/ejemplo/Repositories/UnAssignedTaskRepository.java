package com.example.ejemplo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplo.models.UnAssignedTask;

@Repository
public interface UnAssignedTaskRepository extends JpaRepository<UnAssignedTask, Integer> {

}
