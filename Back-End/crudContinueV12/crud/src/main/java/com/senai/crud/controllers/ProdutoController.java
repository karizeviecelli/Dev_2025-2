package com.senai.crud.controllers;

import com.senai.crud.dtos.ProdutoDto;
import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.ProdutoService;
import com.senai.crud.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    //--Injeção de dependencia
    private final ProdutoService service;

    //--Construtor
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("produtoDto") ProdutoDto produtoDto) {

        RespostaDto mensagem = service.cadastrar(produtoDto);

        return "redirect:/produtolista";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("produtoDto") ProdutoDto prorodutoDto, @PathVariable Long id) {

        service.atualizar(id, prorodutoDto);

        return "redirect:/produtolista";
    }

    //--Excluir usuário DELETE http://localhost:8080/uroduto/1
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id) {

        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("Produto excluido com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }
}
