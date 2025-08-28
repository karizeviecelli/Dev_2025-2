package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    List<CategoriaModel> categorias = new ArrayList<>();
    List<ProdutoModel> produtos = new ArrayList<>();
    private Long ultimoId;

    public MensagemDto cadastrarCategoria(String nome){
        MensagemDto mensagem = new MensagemDto();
        CategoriaModel categoriaNova = new CategoriaModel();
        ultimoId++;
        categoriaNova.setId(ultimoId);
        categoriaNova.setNome(nome);
        categorias.add(categoriaNova);
        mensagem.setMensagemUsuario("Categoria cadastrada");
        return mensagem;
    }

}
