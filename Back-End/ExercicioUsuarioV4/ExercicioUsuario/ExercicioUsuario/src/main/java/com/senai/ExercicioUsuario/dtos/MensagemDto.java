package com.senai.ExercicioUsuario.dtos;

public class MensagemDto {
    private String mensagemUsuario;

    public MensagemDto(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }

    public MensagemDto() {
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public void setMensagemUsuario(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }




}
