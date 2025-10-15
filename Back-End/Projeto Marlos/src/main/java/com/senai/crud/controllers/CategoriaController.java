package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    // INJEÇÃO DE DEPENDECE
    private final CategoriaService categoriaService;

    //Construtor
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
        }

        @PostMapping("/categoria")
        public String cadastrarCategoria (@ModelAttribute("categoriaDto") CategoriaDto categoriaDto){
        categoriaService.cadastrar(categoriaDto);
        return "redirect:/categorialista";

        }


    @PostMapping("/categoria/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto, @PathVariable Long id){

        categoriaService.atualizar(id,categoriaDto);

        return "redirect:/categorialista";

    }
}
