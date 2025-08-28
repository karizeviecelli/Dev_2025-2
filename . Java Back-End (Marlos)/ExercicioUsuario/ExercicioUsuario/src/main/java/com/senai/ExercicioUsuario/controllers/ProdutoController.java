package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Post cadastrar novo produto

    //Get listar TODOS os pacientes

    //Get Listar todos os produtos por determinada categoria
}
