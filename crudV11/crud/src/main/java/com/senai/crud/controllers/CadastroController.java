package com.senai.crud.controllers;

import com.senai.crud.dtos.MensagemDto;
import com.senai.crud.dtos.RequestDto;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String viewCadastro(Model model){

        RequestDto requestDto = new RequestDto();
        model.addAttribute("requestDto",requestDto);

        return "cadastro";
    }



}
