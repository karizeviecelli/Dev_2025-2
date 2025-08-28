package com.senai.ExercicioUsuario.models;

public class CategoriaModel {
    private Long id;
    private String nome;

    public CategoriaModel() {
    }

    public CategoriaModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return
                "id=" + id + '\'' +
                ", nome='" + nome;
    }
}
