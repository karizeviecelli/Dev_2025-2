package com.senai.cofrinho.demo;

// src/cofrinho/Real.java

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Real: " + valor;
    }

    @Override
    public double converter() {
        return valor; // Já está em Real
    }
}
