package com.example.cadastromed.Models;

public class Medico extends Pessoa {
    private String especialidade;

    public Medico() {
    }

    public Medico(String nome, int idade, String cpf, String especialidade) {
        super(nome, idade, cpf);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
