package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoCadastroController {

    private final CategoriaService service;

    public ProdutoCadastroController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/produtocadastro")
    public String viewCadastro(Model model){

        List<CategoriaDto> categoriasDto = service.obterCategorias();

        //--Adicionar objeto no model do thymeleaf para que ele processe o HTML
        model.addAttribute("produtoDto", new ProdutoDto());
        model.addAttribute("categoriasDto",categoriasDto);

        return "produtocadastro";
    }

}
