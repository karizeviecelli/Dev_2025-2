package com.senai.UsuarioCRUD_Marlos.Controllers;



import com.senai.UsuarioCRUD_Marlos.Dtos.RequisicaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RespostaDto;
import com.senai.UsuarioCRUD_Marlos.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class UsuarioController {

    UsuarioService service;

    public  UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping("/usuario")
    public ResponseEntity<RespostaDto> cadastro (@RequestBody RequisicaoDto dados){


    }







}
