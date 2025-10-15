package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.dtos.RequisicaoDto;
import com.senai.ExercicioUsuario.dtos.RespostaDto;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public String cadastrar(@ModelAttribute("usuarioDto") RequisicaoDto dados){

        usuarioService.adicionarUsuario(dados);

        return "redirect:/usuariolista";
    }

    @PostMapping("/usuario/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("usuarioDto") RespostaDto dados){

        usuarioService.alterarUsuario(id,dados);

        return "redirect:/usuariolista";
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> removeUsuario (@PathVariable(value = "id") Long id) {
        MensagemDto mensagemDto = usuarioService.deletarUsuario(id);
        if (mensagemDto.getMensagemUsuario().equals("Usuario deletado com sucesso")) {
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }

}
