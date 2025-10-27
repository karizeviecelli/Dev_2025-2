package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.ContatoDto;
import com.senai.ExercicioUsuario.services.ContatoService;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping("/contato")
    public String cadastrar(@ModelAttribute("contatoDto")ContatoDto dados){

        contatoService.cadastrarContato(dados);

        return "redirect:/contatolista";
    }

    @PostMapping("/contato/{id}")
    public String atualziar(@ModelAttribute("contatoDto")ContatoDto dados, @PathVariable Long id){

        contatoService.atualizaContato(id,dados);

        return "redirect:/contatolista";

    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Boolean> deleter(@PathVariable Long id){
        Boolean a = contatoService.excluirContato(id);
        return ResponseEntity.ok().body(a);
    }

}
