package com.senai.ExercicioUsuario.controllers;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.services.UsuarioService;
import org.apache.coyote.Response;
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

    //Resumo dos métodos http:
    //POST - Criar usuario: /crud/usuario
    //PUT - Editar usuario: /crud/usuario/{id}
    //GET - Listar usuario por ID: /crud/usuario/{id}
    //GET - Listar todos os usuarios: /crud/usuarios
    //DELETE - Deletar um usuario: /crud/usuario/{id}

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
    public ResponseEntity<Object> buscaUsuarioPorId(@PathVariable int id){
        Object respostaDto = usuarioService.buscarUsuarioId(id);
        if(respostaDto instanceof RespostaDto){
            return ResponseEntity.ok().body(respostaDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaDto);
    }

    //atualiza usuario por id
    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemDto> atualizarUsuario(@PathVariable(value = "id") int id, @RequestBody RequisicaoDto dados){
        MensagemDto mensagem = usuarioService.alterarUsuario(id, dados);
        return ResponseEntity.ok().body(mensagem);
    }

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
