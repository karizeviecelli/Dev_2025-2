package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.ProdutoRespostaDto;
import com.senai.ExercicioUsuario.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    //Post cadastrar novo produto
    @PostMapping
    public ResponseEntity<MensagemDto> cadastrarProduto(@RequestBody ProdutoRequisicaoDto dados) {
        MensagemDto mensagem = produtoService.cadastrarProduto(dados);
        if (mensagem.getMensagemUsuario().equals("Produto com esse nome já cadastrado!")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        } else if (mensagem.getMensagemUsuario().equals("Esse Id não corresponde a nenhuma categoria!")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok().body(mensagem);
    }

    //Get listar TODOS os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDto>> listarProdutos() {
        List<ProdutoRespostaDto> listaProduto = produtoService.listarProdutos();
        return ResponseEntity.ok().body(listaProduto);
    }

    //Get Listar todos os produtos por determinada categoria
   // @GetMapping("/{id}")
   // public ResponseEntity<ProdutoRespostaDto> listaProdutoPorId(@PathVariable(value = "id") Long id) {
       // ProdutoRespostaDto resposta = produtoService.listaProdutoPorId(id);
//if (resposta.getNome() == null){
//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
       // }
     //   return ResponseEntity.ok().body(resposta);
    }

