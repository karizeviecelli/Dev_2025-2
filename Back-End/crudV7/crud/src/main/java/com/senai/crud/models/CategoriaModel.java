package com.senai.crud.models;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public CategoriaModel() {
    }

    public CategoriaModel(String descricao, Long id) {
        this.descricao = descricao;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CategoriaModel{" +
                "descricao='" + descricao + '\'' +
                ", id=" + id +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
