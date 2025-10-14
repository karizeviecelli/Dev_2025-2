package com.senai.crud.services;

import com.senai.crud.dtos.EstadoDto;
import com.senai.crud.models.EstadoModel;
import com.senai.crud.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    public List<EstadoDto> obterEstados(){

        List<EstadoModel> listaEstado = repository.findAll();
        List<EstadoDto> listaEstadoDto = new ArrayList<>();

        for ( EstadoModel estadoModel : listaEstado){
            EstadoDto estadoDto = new EstadoDto(estadoModel);
            listaEstadoDto.add(estadoDto);
        }
        return listaEstadoDto;
    }

    public boolean criarEstado(EstadoDto estadoDto){
        EstadoModel estadoModel = new EstadoModel(estadoDto);
        repository.save(estadoModel);
        return true;
    }

    public boolean atualizarEstado(Long id, EstadoDto estadoDto){
        Optional<EstadoModel> estadoOp = repository.findById(id);
        if (estadoOp.isPresent()){
            estadoOp.get().setNome(estadoDto.getNome());
            estadoOp.get().setSigla(estadoDto.getSigla());
            repository.save(estadoOp.get());
            return  true;
        }
        return false;
    }

    public boolean excluirEstado(Long id){
        repository.deleteById(id);
        return true;
    }

    public EstadoModel obterEstadoPorId(Long id){
        Optional<EstadoModel> estadoOp = repository.findById(id);
        if (estadoOp.isPresent()){
            return estadoOp.get();
        }
        return new EstadoModel();
    }

    public EstadoDto obterEstadoId(Long id){
        Optional<EstadoModel> estadoOp = repository.findById(id);
        if (estadoOp.isPresent()){
            return new EstadoDto(estadoOp.get());
        }
        return new EstadoDto();
    }

}
