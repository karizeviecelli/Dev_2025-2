package com.senai.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Date schedulingDate;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private UserModel user;

    public TaskModel() {
    }

    public TaskModel(Long id, String title, String description, Date schedulingDate, Status status, UserModel user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.schedulingDate = schedulingDate;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(Date schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
