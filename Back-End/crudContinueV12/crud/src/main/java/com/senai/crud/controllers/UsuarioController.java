package com.senai.crud.controllers;

import com.senai.crud.dtos.RequisicaoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.dtos.UsuarioDto;
import com.senai.crud.services.UsuarioService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    //--Injeção de dependencia
    private final UsuarioService service;

    //--Construtor
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto usuarioDto){

        RespostaDto mensagem = service.cadastrar(usuarioDto);

        return "redirect:/usuariolista";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("usuarioDto") UsuarioDto usuarioDto, @PathVariable Long id){

        service.atualizar(id, usuarioDto);

        return "redirect:/usuariolista";
    }

    //--Excluir usuário DELETE http://localhost:8080/usuario/1
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){

        RespostaDto resposta = service.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("usuário excluido com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }

}
