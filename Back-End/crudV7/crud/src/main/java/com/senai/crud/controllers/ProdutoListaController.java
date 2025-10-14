package com.senai.crud.controllers;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    private final ProdutoService produtoService;

    public ProdutoListaController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping("/produtolista")
    public String viewProdutoLista(Model model){

        List<ProdutoDto> listaDto = produtoService.obterProdutos();

        model.addAttribute("listaDto",listaDto);

        return "produtolista";
    }
}
