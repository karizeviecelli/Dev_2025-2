package com.senai.Conversor.Dtos;

public class RequisaoDto {

    private Double valor;
    private String tipoConversao;

    public RequisaoDto() {
        setValor(0d);
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
