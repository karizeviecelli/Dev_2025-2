package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.models.ProdutoModel;
import com.senai.ExercicioUsuario.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    List<ProdutoModel> produtos = new ArrayList<>();

    public ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    //Cadastrar um produto novo!
    public MensagemDto cadastrarProduto(ProdutoRequisicaoDto dados){
        MensagemDto msg = new MensagemDto();

        ProdutoModel produtoNovo = new ProdutoModel();

        produtoNovo.setNome(dados.getNome());
        produtoNovo.setPreco(dados.getPreco());
        repository.save(produtoNovo);
        msg.setMensagemUsuario("Produto Cadastrado!");

        return msg;
    }

    // Listando produtos cadastrados

    public  List<ProdutoRespostaDto> listarProdutos(){

        List<ProdutoRespostaDto> lista  = new ArrayList<>();



        List<ProdutoModel> listaProdutoModel = repository.findAll();
        MensagemDto msg = new MensagemDto();


        for (ProdutoModel verificando : listaProdutoModel){
            ProdutoRespostaDto produtoReposta = new ProdutoRespostaDto();

            produtoReposta.setCategoria(verificando.getNome());
            produtoReposta.setNome(verificando.getNome());
            produtoReposta.setPreco(verificando.getPreco());
            lista.add(produtoReposta);

        }
            msg.setMensagemUsuario("Lista de produtos não encontrada!");
            return lista;
    }
//Deletar o produto
    public MensagemDto deletarProduto (Long id){
        MensagemDto msg = new MensagemDto();

        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()){
            repository.delete(produtoOP.get());
            msg.setMensagemUsuario("Produto deletado com sucesso!");
            return msg;
        }else {
            msg.setMensagemUsuario("Id de produto não encontrado!");
            return  msg;
        }
    }
//Alter preco e nome do produto
    public MensagemDto alterarProduto(long id,ProdutoRequisicaoDto dados){
        MensagemDto msg = new MensagemDto();

        Optional<ProdutoModel> produtoOP = repository.findById(id);
        if (produtoOP.isPresent()){
            ProdutoModel produto = produtoOP.get();

            produto.setNome(dados.getNome());
            produto.setPreco(dados.getPreco());
            repository.save(produto);
            msg.setMensagemUsuario("Informações do produto alterados.");
            return msg;
        }
        msg.setMensagemUsuario("Usuário não encontrado.");
        return msg;
    }



}
