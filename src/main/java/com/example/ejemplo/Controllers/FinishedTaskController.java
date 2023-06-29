package com.example.ejemplo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.Managers.TaskManager;
import com.example.ejemplo.Repositories.AssignedTaskRepository;
import com.example.ejemplo.Repositories.FinishedTaskRepository;
import com.example.ejemplo.models.AssignedTask;
import com.example.ejemplo.models.FinishedTask;

@RestController
@RequestMapping("api/FinishedTask")
@CrossOrigin()
public class FinishedTaskController {
    @Autowired
    private AssignedTaskRepository assignedTaskRepository;
    @Autowired
    private FinishedTaskRepository finishedTaskRepository;

    @PutMapping("/")
    public FinishedTask finishTask(@RequestBody AssignedTask task) {
        AssignedTask taskToFinish = assignedTaskRepository.findById(task.getId()).orElseThrow(null);
        FinishedTask taskFinish = TaskManager.getInstance().finishTask(taskToFinish);
        assignedTaskRepository.delete(taskToFinish);
        taskToFinish.getAssignedUser().getAssignedTasks().remove(taskToFinish);
        finishedTaskRepository.save(taskFinish);
        return taskFinish;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<FinishedTask> getFinishedTasks() {
        return this.finishedTaskRepository.findAll();
    }
}
