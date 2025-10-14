package com.senai.crud.controllers;

import com.senai.crud.dtos.LoginDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.models.CategoriaModel;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/login")
    public String viewLogin(Model model){

        //-- Criar um objeto do tipo DTO para que thymeleaft conheça a estrutura
        LoginDto loginDto = new LoginDto();
        //-- Adicionando a estrutura do DTO para o model para processamento do HTML
        model.addAttribute("loginDto",loginDto);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto") UsuarioDto loginDto){

       if (usuarioService.verificaLogin(loginDto)){
           //sucesso no login
            return "redirect:/home";
       }

        //erro no login
         return "redirect:/login?erro";





      //  if (loginDto.getLogin().equals("admin@admin") && loginDto.getSenha().equals("admin")){

            //sucesso no login
           // return "redirect:/home";
      //  } else {
            //erro no login
          //  return "redirect:/login?erro";
       // }
    }
}
