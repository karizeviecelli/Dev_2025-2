package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.CategoriaService;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtoatualizar")
public class ProdutoAtualizarController {

    @Autowired
    ProdutoService service;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
    public String viewProdutoAtualizar(Model model, @PathVariable Long id, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        ProdutoDto produtoDto = service.obterProdutoById(id);
        List<CategoriaDto> listaCategorias = categoriaService.obterCategorias();

        model.addAttribute("listaCategorias",listaCategorias);
        model.addAttribute("produtoDto",produtoDto);

        return "produtoatualizar";
    }

}
