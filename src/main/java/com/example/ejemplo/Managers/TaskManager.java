package com.example.ejemplo.Managers;

import java.sql.Date;
import java.util.List;

import com.example.ejemplo.models.AssignedTask;
import com.example.ejemplo.models.FinishedTask;
import com.example.ejemplo.models.UnAssignedTask;
import com.example.ejemplo.models.User;

public class TaskManager {
    private static TaskManager instance;
    private static List<UnAssignedTask> unAssignedTasks;

    private TaskManager() {
        super();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return TaskManager.getInstance();
    }

    public UnAssignedTask createTask(int priority, String descriptioString, String reporterEmail, Date reportDate,
            Date due_date) {
        UnAssignedTask nAssignedTask = null;
        nAssignedTask = new UnAssignedTask(priority, descriptioString, reporterEmail, reportDate, due_date);
        return nAssignedTask;
    }

    public AssignedTask assignTask(UnAssignedTask task, User user) {
        AssignedTask nAssignedTask = null;
        if (user.getAssignedTasks().size() < 5) {
            java.util.Date assignedDate = new java.util.Date();
            nAssignedTask = new AssignedTask(task, new Date(assignedDate.getTime()), user);
        }
        return nAssignedTask;
    }

    public FinishedTask finishTask(AssignedTask task) {
        FinishedTask nFinishedTask = null;
        java.util.Date finishDate = new java.util.Date();
        nFinishedTask = new FinishedTask(task, new Date(finishDate.getTime()));
        return nFinishedTask;
    }
}