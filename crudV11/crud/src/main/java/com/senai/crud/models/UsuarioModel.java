package com.senai.crud.models;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="USUARIO")
@Data
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name="nome")
    private String nome;

    @Column(nullable = false, unique = true, name="login")
    private String login;

    @Column(name="senha")
    private String senha;

    public UsuarioModel() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
