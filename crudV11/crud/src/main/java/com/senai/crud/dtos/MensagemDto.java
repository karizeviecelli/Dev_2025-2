package com.senai.crud.dtos;

public class MensagemDto {

    private boolean sucesso;
    private String mensagem;

    public MensagemDto() {
        this.sucesso = true;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
