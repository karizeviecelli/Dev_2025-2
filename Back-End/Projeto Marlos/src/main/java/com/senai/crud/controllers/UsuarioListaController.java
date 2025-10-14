package com.senai.crud.controllers;

import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioListaController {

    private final UsuarioService service;

    public UsuarioListaController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){
        //--Carregar ListaDto com todos os usuários
        List<UsuarioDto> listaDto = service.obterUsuarios();
        //--Adicionar a lista no MODEL
        model.addAttribute("listaDto", listaDto);
        return "usuariolista";

    }

}
