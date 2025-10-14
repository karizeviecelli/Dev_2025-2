package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    //--adicionar usuário
    public RespostaDto cadastrar(CategoriaDto categoriaDto){

        //--Cria objeto usuarioModel
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setDescricao(categoriaDto.getDescricao());

        repository.save(categoriaModel);

        //--Retornar resposta positiva!
        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("sucesso");
        return resposta ;

    }

    //--excluir usuário
    public RespostaDto excluir(Long id){

        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        if (categoriaOP.isPresent()){
            //--Significa que encontrou a categoria pelo ID
            repository.delete(categoriaOP.get());
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta;
        }

        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Não foi possível remover a categoria id = " + id);
        return resposta ;

    }

    //--atualizar usuário
    public RespostaDto atualizar(Long id, CategoriaDto categoriaDto){

        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        if (categoriaOP.isPresent()){
            //--obter o objeto UsuarioModel de dentro do Opcional
            CategoriaModel categoria = categoriaOP.get();
            categoria.setDescricao(categoriaDto.getDescricao());
            repository.save(categoria);
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta ;
        }

        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Não foi possível atualizar a categoria id = " + id);
        return resposta ;

    }

    //--obter uma unica categoria
    public CategoriaDto obterCategoria(Long id){

        CategoriaDto categoriaDto = new CategoriaDto();

        Optional<CategoriaModel> categoriaOP = repository.findById(id);

        if (categoriaOP.isPresent()){
            categoriaDto.setId(categoriaOP.get().getId());
            categoriaDto.setDescricao(categoriaOP.get().getDescricao());
            return categoriaDto;
        }
        return categoriaDto;
    }

    //--obter todos os usuários
    public List<CategoriaDto> obterCategorias(){

        //--Criar a lista de usuarioDTO
        List<CategoriaDto> listaCategoriaDto = new ArrayList<>();

        List<CategoriaModel> listaCategoriaModel = repository.findAll();

        //--percorrer a lista de usuarioModel
        for (CategoriaModel categoria : listaCategoriaModel){
            //--Criar um objeto usuarioDTO novo
            CategoriaDto categoriaDto = new CategoriaDto();
            //--Converter os dados do usuarioModel para usuarioDto
            categoriaDto.setId(categoria.getId());
            categoriaDto.setDescricao(categoria.getDescricao());
            //--adicionar o usuarioDTO na lista de usuarioDTO
            listaCategoriaDto.add(categoriaDto);
        }
        //--retornar a lista de usuarioDTO
        return listaCategoriaDto;
    }

}
