package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.models.CidadeModel;
import com.senai.ExercicioUsuario.models.ContatoModel;
import com.senai.ExercicioUsuario.repositories.CidadeRepository;
import com.senai.ExercicioUsuario.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;
    private CidadeRepository cidadeRepository;

    public ContatoService(ContatoRepository contatoRepository, CidadeRepository cidadeRepository) {
        this.contatoRepository = contatoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    //create
    public Boolean cadastrarContato(ContatoDto dados){
        ContatoModel contatoModel = new ContatoModel();

        Optional<CidadeModel> cidadeOp = cidadeRepository.findById(dados.getCidadeId());

        if(cidadeOp.isPresent()){
            contatoModel.setNome(dados.getNome());
            contatoModel.setEmail(dados.getEmail());
            contatoModel.setDataNasc(dados.getDataNasc());
            contatoModel.setTelefone(dados.getTelefone());

            contatoModel.setCidade(cidadeOp.get());

            contatoRepository.save(contatoModel);

            return true;
        }

        return false;
    }
    //list
    public List<ContatoDto> listaContato(){
        List<ContatoDto> listaDto = new ArrayList<>();
        List<ContatoModel> listaModel = contatoRepository.findAll();

        for(ContatoModel contato : listaModel){
            ContatoDto contatoDto = new ContatoDto();

            contatoDto.setId(contato.getId());
            contatoDto.setNome(contato.getNome());
            contatoDto.setDataNasc(contato.getDataNasc());
            contatoDto.setEmail(contato.getEmail());
            contatoDto.setTelefone(contato.getTelefone());

            contatoDto.setCidadeId(contato.getCidade().getId());
            contatoDto.setCidadeNome(contato.getCidade().getNome());

            listaDto.add(contatoDto);
        }

        return listaDto;
    }
    //update
    public Boolean atualizaContato(Long id, ContatoDto dados){

        Optional<CidadeModel> cidadeOp = cidadeRepository.findById(dados.getCidadeId());

        if (!cidadeOp.isPresent()){
            return false;
        }

        Optional<ContatoModel> contatoOp = contatoRepository.findById(id);

        if (contatoOp.isPresent()) {
            ContatoModel contatoModel = new ContatoModel();

            contatoModel.setId(contatoOp.get().getId());
            contatoModel.setNome(dados.getNome());
            contatoModel.setTelefone(dados.getTelefone());
            contatoModel.setEmail(dados.getEmail());
            contatoModel.setDataNasc(dados.getDataNasc());

            contatoModel.setCidade(cidadeOp.get());

            contatoRepository.save(contatoModel);
            return true;
        }

        return false;
    }
    //delete
    public Boolean excluirContato(Long id){

        Optional<ContatoModel> contatoOp = contatoRepository.findById(id);

        if(contatoOp.isPresent()){
            contatoRepository.delete(contatoOp.get());
            return true;
        }

        return false;
    }

}
