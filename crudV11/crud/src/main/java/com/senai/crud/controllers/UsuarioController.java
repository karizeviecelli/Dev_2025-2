package com.senai.crud.controllers;

import com.senai.crud.dtos.*;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    //--Método para cadastrar usuário a partir da tela de login
    @PostMapping
    public String realizarCadastro(@ModelAttribute("requestDto") RequestDto requestDto){

        MensagemDto messagem = service.adicionarUsuario(requestDto);

        if (messagem.isSucesso()){
            return "redirect:/cadastro?sucesso";
        }

        return "redirect:/cadastro?erro";
    }

    //--Método para cadastar a partir da tela de lista de usuário
    @PostMapping("/novo")
    public String cadastrar(@ModelAttribute("requestDto") RequestDto requestDto){

        MensagemDto mensagem = service.adicionarUsuario(requestDto);

        if (mensagem.isSucesso()) {
            return "redirect:/usuariolista";
        }

        return "redirect:/usuariocadastro?erro";
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("usuarioAtualizarDto") UsuarioAtualizarDto usuarioDto, @PathVariable Long id, RedirectAttributes redirectAttributes){

        boolean retorno = false;

        try {
            retorno = service.atualizarUsuario(id, usuarioDto);
        } catch (InvalidOperationException ex) {
            redirectAttributes.addFlashAttribute("erro", ex.getMessage());
            return "redirect:/usuarioatualizar/" + id;
        }

        if(retorno) {
            return "redirect:/usuariolista";
        }

        System.out.println("vai para atualizar");

        return "redirect:/usuarioatualizar/" + id.toString() + "?erro";


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDto> excluir(@PathVariable Long id){

        MensagemDto mensagem = service.removerUsuario(id);

        if(mensagem.isSucesso()) {
            return ResponseEntity.ok().body(mensagem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }

    }

}
