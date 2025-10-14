package com.senai.UsuarioCRUD_Marlos.Controllers;

import com.senai.UsuarioCRUD_Marlos.Dtos.MsgDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.ProdutoDto;
import com.senai.UsuarioCRUD_Marlos.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final UsuarioService usuarioService;

    public ProdutoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/CadastraProduto")
    ResponseEntity<MsgDto> cadastraProduto(@RequestBody ProdutoDto dados){

    }

}
