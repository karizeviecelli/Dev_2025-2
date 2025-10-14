package com.senai.crud.controllers;


import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioCadastroController {

    private final UsuarioService usuarioService;

    public UsuarioCadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuariocadastro")
    public String viewCadastro(Model model){


        model.addAttribute("usuariodto",new RequisicaoDto());

        return "usuariocadastro";
    }

}
