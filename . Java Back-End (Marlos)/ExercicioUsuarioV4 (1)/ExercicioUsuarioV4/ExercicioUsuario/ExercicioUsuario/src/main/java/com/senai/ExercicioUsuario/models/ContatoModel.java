package com.senai.ExercicioUsuario.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Contato")
public class ContatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    @Column
    private String nome;

    @Column
    private String telefone;

    @Column
    private LocalDate dataNasc;

    @Column
    private String email;

    @ManyToOne
    private CidadeModel cidade;

    public ContatoModel() {
    }

    public ContatoModel(Long id, String nome, String telefone, LocalDate dataNasc, String email, CidadeModel cidade) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cidade = cidade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public CidadeModel getCidade() {
        return cidade;
    }

    public void setCidade(CidadeModel cidade) {
        this.cidade = cidade;
    }
}
