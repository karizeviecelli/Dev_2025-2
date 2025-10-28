package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CidadeDto;
import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.services.CidadeService;
import com.senai.ExercicioUsuario.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContatoAtualizarController {

    private ContatoService contatoService;
    private CidadeService cidadeService;

    public ContatoAtualizarController(ContatoService contatoService, CidadeService cidadeService) {
        this.contatoService = contatoService;
        this.cidadeService = cidadeService;
    }

    @GetMapping("/contatoatualizar/{id}")
    public String viewAtualizar(Model model, @PathVariable Long id) {

        ContatoDto contatoDto = contatoService.buscarContatoId(id);

        List<CidadeDto> cidadeDto = cidadeService.listaCidades();

        CidadeDto campoDto = cidadeService.buscaCidadeId(contatoDto);

        model.addAttribute("contatoDto", contatoDto);
        model.addAttribute("cidadeDto", cidadeDto);
        model.addAttribute("campoDto", campoDto);

        return "contatoatualizar";
    }


}
