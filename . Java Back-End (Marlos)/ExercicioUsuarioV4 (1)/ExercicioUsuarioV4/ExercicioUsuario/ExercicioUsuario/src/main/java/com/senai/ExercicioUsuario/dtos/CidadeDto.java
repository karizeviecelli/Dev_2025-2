package com.senai.ExercicioUsuario.dtos;

import com.senai.ExercicioUsuario.models.EstadoModel;

public class CidadeDto {

    private Long id;

    private String nome;

    private Long estadoId;

    private String estadoNome;

    public CidadeDto() {
    }

    public CidadeDto(Long id, String nome, Long estadoId, String estadoNome) {
        this.id = id;
        this.nome = nome;
        this.estadoId = estadoId;
        this.estadoNome = estadoNome;
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

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }
}
