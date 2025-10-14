package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    //--Método para cadastrar produto a partir da tela de login
    @PostMapping
    public String adicionar(@ModelAttribute("produtoDto") ProdutoDto produtoDto){

        boolean retorno = service.adicionar(produtoDto);

        if (retorno){
            return "redirect:/produtolista";
        }

        return "redirect:/produtocadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("produtoDto") ProdutoDto produtoDto, @PathVariable Long id){

        boolean retorno = false;

        retorno = service.atualizar(id, produtoDto);

        if(retorno) {
            return "redirect:/produtolista";
        }

        return "redirect:/produtoatualizar/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = service.remover(id);

        if (retorno) {
            return ResponseEntity.ok().body("deu certo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não deu certo");
        }
    }

}
