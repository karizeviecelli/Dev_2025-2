package com.senai.conversorV1.dtos;

public class RequisicaoDto {

    private double valor;
    private String tipoConversao;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversão) {
        this.tipoConversao = tipoConversão;
    }

    public RequisicaoDto() {
    }
}
