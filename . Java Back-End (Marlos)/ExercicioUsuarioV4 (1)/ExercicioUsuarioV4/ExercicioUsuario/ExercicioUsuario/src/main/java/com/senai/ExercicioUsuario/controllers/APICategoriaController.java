package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.CategoriaRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class APICategoriaController {

    private CategoriaService categoriaService;

    public APICategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    //Post cadastrar nova categoria
    @PostMapping("/cadastrarCategoria")
    public ResponseEntity<MensagemDto> cadastrarCategoria(@RequestBody CategoriaRequisicaoDto nome) {
        MensagemDto mensagem = categoriaService.cadastrarCategoria(nome);
        if (mensagem.getMensagemUsuario().equals("Esse nome de categoria já existe")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
        return ResponseEntity.ok().body(mensagem);
    }

    //get listar todas as categorias
    @GetMapping("/listarCategoria")
    public ResponseEntity<List<CategoriaRespostaDto>> listarCategorias() {
        List<CategoriaRespostaDto> listaCategoria = categoriaService.listaCategorias();
        return ResponseEntity.ok().body(listaCategoria);
    }

    @DeleteMapping("/deletarCategoria/{id}")
    public ResponseEntity<MensagemDto> deletarCategoria (@PathVariable (value = "id") Long id){
        MensagemDto msg = categoriaService.deletarCategoria(id);
        if (msg.getMensagemUsuario().equals("Categoria deletada com sucesso")){
            return ResponseEntity.ok().body(msg);
        }else {
            return  ResponseEntity.ok().body(msg);
        }

    }
}
