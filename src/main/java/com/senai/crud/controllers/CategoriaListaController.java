package com.senai.crud.controllers;


import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaListaController {

    private final CategoriaService categoriaService;

    public CategoriaListaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorialista")
    public String viewCategoriaLista(Model model){
        //--Carregar ListaDto com todos os usuários
        List<CategoriaDto> listaDto = categoriaService.obterCategorias();
        //--Adicionar a lista no MODEL
        model.addAttribute("listacategoriadto", listaDto);
        return "categorialista";

    }

}
