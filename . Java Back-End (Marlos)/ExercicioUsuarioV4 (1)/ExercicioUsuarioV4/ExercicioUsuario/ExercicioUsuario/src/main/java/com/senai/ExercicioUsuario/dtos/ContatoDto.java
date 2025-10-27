package com.senai.ExercicioUsuario.dtos;

import java.time.LocalDate;

public class ContatoDto {

    private Long id;

    private String nome;

    private Integer telefone;

    private LocalDate dataNasc;

    private String email;

    private Long cidadeId;

    private String cidadeNome;

    public ContatoDto() {
    }


    public ContatoDto(Long id, String nome, Integer telefone, LocalDate dataNasc, String email, Long cidadeId, String cidadeNome) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cidadeId = cidadeId;
        this.cidadeNome = cidadeNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }
}
