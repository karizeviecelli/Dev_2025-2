package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    List<ProdutoModel> produtos = new ArrayList<>();

    private Long produtoId = (long) 0;
    List<CategoriaModel> categorias = new ArrayList<>();

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




}
