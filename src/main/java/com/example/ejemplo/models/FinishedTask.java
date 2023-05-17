package com.example.ejemplo.models;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class FinishedTask extends AssignedTask {
    private Date finishedDate;

    public FinishedTask(int id, int priority, String descriptioString, String reporterEmail, Date reportDate,
            Date assignedDate, User assignedUser, Date finishedDate) {
        super(id, priority, descriptioString, reporterEmail, reportDate, assignedDate, assignedUser);
        this.finishedDate = finishedDate;
    }

    public FinishedTask(AssignedTask task, Date finishedDate) {
        super(task.getId(), task.getPriority(), task.getDescriptioString(), task.getReporterEmail(),
                task.getReportDate(),
                task.getAssignedDate(), task.getAssignedUser());
        this.finishedDate = finishedDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }
}
