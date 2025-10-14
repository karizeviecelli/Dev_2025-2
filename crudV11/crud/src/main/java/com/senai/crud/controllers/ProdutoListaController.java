package com.senai.crud.controllers;
import com.senai.crud.dtos.ListaUsuariosDto;
import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.UsuarioSessaoDto;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.services.UsuarioService;
import com.senai.crud.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdutoListaController {

    @Autowired
    ProdutoService service;

    @GetMapping("/produtolista")
    public String obterProdutoLista(Model model, HttpServletRequest request){

        UsuarioSessaoDto usuarioSessao = ControleSessao.obter(request);

        if (usuarioSessao.getId() == 0){
            //--Não esta logado! voltar para o login
            return "redirect:/login";
        }

        List<ProdutoDto> produtoDto = service.obterProdutos();
        model.addAttribute("produtoDto",produtoDto);

        return "produtolista";
    }


}
