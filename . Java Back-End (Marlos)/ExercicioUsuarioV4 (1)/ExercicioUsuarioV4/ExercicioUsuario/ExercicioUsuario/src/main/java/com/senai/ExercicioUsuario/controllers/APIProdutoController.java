package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class APIProdutoController {

    private ProdutoService produtoService;

    public APIProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Post cadastrar novo produto
    @PostMapping("/cadastrarProduto")
    public  ResponseEntity<MensagemDto> cadastrarProduto(@RequestBody ProdutoRequisicaoDto nome){
        MensagemDto msg = produtoService.cadastrarProduto(nome);
        return ResponseEntity.ok().body(msg);
    }

    @GetMapping("/listarProduto")
    public  ResponseEntity<List<ProdutoRespostaDto>> listarProdutos(){
        List<ProdutoRespostaDto> listarProdutos = produtoService.listarProdutos();
        return ResponseEntity.ok().body(listarProdutos);
    }

    @DeleteMapping("/deletarCategoria/{id}")
    public ResponseEntity<MensagemDto> deletarProduto (@PathVariable (value = "id") Long id){
        MensagemDto msg = produtoService.deletarProduto(id);
        return ResponseEntity.ok().body(msg);
    }

    //atualiza usuario por id
    @PutMapping("/produto/{id}")
    public ResponseEntity<MensagemDto> atualizarProduto(@PathVariable(value = "id") Long id, @RequestBody ProdutoRequisicaoDto dados) {
        MensagemDto mensagem = produtoService.alterarProduto(id, dados);
        return ResponseEntity.ok().body(mensagem);
    }

}