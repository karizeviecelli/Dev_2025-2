package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {this.produtoService = produtoService;}

    @PostMapping("/produtocadastra")
    public String produtocadastra (@ModelAttribute ("produtoDto")ProdutoDto produtoDto){
        produtoService.cadastrar(produtoDto);
        return "redirect:/produtolista";
    }

}
