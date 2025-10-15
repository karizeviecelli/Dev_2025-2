package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public String cadastrar(@ModelAttribute("produtoDto")ProdutoRequisicaoDto dados){

        produtoService.cadastrarProduto(dados);

        return "redirect:/produtolista";
    }

    @PostMapping("/produto/{id}")
    public String atualizar(@ModelAttribute("produtoDto") ProdutoRequisicaoDto dados, @PathVariable Long id){

        produtoService.alterarProduto(id, dados);

        return "redirect:/produtolista";

    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<MensagemDto> deletarProduto (@PathVariable (value = "id") Long id){
        MensagemDto msg = produtoService.deletarProduto(id);
        return ResponseEntity.ok().body(msg);
    }
}
