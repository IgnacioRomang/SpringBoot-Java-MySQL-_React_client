package com.example.ejemplo.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private List<AssignedTask> assignedTasks;

    public List<AssignedTask> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<AssignedTask> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    private List<FinishedTask> finishedTasks;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }    
    public User(int id, String name, String email,List<FinishedTask> finishedTasks,List<AssignedTask> assignedTasks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.assignedTasks = assignedTasks;
        this.finishedTasks = finishedTasks;
    }

    public List<FinishedTask> getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(List<FinishedTask> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }
    public void addNewAssignedTask(AssignedTask task){
        if(this.assignedTasks == null){
            this.assignedTasks = new ArrayList<AssignedTask>();
        }
        this.assignedTasks.add(task);
    }
    public void addNewFinishedTask(FinishedTask task){
        if(this.finishedTasks == null){
            this.finishedTasks = new ArrayList<FinishedTask>();
        }
        this.finishedTasks.add(task);
    }
    public boolean removeAssigenedTask(AssignedTask task){
        boolean result = false;
        if(this.assignedTasks !=null){
            result = this.assignedTasks.remove(task);
        }
        return result;
    }
    public boolean removeFinishedTask(FinishedTask task){
        boolean result = false;
        if(this.finishedTasks !=null){
            result = this.finishedTasks.remove(task);
        }
        return result;
    }
}