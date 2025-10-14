package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    //--Criar categoria POST http://localhost:8080/crud/categoria
    @PostMapping
    public ResponseEntity<RespostaDto> cadastrar(@RequestBody CategoriaDto categoriaDto){

        RespostaDto resposta = service.cadastrar(categoriaDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Categoria cadastrada com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
        }

    }

    //--Excluir categoria DELETE http://localhost:8080/crud/categoria/1
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){

        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Categoria excluida com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }

    //--Atualizar categoria PUT http://localhost:8080/crud/categoria/1
    @PutMapping("/{id}")
    public ResponseEntity<RespostaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto){

        RespostaDto resposta = service.atualizar(id,categoriaDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Categoria atualizada com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    //--consultar uma única categoria GET http://localhost:8080/crud/categoria/1
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> obterCategoria(@PathVariable Long id){

        return ResponseEntity.ok().body(service.obterCategoria(id));
    }

    //--consultar todas as categorias GET http://localhost:8080/crud/categoria
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> obterCategorias(){
        return ResponseEntity.ok().body(service.obterCategorias());
    }

}
