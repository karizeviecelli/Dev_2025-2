package com.senai.ExercicioUsuario.repositories;

import com.senai.ExercicioUsuario.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
