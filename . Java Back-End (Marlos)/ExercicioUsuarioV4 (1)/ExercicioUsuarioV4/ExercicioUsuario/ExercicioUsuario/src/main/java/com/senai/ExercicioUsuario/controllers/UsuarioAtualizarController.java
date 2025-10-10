package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioAtualizarController {

    private UsuarioService usuarioService;

    public UsuarioAtualizarController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarioatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        Object respostaDto = usuarioService.buscarUsuarioId(id);

        model.addAttribute("usuarioDto", respostaDto);

        return "usuarioatualizar";
    }

}
