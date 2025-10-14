package com.senai.crud.services;

import com.senai.crud.dtos.CidadeDto;
import com.senai.crud.models.CidadeModel;
import com.senai.crud.models.EstadoModel;
import com.senai.crud.repositories.CidadeRepository;
import com.senai.crud.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    @Autowired
    EstadoRepository estadoRepository;

    public List<CidadeDto> obterCidades(){

        List<CidadeModel> listaCidade = repository.findAll();
        List<CidadeDto> listaCidadeDto = new ArrayList<>();

        for ( CidadeModel cidadeModel : listaCidade){
            CidadeDto cidadeDto = new CidadeDto(cidadeModel);
            listaCidadeDto.add(cidadeDto);
        }
        return listaCidadeDto;
    }

    public boolean criarCidade(CidadeDto cidadeDto){
        Optional<EstadoModel> estadoOp = estadoRepository.findById(cidadeDto.getEstadoId());
        if (estadoOp.isPresent()){
            CidadeModel cidadeModel = new CidadeModel(cidadeDto, estadoOp.get());
            repository.save(cidadeModel);
            return true;
        }
        return false;
    }

    public boolean atualizarCidade(Long id, CidadeDto cidadeDto){
        Optional<EstadoModel> estadoOp = estadoRepository.findById(cidadeDto.getEstadoId());
        if (estadoOp.isPresent()) {

            Optional<CidadeModel> cidadeOp = repository.findById(id);
            if (cidadeOp.isPresent()) {

                cidadeOp.get().setNome(cidadeDto.getNome());
                cidadeOp.get().setEstado(estadoOp.get());
                repository.save(cidadeOp.get());
                return true;
            }
        }
        return false;
    }

    public boolean excluirCidade(Long id){
        repository.deleteById(id);
        return true;
    }

    public CidadeModel obterCidadePorId(Long id){
        Optional<CidadeModel> cidadeOp = repository.findById(id);
        if (cidadeOp.isPresent()){
            return cidadeOp.get();
        }
        return new CidadeModel();
    }
}
