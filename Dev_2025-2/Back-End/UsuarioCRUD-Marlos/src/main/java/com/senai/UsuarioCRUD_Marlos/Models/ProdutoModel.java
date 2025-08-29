package com.senai.UsuarioCRUD_Marlos.Models;

public class ProdutoModel {

    private Long id;
    private String nome;
    private Double preco;
    private Long cateogiraId;

    public ProdutoModel() {
    }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "cateogiraId=" + cateogiraId +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public ProdutoModel(Long cateogiraId, String nome, Long id, Double preco) {
        this.cateogiraId = cateogiraId;
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public Long getCateogiraId() {
        return cateogiraId;
    }

    public void setCateogiraId(Long cateogiraId) {
        this.cateogiraId = cateogiraId;
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
