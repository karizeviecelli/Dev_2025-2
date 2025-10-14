package com.senai.crud.repositories;

import com.senai.crud.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

}
