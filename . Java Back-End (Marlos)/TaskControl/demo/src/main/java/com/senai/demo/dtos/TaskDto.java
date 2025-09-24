package com.senai.demo.dtos;

import com.senai.demo.entities.Status;
import com.senai.demo.entities.UserModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public class TaskDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Date schedulingDate;
    @NotBlank
    private Status status;
    @NotBlank
    private UserModel emailUser;
}
