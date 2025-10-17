package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.RequisicaoDto;
import com.senai.ExercicioUsuario.services.CategoriaService;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoCadastroController {

    private CategoriaService categoriaService;

    public ProdutoCadastroController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/produtocadastro")
    public String viewCadastro(Model model) {

        List<CategoriaRespostaDto> categoriaDto = categoriaService.listaCategorias();

        model.addAttribute("produtoDto", new ProdutoRequisicaoDto());
        model.addAttribute("categoriaDto", categoriaDto);

        return "produtocadastro";
    }



}
