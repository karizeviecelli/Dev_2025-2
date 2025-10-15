package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaCadastroController {

    private final CategoriaService categoriaService;

    public CategoriaCadastroController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoriacadastro")
    public String viewCategoriaCadastro(Model model){

        model.addAttribute("categoriaDto",new CategoriaDto());
        return "categoriacadastro";

    }


}
