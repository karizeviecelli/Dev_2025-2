package com.senai.crud.controllers;

import com.senai.crud.dtos.CategoriaDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class APICategoriaController {


    //-- Injeção eletrônica
    private final CategoriaService categoriaService;

    public APICategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }


    //--Criar usuário POST http://localhost:8080/crud/categoria

}
