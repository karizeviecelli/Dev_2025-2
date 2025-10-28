package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.CidadeDto;
import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.models.CidadeModel;
import com.senai.ExercicioUsuario.repositories.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeDto> listaCidades(){

        List<CidadeModel> listaModel = cidadeRepository.findAll();
        List<CidadeDto> listaDto = new ArrayList<>();

        for (CidadeModel cidade : listaModel){
            CidadeDto cidadeDto = new CidadeDto();

            cidadeDto.setId(cidade.getId());
            cidadeDto.setNome(cidade.getNome());
            cidadeDto.setEstadoId(cidade.getEstado().getId());
            cidadeDto.setEstadoNome(cidade.getEstado().getNome());

            listaDto.add(cidadeDto);
        }
        return listaDto;
    }

    public CidadeDto buscaCidadeId(ContatoDto dados){

        Optional<CidadeModel> cidadeOp = cidadeRepository.findById(dados.getCidadeId());

        if (cidadeOp.isPresent()){
            CidadeDto cidadeDto = new CidadeDto();

            cidadeDto.setId(cidadeOp.get().getId());
            cidadeDto.setNome(cidadeOp.get().getNome());
            cidadeDto.setEstadoNome(cidadeOp.get().getEstado().getNome());
            cidadeDto.setEstadoId(cidadeOp.get().getId());

            return cidadeDto;
        }
        return null;
    }

}
