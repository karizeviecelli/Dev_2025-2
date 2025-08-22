package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class UsuarioController {
    private final UsuarioService usuarioService;

    //faz a injeção de dependência
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
    public ResponseEntity<MensagemDto> adicionarUsuario(@RequestBody RequisicaoDto dados){
        MensagemDto mensagemDto = usuarioService.adicionarUsuario(dados);;
        if (mensagemDto.getMensagemUsuario().equals("Login já existente")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemDto);
        } else {
            return ResponseEntity.ok().body(mensagemDto);
        }

    }

    //lista todos os usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<RespostaDto>> listaUsuarios(){
        List<RespostaDto> listaUsuarios = usuarioService.listaUsuarios();
        return ResponseEntity.ok(listaUsuarios);
    }

    //busca usuario por id
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> buscaUsuarioPorId(@PathVariable(value = "id")int id){
        Object object = usuarioService.buscarUsuarioId(id);
        if(object == "Usuário não encontrado"){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(object);
        }
        return ResponseEntity.ok().body(object);
    }

    //atualiza usuario por id


    //remove usuario
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> removeUsuario(@PathVariable(value = "id") int id){
        MensagemDto mensagemDto = usuarioService.deletarUsuario(id);
        if (mensagemDto.getMensagemUsuario().equals("Usuario deletado com sucesso")){
            return ResponseEntity.ok().body(mensagemDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemDto);
    }

}
