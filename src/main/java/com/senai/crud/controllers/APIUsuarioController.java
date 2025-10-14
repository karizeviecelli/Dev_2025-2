package com.senai.crud.controllers;

import com.senai.crud.services.UsuarioService;
import com.senai.crud.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
CLASSE QUE ATENDENDE A IMPLEMENTAÇÂO DE API REST
PARA CONSUMIR É NECESSÁRIO USAR O POSTMAN / THUNDERCLIENT
 */

@RestController
@RequestMapping("/crud")
public class APIUsuarioController {

    //--Injeção de dependencia
    private final UsuarioService servico;

    public APIUsuarioController(UsuarioService servico) {
        this.servico = servico;
    }

    //--Criar usuário POST http://localhost:8080/crud/usuario
    @PostMapping("/usuario")
    public ResponseEntity<RespostaDto> cadastrar(@RequestBody RequisicaoDto usuarioDto){

        RespostaDto resposta = servico.cadastrar(usuarioDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("usuário cadastrado com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(resposta);
        }

    }

    //--Excluir usuário DELETE http://localhost:8080/crud/usuario/1
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){

        RespostaDto resposta = servico.excluir(id);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("usuário excluido com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

    }

    //--Atualizar usuário PUT http://localhost:8080/crud/usuario/1
    @PutMapping("/usuario/{id}")
    public ResponseEntity<RespostaDto> atualizar(@PathVariable Long id, @RequestBody RequisicaoDto usuarioDto){

        RespostaDto resposta = servico.atualizar(id,usuarioDto);

        if (resposta.getMensagem().equals("sucesso")) {
            resposta.setMensagem("usuário atualizado com sucesso");
            return ResponseEntity.ok().body(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }

    //--consultar um único usuário GET http://localhost:8080/crud/usuario/1
    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDto> obterUsuario(@PathVariable Long id){

        return ResponseEntity.ok().body(servico.obterUsuario(id));
    }

    //--consultar todos os usuários GET http://localhost:8080/crud/usuarios
    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> obterUsuarios(){
        return ResponseEntity.ok().body(servico.obterUsuarios());
    }
}
