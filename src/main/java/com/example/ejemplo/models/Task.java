package com.example.ejemplo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected int priority;

    public int getId() {
        return id;
    }

    public Task(int id, int priority, String descriptioString, String reporterEmail, Date reportDate) {
        this.id = id;
        this.priority = priority;
        this.descriptioString = descriptioString;
        this.reporterEmail = reporterEmail;
        this.reportDate = reportDate;
    }

    public Task(int priority, String descriptioString, String reporterEmail, Date reportDate) {
        this.priority = priority;
        this.descriptioString = descriptioString;
        this.reporterEmail = reporterEmail;
        this.reportDate = reportDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptioString() {
        return descriptioString;
    }

    public void setDescriptioString(String descriptioString) {
        this.descriptioString = descriptioString;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    protected String descriptioString;
    protected String reporterEmail;
    protected Date reportDate;
}
