package com.senai.crud.controllers;

import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class UsuarioController {

    //--Injeção de dependencia
    private final UsuarioService service;

    //--Construtor
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuario")
    public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto usuarioDto){

        RespostaDto mensagem = service.cadastrar(usuarioDto);

        return "redirect:/usuariolista";
    }

    @PostMapping("/usuario/{id}")
    public String atualizar(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto, @PathVariable Long id){

        service.atualizar(id, usuarioDto);

        return "redirect:/usuariolista";
    }

}
