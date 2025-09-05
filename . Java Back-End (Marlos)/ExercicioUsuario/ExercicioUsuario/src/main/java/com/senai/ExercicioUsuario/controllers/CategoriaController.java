package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private ProdutoService produtoService;

    public CategoriaController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Post cadastrar nova categoria
    @PostMapping
    public ResponseEntity<MensagemDto> cadastrarCategoria(@RequestBody CategoriaRequisicaoDto nome) {
        MensagemDto mensagem = produtoService.cadastrarCategoria(nome);
        if (mensagem.getMensagemUsuario().equals("Esse nome de categoria já existe")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.ok().body(mensagem);
    }

    //get listar todas as categorias
    @GetMapping
    public ResponseEntity<List<CategoriaRespostaDto>> listarCategorias() {
        List<CategoriaRespostaDto> listaCategoria = produtoService.listaCategorias();
        return ResponseEntity.ok().body(listaCategoria);
    }
}

