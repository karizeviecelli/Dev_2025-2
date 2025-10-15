package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.RequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaCadastroController {

    @GetMapping("/categoriacadastro")
    public String viewCadastro(Model model) {

        model.addAttribute("categoriaDto", new RequisicaoDto());

        return "categoriacadastro";
    }

}
