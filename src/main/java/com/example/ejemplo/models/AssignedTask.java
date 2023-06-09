package com.example.ejemplo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="assignedtask")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AssignedTask extends Task {
    private Date assignedDate;

    @ManyToOne()
    @JoinColumn(name = "assignedUser")
    private User assignedUser;


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

    public Date getAssignedDate() {
        return assignedDate;
    }
    
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }


    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
