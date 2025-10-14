package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriaAtualizarController {

    @Autowired
    CategoriaService service;

    @GetMapping("/categoriaatualizar/{id}")
    public String ViewCategoriaAtualizar(Model model, @PathVariable Long id, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        CategoriaDto categoriaDto = service.obterPorId(id);

        model.addAttribute("categoriaDto", categoriaDto);

        return "categoriaatualizar";

    }
}
