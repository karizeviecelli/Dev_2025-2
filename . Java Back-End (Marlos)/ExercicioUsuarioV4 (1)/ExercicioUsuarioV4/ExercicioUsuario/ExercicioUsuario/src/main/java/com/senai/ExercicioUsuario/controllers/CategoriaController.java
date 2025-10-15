package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/categoria")
    public String cadastrar(@ModelAttribute("categoriaDto") CategoriaRequisicaoDto dados){

        categoriaService.cadastrarCategoria(dados);

        return "redirect:/categorialista";
    }

    @PostMapping("/categoria/{id}")
    public String atualizar(@ModelAttribute("categoriaDto") CategoriaRequisicaoDto dados, @PathVariable Long id){

        categoriaService.atualizarCategoria(dados, id);

        return "redirect:/categorialista";

    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<MensagemDto> deletarCategoria (@PathVariable (value = "id") Long id) {
        MensagemDto msg = categoriaService.deletarCategoria(id);
        if (msg.getMensagemUsuario().equals("Categoria deletada com sucesso")) {
            return ResponseEntity.ok().body(msg);
        } else {
            return ResponseEntity.ok().body(msg);
        }
    }
}
