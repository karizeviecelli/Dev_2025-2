package com.senai.ConversorGraus.dtos;

public class EntradaDto{

    private Double valor;
    private String tipoConversao;

    public EntradaDto() {

    }

    public EntradaDto(Double valor, String tipoConversao) {
        this.valor = valor;
        this.tipoConversao = tipoConversao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }
}
