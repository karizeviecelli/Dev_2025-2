package com.senai.crud.controllers;


import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaAtualizarCadastro {

    private final CategoriaService categoriaService;

    public CategoriaAtualizarCadastro(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/atualizarcategoria/{id}")
    public String viewAtualizarCategoria (@PathVariable Long id, Model model){

        CategoriaDto categoriaDto = categoriaService.obterCategoria(id); //Pega o dto, "passa" os dados para model, o model vira um container de dados e com a ajuda do thymeleaf ele imprime par ao usuario.
        model.addAttribute("categoriaDto",categoriaDto);

        return "categoriaatualizar";
    }

}
