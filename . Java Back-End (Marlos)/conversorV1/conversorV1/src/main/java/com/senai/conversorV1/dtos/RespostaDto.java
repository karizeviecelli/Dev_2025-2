package com.senai.conversorV1.dtos;

public class RespostaDto {

    private double valorOriginal;
    private String tipoConversao;
    private double valorConvertido;
    private String erro;

    public RespostaDto() {
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getTipoConversao() {
        return tipoConversao;
    }

    public void setTipoConversao(String tipoConversao) {
        this.tipoConversao = tipoConversao;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
