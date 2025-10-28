package com.senai.crud.dtos;


import java.time.LocalDate;

public class ContatoDto {


    private long id;

    private String nome;


    private  String telefone;


    private LocalDate data;


    private String email;


    private String cidade;


    public ContatoDto() {
    }

    public ContatoDto(long id, String nome,String telefone, LocalDate  data, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.email = email;
        this.cidade = cidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
