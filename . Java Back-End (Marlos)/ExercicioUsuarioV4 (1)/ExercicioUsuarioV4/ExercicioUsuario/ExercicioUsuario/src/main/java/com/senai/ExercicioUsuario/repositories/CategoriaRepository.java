package com.senai.ExercicioUsuario.repositories;

import com.senai.ExercicioUsuario.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    Optional<CategoriaModel> findByNome(String categoria);
}
