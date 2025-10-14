package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    //--Método para cadastrar produto a partir da tela de login
    @PostMapping
    public String adicionar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto){

        boolean retorno = service.adicionar(categoriaDto);

        if (retorno){
            return "redirect:/categorialista";
        }

        return "redirect:/categoriacadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto, @PathVariable Long id){

        boolean retorno = false;

        retorno = service.atualizar(id, categoriaDto);

        if(retorno) {
            return "redirect:/categorialista";
        }

        return "redirect:/categoriaatualizar/" + id.toString() + "?erro";
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
