package com.senai.UsuarioCRUD_Marlos.Dtos;

public class RespostaDto {

    private String nome;
    private String senha;
    private String login;
    private  String msg;

    public RespostaDto() {
    }

    public RespostaDto(String nome, String senha, String msg) {
        this.nome = nome;
        this.senha = senha;
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
