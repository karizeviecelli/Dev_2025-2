package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Boolean adicionar(CategoriaDto categoriaDto){

        //--Convertendo o objeto DTO em Model
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setDescricao(categoriaDto.getDescricao());

        //listaUsuarios.add(usuarioModel);
        repository.save(categoriaModel);

        return true;
    }

    public boolean atualizar( Long id, CategoriaDto categoriaDto ){

        //--buscar no banco de dados a categoria pelo ID
        Optional<CategoriaModel> categoriaOptional = repository.findById(id);

        //--Se encontrar a categoria
        if (!categoriaOptional.isEmpty()){

            //--Atualizar a descricao da categoria dentro do optional
            categoriaOptional.get().setDescricao(categoriaDto.getDescricao());

            //--persistir usuário no banco de dados
            repository.save(categoriaOptional.get());

            return true;

        }

        return false;

    }

    public List<CategoriaDto> obterCategorias(){

        //--Obter os usuários do banco de dados
        List<CategoriaModel> listaModel = repository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<CategoriaDto> listaDto = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( CategoriaModel categoria :  listaModel ){

            //--Crio UM objeto DTO passando por parametro o model para ter o objeto DTO convertido
            CategoriaDto categoriaDto = new CategoriaDto(categoria);

            //--Adciono o objeto DTO na lista de UsuarioDto
            listaDto.add(categoriaDto);
        }

        return listaDto;
    }

    public CategoriaDto obterPorId(Long id){

        Optional<CategoriaModel> categoriaOptional = repository.findById(id);

        if (!categoriaOptional.isEmpty()){
            return new CategoriaDto(categoriaOptional.get());
        }

        return new CategoriaDto();

    }

    public Boolean remover(Long id){

        //--buscar no banco de dados a categoria pelo ID
        Optional<CategoriaModel> categoriaOptional = repository.findById(id);

        //--Se encontrar a categoria
        if (!categoriaOptional.isEmpty()){
            //-deleta categoria e retorna true
            repository.delete(categoriaOptional.get());
            return true;
        }
        return false;
    }

}
