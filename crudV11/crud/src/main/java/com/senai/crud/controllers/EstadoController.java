package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.EstadoDto;
import com.senai.crud.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    //--Método para cadastrar produto a partir da tela de login
    @PostMapping
    public String adicionar(@ModelAttribute("estadoDto") EstadoDto estadoDto){

        boolean retorno = service.criarEstado(estadoDto);

        if (retorno){
            return "redirect:/estadolista";
        }

        return "redirect:/estadocadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("estadoDto") EstadoDto estadoDto, @PathVariable Long id){

        boolean retorno = false;

        retorno = service.atualizarEstado(id, estadoDto);

        if(retorno) {
            return "redirect:/estadolista";
        }

        return "redirect:/estadoatualizar/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {

        boolean retorno = service.excluirEstado(id);

        if (retorno) {
            return ResponseEntity.ok().body("deu certo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("não deu certo");
        }
    }

}
