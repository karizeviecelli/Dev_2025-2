package com.senai.ExercicioUsuario.dtos;

public class CategoriaRequisicaoDto {
    private String nome;

    public CategoriaRequisicaoDto() {
    }

    public CategoriaRequisicaoDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
