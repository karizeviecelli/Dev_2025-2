package com.senai.demo.dtos;

import com.senai.demo.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;

public class TaskDto {

    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate schedulingDate;

    @NotNull
    private Status status;
    // ABERTO(1)
    // PENDENTE(2)
    // CONCLUIDO(3)
    // CANCELADO(4)

    @NotBlank
    private String emailUser;

    public TaskDto() {
    }

    public TaskDto(Long id, String title, String description, LocalDate schedulingDate, Status status, String emailUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.schedulingDate = schedulingDate;
        this.status = status;
        this.emailUser = emailUser;
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

    public LocalDate getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(LocalDate schedulingDate) {
        this.schedulingDate = schedulingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
