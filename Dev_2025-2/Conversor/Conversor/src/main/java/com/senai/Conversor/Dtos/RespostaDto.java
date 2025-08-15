package com.senai.Conversor.Dtos;

public class RespostaDto {

    private Double valor;
    private String tipoConversao;
    private Double valorConvertido;


    public RespostaDto() {
        setValor(0d);
        setValorConvertido(0d);
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
