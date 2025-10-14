package com.senai.crud.controllers;

import com.senai.crud.services.UsuarioService;
import org.springframework.ui.Model;
import com.senai.crud.dtos.UsuarioDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class UsuarioListaController {

    private final UsuarioService service;

    public UsuarioListaController(UsuarioService service) {
        this.service = service;
    }


    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){

        List<UsuarioDto> listaDto = service.obterUsuarios();

        model.addAttribute("ListaDto",listaDto);

        return "usuariolista";
    }

}
