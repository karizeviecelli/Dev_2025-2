package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaListaController {

    @Autowired
    CategoriaService service;

    @GetMapping("/categorialista")
    public String viewListaCategoria(Model model, HttpServletRequest request){
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        List<CategoriaDto> listaCategoriaDto = service.obterCategorias();

        model.addAttribute("listaCategoriaDto", listaCategoriaDto);

        return "categorialista";

    }

}
