package com.project.personalfinancemanager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(nullable = false)
    private double amount;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Expense() {}

    public Expense(User user, double amount, Category category, String description, Date date) {
        this.user = user;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
