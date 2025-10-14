package com.senai.ExercicioUsuario.repositories;

import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
