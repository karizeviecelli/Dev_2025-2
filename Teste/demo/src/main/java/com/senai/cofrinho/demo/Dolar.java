package com.senai.cofrinho.demo;


public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Dólar: " + valor;
    }

    @Override
    public double converter() {
        return valor * 5.20; // Exemplo de taxa de câmbio
    }
}

