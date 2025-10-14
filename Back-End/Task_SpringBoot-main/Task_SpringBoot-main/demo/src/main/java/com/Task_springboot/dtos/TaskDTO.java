package com.Task_springboot.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;

public class TaskDTO {


    Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataAgendamento;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private String status;

    @NotNull
    @Email
    private String emailUsuario;




}
