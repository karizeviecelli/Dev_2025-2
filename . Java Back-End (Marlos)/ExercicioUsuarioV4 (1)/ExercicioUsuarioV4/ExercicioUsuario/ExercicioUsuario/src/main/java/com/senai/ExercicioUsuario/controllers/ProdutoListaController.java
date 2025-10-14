package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    private ProdutoService produtoService;

    public ProdutoListaController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/produtolista")
    public String viewProdutoLista(Model model){

        List<ProdutoRespostaDto> listaProdutoDto = produtoService.listarProdutos();

        model.addAttribute("listaDto", listaProdutoDto);

        return "produtolista";
    }

}
