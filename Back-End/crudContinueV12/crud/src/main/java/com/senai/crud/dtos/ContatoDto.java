package com.senai.crud.dtos;


import java.util.Date;

public class ContatoDto {


    private long id;

    private String nome;


    private  double telefone;


    private Date data;


    private String email;


    private String cidade;


    public ContatoDto() {
    }

    public ContatoDto(long id, String nome, double telefone, Date data, String email, String cidade) {
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

    public double getTelefone() {
        return telefone;
    }

    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
