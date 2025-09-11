package com.senai.ExercicioUsuario.repositories;

import com.senai.ExercicioUsuario.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<Boolean> existsByLogin(String login);
}
