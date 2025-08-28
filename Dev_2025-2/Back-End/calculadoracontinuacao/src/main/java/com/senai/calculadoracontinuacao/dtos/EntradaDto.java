package com.senai.calculadoracontinuacao.dtos;
//Isso é um JavaBin, sempre que fizer um DTO é essa estrutura que deve ser feita
public class EntradaDto {


    //atributos referentes a classe
    private Double n1;
    private Double n2;



    //construtor da classe
    public EntradaDto() {
        setN1(0d);// também da para fazer this.n1 = 0d; mas é melhor fazer via set
        setN2(0d);
    }

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
}
