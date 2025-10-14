package com.senai.crud.models;

import com.senai.crud.dtos.CidadeDto;
import jakarta.persistence.*;

@Entity
@Table(name="CIDADE")
public class CidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @ManyToOne
    private EstadoModel estado;

    public CidadeModel() {
    }

    public CidadeModel(CidadeDto cidadeDto, EstadoModel estado){
        this.id = cidadeDto.getId();
        this.nome = cidadeDto.getNome();
        this.estado = estado;
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

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }
}
