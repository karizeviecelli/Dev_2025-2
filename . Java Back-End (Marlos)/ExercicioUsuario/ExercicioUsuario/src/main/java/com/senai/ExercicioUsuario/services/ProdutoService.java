package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    List<CategoriaModel> categorias = new ArrayList<>();
    List<ProdutoModel> produtos = new ArrayList<>();
    private Long categoriaId = 0L;
    private Long produtoId = 0L;

    // ------------------CATEGORIA----------------------
    public MensagemDto cadastrarCategoria(CategoriaRequisicaoDto nome) {
        MensagemDto mensagem = new MensagemDto();
        CategoriaModel categoriaNova = new CategoriaModel();
        for (CategoriaModel categoria : categorias) {
            if (categoria.getNome().equals(nome.getNome())) {
                mensagem.setMensagemUsuario("Esse nome de categoria já existe");
                return mensagem;
            }
        }
        categoriaId++;
        categoriaNova.setId(categoriaId);
        categoriaNova.setNome(nome.getNome());
        categorias.add(categoriaNova);
        mensagem.setMensagemUsuario("Categoria cadastrada");

        return mensagem;
    }

    public List<CategoriaRespostaDto> listaCategorias() {
        List<CategoriaRespostaDto> lista = new ArrayList<>();

        for (CategoriaModel categoria : categorias) {
            CategoriaRespostaDto categoriaR = new CategoriaRespostaDto();

            categoriaR.setId(categoria.getId());
            categoriaR.setNome(categoria.getNome());
            lista.add(categoriaR);
        }
        return lista;
    }


    // ------------------PRODUTO----------------------
    public MensagemDto cadastrarProduto(ProdutoRequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();
        for (CategoriaModel categoria : categorias) {
            if (categoria.getId() == dados.getCategoriaId()) {
                //Impede de criar nome já cadastrado
                for (ProdutoModel produto : produtos) {
                    if (produto.getNome().equals(dados.getNome())) {
                        mensagem.setMensagemUsuario("Produto com esse nome já cadastrado!");
                        return mensagem;
                    }
                }

                ProdutoModel produtoM = new ProdutoModel();
                produtoId++;
                produtoM.setId(produtoId);
                produtoM.setNome(dados.getNome());
                produtoM.setPreco(dados.getPreco());
                produtoM.setCategoriaId(dados.getCategoriaId());
                produtos.add(produtoM);
                mensagem.setMensagemUsuario("Produto cadastrado!");
                return mensagem;
            }
        }
        mensagem.setMensagemUsuario("Esse Id não corresponde a nenhuma categoria!");
        return mensagem;
    }

    public List<ProdutoRespostaDto> listarProdutos() {
        List<ProdutoRespostaDto> lista = new ArrayList<>();

        for (ProdutoModel produto : produtos) {
            ProdutoRespostaDto produtoRespostaDto = new ProdutoRespostaDto();

            produtoRespostaDto.setId(produto.getId());
            produtoRespostaDto.setNome(produto.getNome());
            for (CategoriaModel categoria : categorias){
                if (produto.getCategoriaId() == categoria.getId()){
                    produtoRespostaDto.setCategoria(categoria.getNome());
                }
            }

            produtoRespostaDto.setPreco(produto.getPreco());

            lista.add(produtoRespostaDto);
        }

        return lista;
    }

    public ProdutoRespostaDto listaProdutoPorId(Long id) {
        ProdutoRespostaDto resposta = new ProdutoRespostaDto();

        for (ProdutoModel produto : produtos) {
            if (id == produto.getId()){
                resposta.setId(produto.getId());
                resposta.setNome(produto.getNome());
                resposta.setPreco(produto.getPreco());
                for (CategoriaModel categoria : categorias){
                    if (produto.getCategoriaId() == categoria.getId()){
                        resposta.setCategoria(categoria.getNome());
                    }
                }
            }
        }
        return resposta;
    }
}
