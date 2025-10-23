package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.services.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProdutoAtualizarController {

    private final ProdutoService service;

    public ProdutoAtualizarController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/produtoatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        ProdutoDto produtoDto = service.obterProduto(id);
        model.addAttribute("produtoDto", produtoDto);

        return "produtoatualizar";
    }

}
