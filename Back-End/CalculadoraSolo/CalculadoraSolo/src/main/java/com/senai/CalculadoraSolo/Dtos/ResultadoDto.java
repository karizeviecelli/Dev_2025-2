package com.senai.CalculadoraSolo.Dtos;

public class ResultadoDto {


    private Double numero1;
    private Double numero2;
    private Double resultado;
    private String operacao;

    public ResultadoDto() {
        setNumero1(0d);
        setNumero2(0d);
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
