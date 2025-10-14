package com.senai.crud.dtos;

import com.senai.crud.models.EstadoModel;

public class EstadoDto {

    private Long id;

    private String nome;

    private String sigla;

    public EstadoDto() {
    }

    public EstadoDto(EstadoModel estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.sigla = estado.getSigla();
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
