package com.senai.calculadora.dtos;

public class SaidaDto {
    //Atributo da classe
    private double resultado;
    private double n1;
    private double n2;

    //--Construtor da classe
    public SaidaDto() {
        setResultado(0d);
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }
}
