package com.senai.crud.controllers;

import com.senai.crud.dtos.RequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioCadastroController {

    @GetMapping("/usuariocadastro")
    public String viewCadastro(Model model){

        //--Adicionar objeto no model do thymeleaf para que ele processe o HTML
        model.addAttribute("usuarioDto", new RequisicaoDto());
        return "usuariocadastro";
    }

}
