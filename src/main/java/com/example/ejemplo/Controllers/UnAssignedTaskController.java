package com.example.ejemplo.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.Repositories.UnAssignedTaskRepository;
import com.example.ejemplo.models.UnAssignedTask;

@RestController
@RequestMapping("api/Task")
@CrossOrigin()
public class UnAssignedTaskController {
    @Autowired
    private UnAssignedTaskRepository repository;

    @PostMapping("/")
    public Map<String, Boolean> createTask(@RequestBody UnAssignedTask task) {
        repository.save(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("saved", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/")
    public Map<String, Boolean> deleteTask(@RequestBody UnAssignedTask taskD) {
        UnAssignedTask task = repository.findById(taskD.getId()).orElseThrow();
        repository.delete(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
