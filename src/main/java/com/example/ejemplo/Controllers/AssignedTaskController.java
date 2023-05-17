package com.example.ejemplo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.Managers.TaskManager;
import com.example.ejemplo.Repositories.AssignedTaskRepository;
import com.example.ejemplo.Repositories.UnAssignedTaskRepository;
import com.example.ejemplo.models.AssignedTask;
import com.example.ejemplo.models.UnAssignedTask;
import com.example.ejemplo.models.User;

@RestController
@RequestMapping("api/AssignedTasks")
@CrossOrigin()
public class AssignedTaskController {
    @Autowired
    private AssignedTaskRepository assignedTaskRepository;
    @Autowired
    private UnAssignedTaskRepository unAssignedTaskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AssignedTask> getTasks() {
        return this.assignedTaskRepository.findAll();
    }

    @PostMapping("/")
    public AssignedTask assignTask(@RequestBody UnAssignedTask task, @RequestBody User user) {
        unAssignedTaskRepository.delete(task);
        return assignedTaskRepository.save(TaskManager.getInstance().assignTask(task, user));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public AssignedTask getAssignedTaskByID(@RequestParam int id) {
        return assignedTaskRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/")
    public AssignedTask reAssignTask(@RequestBody AssignedTask task, @RequestBody User user) {
        AssignedTask taskOutDated = assignedTaskRepository.findById(task.getId()).orElseThrow(null);
        taskOutDated.setAssignedUser(user);
        AssignedTask updateTask = assignedTaskRepository.save(taskOutDated);
        return updateTask;
    }

}
