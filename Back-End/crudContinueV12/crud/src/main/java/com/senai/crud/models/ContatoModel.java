package com.senai.crud.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contato")
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private  double telefone;

    @Column(name = "data")
    private Date data;

    @Column(name = "email")
    private String email;

    @Column(name = "cidade")
    private String cidade;

    public ContatoModel() {
    }

    public ContatoModel(String email, long id, String nome, double telefone, Date data, String cidade) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ContatoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", data=" + data +
                ", email='" + email + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
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
