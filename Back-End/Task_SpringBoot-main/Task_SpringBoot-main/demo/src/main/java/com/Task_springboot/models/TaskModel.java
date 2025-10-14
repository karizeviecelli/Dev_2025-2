package com.Task_springboot.models;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Categoria")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "Titulo")
    private String Titulo;

    @Column(name = "Descricao")
    private  String descricao;


    @Column(name = "data")
    private LocalDate data;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)

    @ManyToOne //Um para muitos  ManyToMany = muitos para muitos
    private  UserModel usuario;

    public TaskModel(Long id, String titulo, String descricao, LocalDate data, UserModel usuario) {
        this.id = id;
        Titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }
}
