package com.senai.ConversorGraus.controllers;


import com.senai.ConversorGraus.dtos.EntradaDto;
import com.senai.ConversorGraus.dtos.SaidaDto;
import com.senai.ConversorGraus.services.ConversorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConversorController {

    ConversorService service;

    public ConversorController(ConversorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SaidaDto> conversor(@RequestBody EntradaDto dados){
            SaidaDto result = service.converter(dados);
            return ResponseEntity.ok().body(result);
    }

}
