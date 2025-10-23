package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    private final ProdutoService service;

    public ProdutoListaController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/produtolista")
    public String viewProdutoLista(Model model){
        //--Carregar ListaDto com todos os usuários
        List<ProdutoDto> listaDto = service.obterProdutos();
        //--Adicionar a lista no MODEL
        model.addAttribute("listaDto", listaDto);
        return "produtolista";

    }


}
