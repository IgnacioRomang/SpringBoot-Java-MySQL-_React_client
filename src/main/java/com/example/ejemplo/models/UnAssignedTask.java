package com.example.ejemplo.models;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class UnAssignedTask extends Task {
    private Date due_date;

    public UnAssignedTask(int id, int priority, String descriptioString, String reporterEmail, Date reportDate,
            Date due_date) {
        super(id, priority, descriptioString, reporterEmail, reportDate);
        this.due_date = due_date;
    }

    public UnAssignedTask(int priority, String descriptioString, String reporterEmail, Date reportDate,
            Date due_date) {
        super(priority, descriptioString, reporterEmail, reportDate);
        this.due_date = due_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
