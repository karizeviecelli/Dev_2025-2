package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ContatoModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    //Sempre lembrar que o repository deve ser adicionado na classe service

    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    //--adicionar usuário
    public RespostaDto cadastrarContato(ContatoDto contatoDto){

        //--Cria objeto usuarioModel
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setCidade(contatoDto.getCidade());
        contatoModel.setNome(contatoDto.getNome());
        contatoModel.setData(contatoDto.getData());
        contatoModel.setEmail(contatoDto.getEmail());
        contatoModel.setTelefone(contatoDto.getTelefone());

        contatoRepository.save(contatoModel);

        //--Retornar resposta positiva!
        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("sucesso");
        return resposta ;

    }

    //--obter todos os produtos
    public List<ContatoDto> obterContato(){

        //--Criar a lista de Produto-DTO
        List<ContatoDto> listaContatoDto = new ArrayList<>();

        List<ContatoModel> listaContato = contatoRepository.findAll();

        //--percorrer a lista de produtoModel
        for (ContatoModel contato : listaContato){
            //--Criar um objeto produtoDTO novo
           ContatoDto contatoDto = new ContatoDto();
            //--Converter os dados do produtoModel para produtoDto
            contatoDto.setCidade(contato.getCidade());
            contatoDto.setData(contato.getData());
            contatoDto.setNome(contato.getNome());
            contatoDto.setEmail(contato.getEmail());
            contatoDto.setTelefone(contato.getTelefone());
            contatoDto.setId(contato.getId());
            //--adicionar o produtoDTO na lista de produtoDTO
            listaContatoDto.add(contatoDto);
        }
        //--retornar a lista de produtoDTO
        return listaContatoDto;
    }


    //--excluir usuário
    public RespostaDto excluirContato(Long id){

        Optional<ContatoModel> contatoModel = contatoRepository.findById(id);

        if (contatoModel.isPresent()){
            //--Significa que encontro o usuário pelo ID
            contatoRepository.delete(contatoModel.get());
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta;
        }

        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Não foi possível remover o contato com id = " + id);
        return resposta ;

    }

    //--atualizar usuário
    public RespostaDto atualizarContato(Long id, ContatoDto contatoDto){

        Optional<ContatoModel> contatoOP = contatoRepository.findById(id);

        if (contatoOP.isPresent()){
            //--obter o objeto UsuarioModel de dentro do Opcional
            ContatoModel contato = contatoOP.get();

            contato.setNome(contatoDto.getNome());
            contato.setEmail(contatoDto.getEmail());
            contato.setCidade(contatoDto.getCidade());
            contato.setData(contatoDto.getData());
            contato.setTelefone(contatoDto.getTelefone());
            contatoRepository.save(contato);
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta ;
        }

        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Não foi possível atualizar o usuário id = " + id);
        return resposta ;

    }
    public ContatoDto obterContato(Long id){

        ContatoDto contatoDto = new ContatoDto();
        Optional<ContatoModel> contatoOP = contatoRepository.findById(id);

        if (contatoOP.isPresent()){
            contatoDto.setNome(contatoDto.getNome());
            contatoDto.setEmail(contatoDto.getEmail());
            contatoDto.setData(contatoDto.getData());
            contatoDto.setCidade(contatoDto.getCidade());
            contatoDto.setTelefone(contatoDto.getTelefone());
            return contatoDto;
        }
        return contatoDto;
    }



}
