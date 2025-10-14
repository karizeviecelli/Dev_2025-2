package com.senai.crud.controllers;

import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioAtualizarController {

    private final UsuarioService usuarioService;

    public UsuarioAtualizarController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/usuarioatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){


        UsuarioDto usuarioDto = usuarioService.obterUsuario(id);
        model.addAttribute("usuarioDto",usuarioDto);

        return "usuarioatualizar";
    }


}
