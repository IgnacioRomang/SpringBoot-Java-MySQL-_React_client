package com.example.ejemplo.models;

import java.sql.Date;

public class UnAssignedTask extends Task {
    private Date due_date;

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
