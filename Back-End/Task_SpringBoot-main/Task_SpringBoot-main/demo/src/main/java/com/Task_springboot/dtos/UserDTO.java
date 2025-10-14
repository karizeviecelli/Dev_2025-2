package com.Task_springboot.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    String nome;

    @Email
    String email;

    public UserDTO() {
    }

    public UserDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
