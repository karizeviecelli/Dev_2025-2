package com.senai.UsuarioCRUD_Marlos.Controllers;

import com.senai.UsuarioCRUD_Marlos.Dtos.CategoriaDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.MsgDto;
import com.senai.UsuarioCRUD_Marlos.Models.UsuarioModel;
import com.senai.UsuarioCRUD_Marlos.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    private final UsuarioService usuarioService;
    public CategoriaController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastraCategoria")
   public ResponseEntity<MsgDto> cadastroCategoria (@RequestBody CategoriaDto dados){
        MsgDto msg = usuarioService.adicionarCategoria(dados);
        return ResponseEntity.ok().body(msg);
    }

    @GetMapping("/listarCategoria")
    public  ResponseEntity <List<CategoriaDto>>ListarCategorias(){
        List<CategoriaDto> lista = usuarioService.listaDeCategorias();
       return ResponseEntity.ok().body(lista);
    }
}
