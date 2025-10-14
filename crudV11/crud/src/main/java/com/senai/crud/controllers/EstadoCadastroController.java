package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.EstadoDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstadoCadastroController {

    @GetMapping("/estadocadastro")
    public String viewEstadoCadastro(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        EstadoDto estadoDto = new EstadoDto();

        model.addAttribute("estadoDto",estadoDto);

        return "estadocadastro";

    }
}
