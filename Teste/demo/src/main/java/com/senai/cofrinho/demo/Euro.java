package com.senai.cofrinho.demo;



public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return "Euro: " + valor;
    }

    @Override
    public double converter() {
        return valor * 6.10; // Exemplo de taxa de câmbio
    }
}
