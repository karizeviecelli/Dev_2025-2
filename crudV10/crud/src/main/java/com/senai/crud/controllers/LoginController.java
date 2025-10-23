package com.senai.crud.controllers;

import com.senai.crud.dtos.LoginDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //--Injeção de dependencia do service
    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String viewLogin(Model model){

        //--Criar um objeto do tipo DTO para que o thymeleaf conheça a estrutura
        LoginDto loginDto = new LoginDto();
        //--Adicionando a estrutura do dto no MODEL para processamento do HTML
        model.addAttribute("loginDto", loginDto);

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto){

        boolean valido = service.validarLogin(loginDto);

        if (valido) {
            // sucesso no login
            return "redirect:/home";
        } else {
            //--erro no login
            return "redirect:/login?erro";
        }
    }


}
