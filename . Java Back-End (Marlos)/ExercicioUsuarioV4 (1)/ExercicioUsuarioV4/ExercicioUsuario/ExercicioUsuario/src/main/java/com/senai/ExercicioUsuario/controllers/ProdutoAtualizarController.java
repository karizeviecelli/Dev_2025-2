package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.services.CategoriaService;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProdutoAtualizarController {

    private ProdutoService produtoService;
    private CategoriaService categoriaService;
    public ProdutoAtualizarController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/produtoatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){

        ProdutoRequisicaoDto respostaDto = produtoService.buscarProdutoId(id);
        System.out.println("RespostaDto ="+respostaDto.getNome());
        System.out.println("RespostaDto ="+respostaDto.getCategoriaId());
        List<CategoriaRespostaDto> categoriaDto = categoriaService.listaCategorias();

        CategoriaRespostaDto campoDto = categoriaService.buscarCategoriaId(respostaDto);

        System.out.println(campoDto.getNome());
        System.out.println(campoDto.getId());

        model.addAttribute("campoDto", campoDto);
        model.addAttribute("produtoDto", respostaDto);
        model.addAttribute("categoriaDto", categoriaDto);

        return "produtoatualizar";
    }

}
