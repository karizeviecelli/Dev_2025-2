package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoCadastraController {

    @GetMapping("/produtocadastra")
    public String produtocadastra(Model model){ //Passa o model como parâmetro para cadastro
        ProdutoDto produtoDto = new ProdutoDto(); //cria um produtodto para mandar os valores para o back/service
        model.addAttribute("produtoDto",produtoDto); //adiciona e guarda os valores
        return "produtocadastra"; // retorna o html de cadastro de produto
    }


}
