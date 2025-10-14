package com.senai.UsuarioCRUD_Marlos.Dtos;

public class ProdutoDto {

    private Long id;
    private String nome;
    private Double preco;
    private Long cateogiraId;

    public ProdutoDto() {
    }

    public ProdutoDto(Long cateogiraId, Long id, String nome, Double preco) {
        this.cateogiraId = cateogiraId;
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getCateogiraId() {
        return cateogiraId;
    }

    public void setCateogiraId(Long cateogiraId) {
        this.cateogiraId = cateogiraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
