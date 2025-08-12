package com.example.cadastromed.Models;

public class Paciente extends Pessoa {
    private String sexo;

    public Paciente(String nome, int idade, String cpf, String sexo) {
        super(nome, idade, cpf);
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
