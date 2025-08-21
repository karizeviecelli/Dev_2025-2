package com.senai.UsuarioCRUD_Marlos.Dtos;

public class RequisicaoDto {

    private String nome;
    private String login;
    private Double senha;

    public RequisicaoDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getSenha() {
        return senha;
    }

    public void setSenha(Double senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
