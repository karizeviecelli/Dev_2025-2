package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoAtualizarController {

    private ProdutoService produtoService;

    public ProdutoAtualizarController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtoatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        Object respostaDto = produtoService.buscarProdutoId(id);

        model.addAttribute("produtoDto", respostaDto);

        return "produtoatualizar";
    }

}
