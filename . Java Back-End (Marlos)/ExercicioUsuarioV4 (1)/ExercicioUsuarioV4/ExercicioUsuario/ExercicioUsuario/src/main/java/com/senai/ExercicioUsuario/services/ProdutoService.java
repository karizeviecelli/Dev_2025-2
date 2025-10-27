package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.ProdutoModel;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import com.senai.ExercicioUsuario.repositories.CategoriaRepository;
import com.senai.ExercicioUsuario.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    List<ProdutoModel> produtos = new ArrayList<>();

    public ProdutoRepository repository;
    public CategoriaRepository repositoryCategoria;
    public ProdutoService(ProdutoRepository repository, CategoriaRepository repositoryCategoria) {
        this.repository = repository;
        this.repositoryCategoria = repositoryCategoria;
    }

    //Cadastrar um produto novo!
    public MensagemDto cadastrarProduto(ProdutoRequisicaoDto dados){
        MensagemDto msg = new MensagemDto();

        Optional<CategoriaModel> categoriaOptional = repositoryCategoria.findById(dados.getCategoriaId());
        if (categoriaOptional.isPresent()){
            ProdutoModel produtoNovo = new ProdutoModel();

            produtoNovo.setNome(dados.getNome());
            produtoNovo.setPreco(dados.getPreco());

            produtoNovo.setCategoria(categoriaOptional.get());

            repository.save(produtoNovo);

            msg.setMensagemUsuario("Produto Cadastrado!");

            return msg;
        }

        msg.setMensagemUsuario("Erro ao localizar a categoria id= "+ dados.getCategoriaId());
        return msg;
    }

    // Listando produtos cadastrados

    public  List<ProdutoRespostaDto> listarProdutos(){
        List<ProdutoRespostaDto> lista  = new ArrayList<>();
        List<ProdutoModel> listaProdutoModel = repository.findAll();

        for (ProdutoModel verificando : listaProdutoModel){
            ProdutoRespostaDto produtoReposta = new ProdutoRespostaDto();
            produtoReposta.setId(verificando.getId());
            produtoReposta.setNome(verificando.getNome());
            produtoReposta.setPreco(verificando.getPreco());
            produtoReposta.setCategoria(verificando.getCategoria().getNome());

            lista.add(produtoReposta);
        }
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
    public MensagemDto alterarProduto(Long id,ProdutoRequisicaoDto dados){
        MensagemDto msg = new MensagemDto();

        Optional<CategoriaModel> categoriaOp = repositoryCategoria.findById(dados.getCategoriaId());

        if (!categoriaOp.isPresent()){
            msg.setMensagemUsuario("Id da categoria não foi encontrada!");
            return msg;
        }

        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()){
            ProdutoModel produto = produtoOP.get();

            produto.setNome(dados.getNome());
            produto.setPreco(dados.getPreco());
            produto.setCategoria(categoriaOp.get());
            repository.save(produto);
            msg.setMensagemUsuario("Informações do produto alterados.");

            return msg;
        }
        msg.setMensagemUsuario("Usuário não encontrado.");
        return msg;
    }

    public ProdutoRequisicaoDto buscarProdutoId(Long id) {
        ProdutoRequisicaoDto resposta = new ProdutoRequisicaoDto();


        Optional<ProdutoModel> produtoOP = repository.findById(id);

        if (produtoOP.isPresent()) {
            resposta.setId(produtoOP.get().getId());
            resposta.setNome(produtoOP.get().getNome());
            resposta.setPreco(produtoOP.get().getPreco());
            resposta.setCategoriaId(produtoOP.get().getCategoria().getId());
            return resposta;
        }
        return resposta;
    }

}
