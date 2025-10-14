package com.senai.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Double preco;

    @ManyToOne
    private CategoriaModel categoria;

    public ProdutoModel() {
    }

    public ProdutoModel(Long id, String nome, CategoriaModel categoria, Double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "categoria=" + categoria +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
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
}
