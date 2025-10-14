package com.senai.crud.dtos;

import com.senai.crud.models.ProdutoModel;

public class ProdutoDto {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private Double quantidade;

    private Long categoriaid;

    public ProdutoDto() {}

    public ProdutoDto(Long id, String nome, String descricao, Double preco, Double quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public ProdutoDto(ProdutoModel produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.categoriaid = produto.getCategoria().getId();
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Long categoriaid) {
        this.categoriaid = categoriaid;
    }
}
