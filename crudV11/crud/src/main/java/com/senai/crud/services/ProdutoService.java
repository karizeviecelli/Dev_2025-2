package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.CategoriaRepository;
import com.senai.crud.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    CategoriaRepository repositoryCategoria;

    public List<ProdutoDto> obterProdutos(){

        //--Obter os usuários do banco de dados
        List<ProdutoModel> listaProdutos = repository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<ProdutoDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( ProdutoModel produto :  listaProdutos ){

            //--Crio UM objeto DTO
            ProdutoDto produtoRetorno = new ProdutoDto();

            //--Converto UM objeto model em UM objeto DTO
            produtoRetorno.setId(produto.getId());
            produtoRetorno.setNome(produto.getNome());
            produtoRetorno.setDescricao(produto.getDescricao());
            produtoRetorno.setPreco(produto.getPreco());
            produtoRetorno.setQuantidade(produto.getQuantidade());

            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(produtoRetorno);
        }

        return lista;

    }

    public ProdutoDto obterProdutoById(Long id){

        Optional<ProdutoModel> produtoOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (!produtoOptional.isEmpty()){
            return new ProdutoDto(produtoOptional.get());
        }

        return new ProdutoDto();
    }

    public Boolean adicionar(ProdutoDto produtoDto){

        Optional<CategoriaModel> categoriaOp = repositoryCategoria.findById(produtoDto.getCategoriaid());

        if (!categoriaOp.isEmpty()){

            //--Convertendo o objeto DTO em Model
            ProdutoModel produto = new ProdutoModel(produtoDto, categoriaOp.get());

            //--Persiste o produto no banco de dados
            repository.save(produto);

            return true;
        }

        return false;
    }

    public boolean atualizar( Long id, ProdutoDto produtoDto ){

        //--buscar no banco de dados o usuário pelo ID
        Optional<ProdutoModel> produtoOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (produtoOptional.isPresent()){
            //--Atualizar

            Optional<CategoriaModel> categoriaOp = repositoryCategoria.findById(produtoDto.getCategoriaid());

            if (categoriaOp.isPresent()){

                //--Obter o usuario dentro do optinal
                ProdutoModel produto = produtoOptional.get();

                produto.setCategoria(categoriaOp.get());

                //--atualiar produto model com dados produto dto
                produto.convert(produtoDto);

                //--persistir usuário no banco de dados
                repository.save(produto);

                return true;
            }

        }

        return false;
    }

    public boolean remover(Long id){

        //--buscar no banco de dados o produto pelo ID
        Optional<ProdutoModel> produtoOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (!produtoOptional.isEmpty()){
            repository.delete(produtoOptional.get());
           return true;
        }
        return false;
    }
}
