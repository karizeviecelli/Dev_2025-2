package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaAtualizarController {

    CategoriaService categoriaService;

    public CategoriaAtualizarController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoriaatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        Object respostaDto = categoriaService.buscarCategoriaId(id);


        model.addAttribute("categoriaDto", respostaDto);

        return "categoriaatualizar";
    }

}
