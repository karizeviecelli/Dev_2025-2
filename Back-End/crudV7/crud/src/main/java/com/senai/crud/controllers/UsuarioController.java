package com.senai.crud.controllers;

import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public String cadastrar(@ModelAttribute ("usuariodto")RequisicaoDto usuarioDto){

         RespostaDto mesangem = usuarioService.cadastrar(usuarioDto);

        return "redirect:/usuariolista";
    }


    @PostMapping("/usuario/{id}")
    public String atualizar(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto, @PathVariable Long id){


        usuarioService.atualizar(id,usuarioDto);


        return "redirect:/usuariolista";
    }
}
