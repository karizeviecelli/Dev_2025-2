package com.senai.crud.dtos;

import com.senai.crud.models.CidadeModel;

public class CidadeDto {

    private Long id;

    private String nome;

    private Long estadoId;

    public CidadeDto() {}

    public CidadeDto(CidadeModel cidadeModel){
        this.id = cidadeModel.getId();
        this.nome = cidadeModel.getNome();
        this.estadoId = cidadeModel.getEstado().getId();
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

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
