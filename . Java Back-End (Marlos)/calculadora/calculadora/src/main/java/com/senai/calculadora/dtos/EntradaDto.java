package com.senai.calculadora.dtos;

public class EntradaDto {
    //atributos da classe
    private double n1;
    private double n2;

    //--Construtor da classe
    public EntradaDto(){
        //faz a mesma função que o this
        setN1(0d);
        setN2(0d);
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
