package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    private EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }




}
