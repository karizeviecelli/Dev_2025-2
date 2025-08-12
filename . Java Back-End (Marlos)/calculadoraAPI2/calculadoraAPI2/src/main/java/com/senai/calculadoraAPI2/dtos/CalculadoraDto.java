package com.senai.calculadoraAPI2.dtos;

public class CalculadoraDto {
    private Double num1;
    private Double num2;
    private Double resultado;

    public CalculadoraDto() {
    }

    public void setResultado(Double resultado){
        this.resultado=resultado;
    }

    public Double getResultado(){
        return resultado;
    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }


}
