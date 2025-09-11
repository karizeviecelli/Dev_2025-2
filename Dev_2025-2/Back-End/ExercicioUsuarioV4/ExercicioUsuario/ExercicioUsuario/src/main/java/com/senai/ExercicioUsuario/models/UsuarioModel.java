package com.senai.ExercicioUsuario.models;


import jakarta.persistence.*;

@Entity //identifica como tabela
@Table(name = "Usuario") //nome da tabela
public class UsuarioModel {
    @Id//Indica que o atributo ID é chave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // indica o auto incremento
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login" , unique = true) //Unique = true cria um indice unico CHAMADA DE UK - UNIQUE KEY.
    private String login;

    @Column(name = "senha")
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'';
    }
}
