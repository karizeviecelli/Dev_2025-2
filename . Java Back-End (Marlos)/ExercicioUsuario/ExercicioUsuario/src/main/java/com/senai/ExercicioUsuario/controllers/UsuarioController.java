package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    UsuarioService usuarioService;

    //faz a injeção de dependência
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<MensagemDto> adicionarUsuario(@RequestBody RequisicaoDto dados){
        MensagemDto mensagemDto;
        mensagemDto = usuarioService.adicionarUsuario(dados);
        return ResponseEntity.ok(mensagemDto);
    }

    //lista usuarios

    //busca usuario por id

    //atualiza usuario por id

    //remove usuario
}
