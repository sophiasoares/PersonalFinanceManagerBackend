package com.project.personalfinancemanager.model;

import java.util.Date;

public class Income {

    private int incomeId;
    private int userId;
    private Source source;
    private double amount;
    private String description;
    private Date date;

    public Income() {}

    public Income(int userId, Source source, double amount, String description, Date date) {
        this.userId = userId;
        this.source = source;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
