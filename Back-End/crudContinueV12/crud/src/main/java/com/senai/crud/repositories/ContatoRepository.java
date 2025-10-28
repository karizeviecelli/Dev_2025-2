package com.senai.crud.repositories;

import com.senai.crud.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel,Long> {
}
