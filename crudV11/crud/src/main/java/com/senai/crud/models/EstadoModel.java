package com.senai.crud.models;

import com.senai.crud.dtos.EstadoDto;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="ESTADO")
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla", length = 2)
    private String sigla;

    public EstadoModel() {
    }

    public EstadoModel(EstadoDto estadoDto){
        this.id =  estadoDto.getId();
        this.nome = estadoDto.getNome();
        this.sigla = estadoDto.getSigla();
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
