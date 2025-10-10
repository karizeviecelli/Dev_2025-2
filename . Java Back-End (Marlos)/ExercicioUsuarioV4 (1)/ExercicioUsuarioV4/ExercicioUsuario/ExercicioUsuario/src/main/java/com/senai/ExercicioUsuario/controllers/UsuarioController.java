package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.RequisicaoDto;
import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto dados){

        MensagemDto mensagemDto = usuarioService.adicionarUsuario(dados);

        return "redirect:/usuariolista";
    }

    @PostMapping("/usuario/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("usuarioDto") RespostaDto dados){

        usuarioService.alterarUsuario(id,dados);

        return "redirect:/usuariolista";
    }


}
