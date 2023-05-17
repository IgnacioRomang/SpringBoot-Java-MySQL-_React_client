package com.example.ejemplo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignedTask extends Task {
    private Date assignedDate;

    public Date getAssignedDate() {
        return assignedDate;
    }


    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User assignedUser;

    public User getAssignedUser() {
        return assignedUser;
    }
    
    public AssignedTask(int id, int priority, String descriptioString, String reporterEmail, Date reportDate,
            Date assignedDate, User assignedUser) {
        super(id, priority, descriptioString, reporterEmail, reportDate);
        this.assignedDate = assignedDate;
        this.assignedUser = assignedUser;
    }


    public AssignedTask(UnAssignedTask task, Date assignedDate, User assignedUser) {
        super(task.getId(), task.getPriority(), task.getDescriptioString(), task.getReporterEmail(), task.getReportDate());
        this.assignedDate = assignedDate;
        this.assignedUser = assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
