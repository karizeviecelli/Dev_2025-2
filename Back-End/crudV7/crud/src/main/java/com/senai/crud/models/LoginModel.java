package com.senai.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @Column(name = "senha")
    private String senha;

    @Column(name = "login")
    private String login;

    public LoginModel() {
    }

    public LoginModel(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
