package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    //--Injeção de dependencia
    private final CategoriaService service;

    //--Construtor
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto) {

        RespostaDto mensagem = service.cadastrar(categoriaDto);

        return "redirect:/categorialista";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaDto prorodutoDto, @PathVariable Long id) {

        service.atualizar(id, prorodutoDto);

        return "redirect:/categorialista";
    }

    //--Excluir usuário DELETE http://localhost:8080/categoria/1
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id) {

        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Categoria excluida com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }
    
}
