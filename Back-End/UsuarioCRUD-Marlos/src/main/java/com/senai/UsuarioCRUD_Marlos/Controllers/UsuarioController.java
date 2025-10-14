package com.senai.UsuarioCRUD_Marlos.Controllers;




import com.senai.UsuarioCRUD_Marlos.Dtos.RequisicaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RespostaDto;
import com.senai.UsuarioCRUD_Marlos.Models.UsuarioModel;
import com.senai.UsuarioCRUD_Marlos.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController @RequestMapping("/crud")
public class UsuarioController {

    private final UsuarioService usuarioService;
    UsuarioService service;

    public  UsuarioController(UsuarioService service, UsuarioService usuarioService){
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario")
   public ResponseEntity<RespostaDto> cadastro (@RequestBody RequisicaoDto dados){

       RespostaDto resultado = service.adicionarUsuario(dados);

           resultado.setNome(dados.getNome());
           resultado.setMsg(resultado.getMsg());

           return ResponseEntity.ok().body(resultado);
    }

    //Como se trata de deletar um usuário e o parametro para isso é o id eu passo ele via pathvariable = URL
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluirUsuario(@PathVariable (value = "id") Integer id){
       RespostaDto resultado = service.excluirUsuario(id);
       return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/listagem")
    public ResponseEntity<List<RespostaDto>> listandoUsuario(){
        List<RespostaDto> listagem = service.listaUsuarios();
        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDto> buscarUsuario(@PathVariable (value = "id")int id){
        RespostaDto resposta = service.buscaUsuario(id);
        return ResponseEntity.ok().body(resposta);
    }









}
