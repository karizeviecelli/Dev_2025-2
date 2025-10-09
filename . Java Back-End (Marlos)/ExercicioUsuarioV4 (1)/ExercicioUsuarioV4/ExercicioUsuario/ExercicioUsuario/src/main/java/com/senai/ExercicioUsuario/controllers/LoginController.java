package com.senai.ExercicioUsuario.controllers;
/*
import com.senai.ExercicioUsuario.dtos.LoginDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
*/

import com.senai.ExercicioUsuario.dtos.LoginDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
/*
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
    public String viewLogin(Model model){

        //--Criar um objet do tipo DTO para que o thymeleaf conheça a estrutura
        LoginDto loginDto = new LoginDto();

        //--Adicionando a estrutura do dto no MODEL para processamento do HTML
        model.addAttribute("loginDto", loginDto);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto){
        if (usuarioService.login(loginDto)){
            //sucesso no login
            return "redirect:/home";
        } else {
            //erro no login
            return "redirect:/login?erro";
        }
    }




}
