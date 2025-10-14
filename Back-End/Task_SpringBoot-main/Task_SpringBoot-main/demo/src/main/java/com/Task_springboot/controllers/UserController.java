package com.Task_springboot.controllers;

import com.Task_springboot.dtos.MensagemDTO;
import com.Task_springboot.dtos.UserDTO;
import com.Task_springboot.models.UserModel;
import com.Task_springboot.services.UserService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UserController {
    //Injeção de depêndencia - CHECK
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/inseriUsuario")
    public ResponseEntity<MensagemDTO> inseriUsuario(@RequestBody @Valid UserDTO userDados){

        MensagemDTO msg = service.inseriUsuario(userDados);

        if(msg.getMsg().equals("Sucesso!")){
            msg.setMsg("Usuário Inserido com sucesso!");
            return ResponseEntity.ok().body(msg);
        }else{
            msg.setMsg("Usuário já existente!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(msg);
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<MensagemDTO> deletandoUsuario (@PathVariable @Valid UserDTO userDados){

        MensagemDTO msg = service.excluir(userDados);

        if (msg.getMsg().equals("Usuário vinculado a tarefa!")){
            msg.setMsg("Usuário vinculado a tarefa!\n Não é possível realizar essa exclusão!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(msg);
        }
            if(msg.getMsg().equals("Usuário deletado!")){
            msg.setMsg("Usuário deletado com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
        }

            msg.setMsg("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @GetMapping("/listandoUsuario")
    public ResponseEntity<List<UserDTO>> obterUsuarios(){

        List<UserDTO> usariosLista = service.obtendoUsuarios();

        MensagemDTO msg = new MensagemDTO();

        if (usariosLista.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(usariosLista);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usariosLista);
    }


    //Atualizando Usuário
    @PutMapping("/atualizandoUsuario")
    public ResponseEntity <MensagemDTO> atualizandoUsuario(@PathVariable String email, @RequestBody @Valid UserModel userdados){

        MensagemDTO msg = new MensagemDTO();

        if (msg.equals("Usuário alterado com sucesso!")) {
            msg.setMsg("Usuário alterado com êxito!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(msg);
        }
        msg.setMsg("Usuário não existe!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);

    }


}








