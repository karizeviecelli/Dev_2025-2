package com.senai.cofrinho.demo;

// src/cofrinho/Cofrinho.java

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
   public List<Moeda> listaMoedas;

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    // Adiciona uma moeda ao cofrinho
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // Remove uma moeda do cofrinho pelo índice
    public boolean removerPorIndice(int indice) {
        if (indice >= 0 && indice < listaMoedas.size()) {
            listaMoedas.remove(indice);
            return true;
        }
        return false;
    }

    // Lista todas as moedas no cofrinho
    public void listarMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            for (int i = 0; i < listaMoedas.size(); i++) {
                Moeda moeda = listaMoedas.get(i);
                System.out.println(i + " - " + moeda.info());
            }
        }
    }

    // Calcula o valor total das moedas no cofrinho em reais
    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.converter();
        }
        return total;
    }
}

