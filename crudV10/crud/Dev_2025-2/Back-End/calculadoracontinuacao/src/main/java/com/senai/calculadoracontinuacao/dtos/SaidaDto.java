package com.senai.calculadoracontinuacao.dtos;

public class SaidaDto {

    //DTO É um reflexo do que você identifica como oque tem que entrar e sair
    private Double resultado;
    private Double n1;
    private Double n2;

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public SaidaDto() {
        setResultado(0d);
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
