package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.RequisicaoDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoCadastroController {

    private ProdutoService produtoService;

    public ProdutoCadastroController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/produtocadastro")
    public String viewCadastro(Model model) {

        model.addAttribute("produtoDto", new ProdutoRequisicaoDto());

        return "produtocadastro";
    }

}
