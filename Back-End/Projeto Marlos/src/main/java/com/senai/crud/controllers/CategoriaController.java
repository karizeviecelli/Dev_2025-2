package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    // INJEÇÃO DE DEPENDECE
    private final CategoriaService categoriaService;

    //Construtor
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
        }

        @PostMapping("/categoriacadastra")
        public String cadastrarCategoria (@ModelAttribute("categoriaDto") CategoriaDto categoriaDto){
        categoriaService.cadastrar(categoriaDto);
        return "redirect:/categorialista";

        }


    @PostMapping("/categoria/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaDto categoriaDto, @PathVariable Long id){

        categoriaService.atualizar(id,categoriaDto);

        return "redirect:/categorialista";

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){

        RespostaDto resposta = categoriaService.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Categoria excluída com sucesso.");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }
}
