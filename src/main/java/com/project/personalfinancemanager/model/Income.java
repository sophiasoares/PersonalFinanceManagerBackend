package com.project.personalfinancemanager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    private Source source;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Income() {}

    public Income(User user, Source source, double amount, String description, Date date) {
        this.user = user;
        this.source = source;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
