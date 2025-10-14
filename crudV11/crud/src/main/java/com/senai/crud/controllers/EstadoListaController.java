package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.EstadoDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.EstadoService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EstadoListaController {

    @Autowired
    EstadoService service;

    @GetMapping("/estadolista")
    public String viewListaEstado(Model model, HttpServletRequest request){
        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        List<EstadoDto> listaEstadoDto = service.obterEstados();

        model.addAttribute("listaEstadoDto", listaEstadoDto);

        return "estadolista";

    }

}
