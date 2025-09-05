package com.senai.ExercicioUsuario.models;

public class ProdutoModel {
    private Long id;
    private String nome;
    private Double preco;
    private Long categoriaId;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, Double preco, Long categoriaId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoriaId = categoriaId;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco + '\'' +
                ", categoriaId=" + categoriaId;
    }
}
