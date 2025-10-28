package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContatoListaController {

    private ContatoService contatoService;

    public ContatoListaController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/contatolista")
    public String viewContatoLista(Model model){

        List<ContatoDto> contatoDto = contatoService.listaContato();

        model.addAttribute("contatoDto", contatoDto);

        return "contatolista";

    }

}
