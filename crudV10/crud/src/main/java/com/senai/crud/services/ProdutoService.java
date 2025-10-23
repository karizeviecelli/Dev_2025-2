package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.ProdutoModel;
import com.senai.crud.repositories.CategoriaRepository;
import com.senai.crud.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository repositoryCategoria;

    public ProdutoService(ProdutoRepository repository, CategoriaRepository repositoryCategoria) {
        this.repository = repository;
        this.repositoryCategoria =repositoryCategoria;
    }

    //--adicionar usuário
    public RespostaDto cadastrar(ProdutoDto produtoDto){

        Optional<CategoriaModel> categoriaOP = repositoryCategoria.findById(produtoDto.getCategoriaId());

        if (categoriaOP.isPresent()){

            //--Cria objeto usuarioModel
            ProdutoModel produtoModel = new ProdutoModel();
            produtoModel.setNome(produtoDto.getNome());
            produtoModel.setPreco(produtoDto.getPreco());
            produtoModel.setCategoria(categoriaOP.get());

            repository.save(produtoModel);

            //--Retornar resposta positiva!
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta ;

        }

        //--Retornar resposta positiva!
        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Erro ao localizar a categoria id=" + produtoDto.getCategoriaId());
        return resposta ;
    }

    //--excluir usuário
    public RespostaDto excluir(Long id){

        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()){
            //--Significa que encontrou a Produto pelo ID
            repository.delete(produtoOP.get());
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("sucesso");
            return resposta;
        }

        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("Não foi possível remover o Produto id = " + id);
        return resposta ;

    }

    //--atualizar usuário
    public RespostaDto atualizar(Long id, ProdutoDto produtoDto){

        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (!produtoOP.isPresent()) {
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("Não foi possível atualizar o produto id = " + id);
            return resposta ;
        }

        Optional<CategoriaModel> categoriaOP = repositoryCategoria.findById(produtoDto.getCategoriaId());
        if (!categoriaOP.isPresent()) {
            RespostaDto resposta = new  RespostaDto();
            resposta.setMensagem("Não foi possível atualizar o produto id pois não foi encontrado a categoria= " + id);
            return resposta ;
        }

        //--obter o objeto UsuarioModel de dentro do Opcional
        ProdutoModel produto = produtoOP.get();
        produto.setNome(produtoDto.getNome());
        produto.setPreco(produtoDto.getPreco());
        produto.setCategoria(categoriaOP.get());
        repository.save(produto);
        RespostaDto resposta = new  RespostaDto();
        resposta.setMensagem("sucesso");
        return resposta ;

    }

    //--obter uma unica produto
    public ProdutoDto obterProduto(Long id){

        ProdutoDto produtoDto = new ProdutoDto();

        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()){
            produtoDto.setId(produtoOP.get().getId());
            produtoDto.setNome(produtoOP.get().getNome());
            produtoDto.setPreco(produtoOP.get().getPreco());
            produtoDto.setCategoriaId(produtoOP.get().getCategoria().getId());
            return produtoDto;
        }
        return produtoDto;
    }

    //--obter todos os usuários
    public List<ProdutoDto> obterProdutos(){

        //--Criar a lista de usuarioDTO
        List<ProdutoDto> listaProdutoDto = new ArrayList<>();

        List<ProdutoModel> listaProdutoModel = repository.findAll();

        //--percorrer a lista de usuarioModel
        for (ProdutoModel produto : listaProdutoModel){
            //--Criar um objeto usuarioDTO novo
            ProdutoDto produtoDto = new ProdutoDto();
            //--Converter os dados do usuarioModel para usuarioDto
            produtoDto.setId(produto.getId());
            produtoDto.setId(produto.getId());
            produtoDto.setNome(produto.getNome());
            produtoDto.setPreco(produto.getPreco());
            produtoDto.setCategoriaId(produto.getCategoria().getId());
            //--adicionar o usuarioDTO na lista de usuarioDTO
            listaProdutoDto.add(produtoDto);
        }
        //--retornar a lista de usuarioDTO
        return listaProdutoDto;
    }

}
