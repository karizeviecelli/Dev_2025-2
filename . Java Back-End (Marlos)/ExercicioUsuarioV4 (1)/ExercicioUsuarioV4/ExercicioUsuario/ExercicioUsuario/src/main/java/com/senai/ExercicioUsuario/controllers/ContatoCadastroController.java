package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CidadeDto;
import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.services.CidadeService;
import com.senai.ExercicioUsuario.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContatoCadastroController {
    private CidadeService cidadeService;

    public ContatoCadastroController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/contatocadastro")
    public String viewCadastro(Model model){

        List<CidadeDto> cidadeDto = cidadeService.listaCidades();

        model.addAttribute("cidadeDto", cidadeDto);
        model.addAttribute("contatoDto", new ContatoDto());

        return "contatocadastro";
    }


}
