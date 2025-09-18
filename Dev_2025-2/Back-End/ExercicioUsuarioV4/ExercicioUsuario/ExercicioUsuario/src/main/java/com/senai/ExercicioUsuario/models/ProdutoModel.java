package com.senai.ExercicioUsuario.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class ProdutoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    //Passando um objeto dentro de um objeto, assim pegando o ID DA CATEGORIA
    @ManyToOne //um para muitos
    private CategoriaModel categoria;

    @Column (name = "Produto")
    private String nome;

    @Column (name = "Preco")
    private Double preco;


    public ProdutoModel() {
    }


    public ProdutoModel(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;

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




    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco + '\'' ;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
