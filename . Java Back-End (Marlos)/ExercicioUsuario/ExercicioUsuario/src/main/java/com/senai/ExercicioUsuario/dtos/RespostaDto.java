package com.senai.ExercicioUsuario.dtos;

public class RespostaDto {
    private String nome;
    private String mensagemUsuario;

    public RespostaDto() {
    }

    public RespostaDto(String nome, String mensagemUsuario) {
        this.nome = nome;
        this.mensagemUsuario = mensagemUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public void setMensagemUsuario(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }
}
