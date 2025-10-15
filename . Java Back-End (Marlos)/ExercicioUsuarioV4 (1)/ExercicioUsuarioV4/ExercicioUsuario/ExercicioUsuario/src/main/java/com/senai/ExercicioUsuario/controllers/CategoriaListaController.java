package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.services.CategoriaService;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaListaController {

    private CategoriaService categoriaService;

    public CategoriaListaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorialista")
    public String viewUsuarioLista(Model model){
        // Carregar ListaDto com todos os usuários
        List<CategoriaRespostaDto> listaRespostaDto = categoriaService.listaCategorias();

        // Adicionar a lista no MODEL
        model.addAttribute("categoriaDto", listaRespostaDto);

        return "categorialista";
    }

}
