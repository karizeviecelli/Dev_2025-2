package com.senai.UsuarioCRUD_Marlos.Controllers;


import com.senai.UsuarioCRUD_Marlos.Dtos.AuthenticacaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.MsgDto;
import com.senai.UsuarioCRUD_Marlos.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Authentica")
public class AuthenticacaoController {

    private final UsuarioService usuarioService;


    public AuthenticacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/loginAuthentic")
    public ResponseEntity<MsgDto> validacaoLogin (@RequestBody AuthenticacaoDto dados){

        MsgDto msg = usuarioService.autLogin(dados);
        return ResponseEntity.ok().body(msg);

    }

}
