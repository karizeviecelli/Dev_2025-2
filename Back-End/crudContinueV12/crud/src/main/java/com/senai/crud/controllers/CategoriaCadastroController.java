package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaCadastroController {

    @GetMapping("/categoriacadastro")
    public String viewCadastro(Model model){

        //--Adicionar objeto no model do thymeleaf para que ele processe o HTML
        model.addAttribute("categoriaDto", new CategoriaDto());
        return "categoriacadastro";
    }
}
