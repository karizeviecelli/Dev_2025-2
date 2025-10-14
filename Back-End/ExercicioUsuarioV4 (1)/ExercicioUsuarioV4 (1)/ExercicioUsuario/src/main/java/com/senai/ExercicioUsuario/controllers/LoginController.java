package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.LoginDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
/*
    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<MensagemDto> login(@RequestBody LoginDto dados){
        MensagemDto mensagem = usuarioService.login(dados);

        if (mensagem.getMensagemUsuario().equals("Autenticação bem-sucedida!")){
            return ResponseEntity.ok().body(mensagem);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
*/

    @GetMapping("/login")
    public String viewLogin(){

        loginDto
        //model.addAttribute("loginDto",)
        return "login";
    }





}
