package com.senai.crud.repositories;

import com.senai.crud.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByLogin(String login);

    Optional<UsuarioModel> findByLoginAndSenha(String login, String senha);


}
