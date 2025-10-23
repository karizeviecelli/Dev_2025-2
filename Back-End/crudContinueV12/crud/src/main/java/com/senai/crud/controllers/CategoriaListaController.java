package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaListaController {

    private final CategoriaService service;

    public CategoriaListaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/categorialista")
    public String viewUsuarioLista(Model model){
        //--Carregar ListaDto com todos os usuários
        List<CategoriaDto> listaDto = service.obterCategorias();
        //--Adicionar a lista no MODEL
        model.addAttribute("listaDto", listaDto);
        return "categorialista";

    }

}
