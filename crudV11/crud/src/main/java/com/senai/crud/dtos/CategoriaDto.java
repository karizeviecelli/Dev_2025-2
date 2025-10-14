package com.senai.crud.dtos;

import com.senai.crud.models.CategoriaModel;

public class CategoriaDto {

    private Long Id;

    private String descricao;

    public CategoriaDto(Long id, String descricao) {
        Id = id;
        this.descricao = descricao;
    }

    public CategoriaDto() {
    }

    public CategoriaDto(CategoriaModel model){
        this.Id = model.getId();
        this.descricao = model.getDescricao();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
