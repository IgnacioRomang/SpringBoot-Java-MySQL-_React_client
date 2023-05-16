package com.example.ejemplo.models;

import java.sql.Date;

public class FinishedTask extends AssignedTask {
    private Date finishedDate;

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }
}
