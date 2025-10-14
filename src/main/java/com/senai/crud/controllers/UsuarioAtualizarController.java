package com.senai.crud.controllers;

import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsuarioAtualizarController {

    private final UsuarioService service;

    public UsuarioAtualizarController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuarioatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        UsuarioDto usuarioDto = service.obterUsuario(id);
        model.addAttribute("usuarioDto", usuarioDto);

        return "usuarioatualizar";
    }

}
