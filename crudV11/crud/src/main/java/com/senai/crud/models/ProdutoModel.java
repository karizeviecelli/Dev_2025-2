package com.senai.crud.models;

import jakarta.persistence.*;
import com.senai.crud.dtos.*;

@Entity
@Table(name="PRODUTO")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="preco")
    private double preco;

    @Column(name="quantidade")
    private double quantidade;

    @ManyToOne
    private CategoriaModel categoria;

    public ProdutoModel() {
    }

    public ProdutoModel(ProdutoDto dto, CategoriaModel categoria) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.preco = dto.getPreco();
        this.quantidade = dto.getQuantidade();
        this.categoria = categoria;
    }

    public ProdutoModel(Long id, String nome, String descricao, double preco, double quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //--Método usado para converter DTO em Model
    public void convert(ProdutoDto dto){
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.preco = dto.getPreco();
        this.quantidade = dto.getQuantidade();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
