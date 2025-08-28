package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private ProdutoService produtoService;

    public CategoriaController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Post cadastrar nova categoria
    @PostMapping
    public ResponseEntity<MensagemDto> cadastrarCategoria(@RequestBody String nome){
        MensagemDto mensagem = produtoService.cadastrarCategoria(nome);
        return ResponseEntity.ok().body(mensagem);
    }

    //get listar todas as categorias
}
