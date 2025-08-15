package com.senai.conversorV1.controllers;

import com.senai.conversorV1.dtos.RequisicaoDto;
import com.senai.conversorV1.dtos.RespostaDto;
import com.senai.conversorV1.services.ConversorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversor")
public class ConversorController {
    ConversorService service;

    public ConversorController(ConversorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> conversor(@RequestBody RequisicaoDto dados){
        Object resultado = service.converter(dados);
        return ResponseEntity.ok().body(resultado);
    }
}
