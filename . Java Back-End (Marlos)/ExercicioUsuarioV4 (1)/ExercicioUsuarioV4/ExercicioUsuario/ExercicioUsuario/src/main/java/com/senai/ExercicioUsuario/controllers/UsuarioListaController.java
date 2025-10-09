package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.LoginDto;
import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioListaController {

    private UsuarioService usuarioService;

    public UsuarioListaController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping("/usuariolista")
    public String viewUsuarioLista(Model model){
        // Carregar ListaDto com todos os usuários
        List<RespostaDto> listaRespostaDto = usuarioService.listaUsuarios();

        // Adicionar a lista no MODEL
        model.addAttribute("listaDto", listaRespostaDto);

        return "usuariolista";
    }

}
