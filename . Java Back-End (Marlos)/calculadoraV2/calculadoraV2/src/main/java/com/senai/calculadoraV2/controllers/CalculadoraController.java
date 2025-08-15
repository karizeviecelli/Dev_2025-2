package com.senai.calculadoraV2.controllers;

import com.senai.calculadoraV2.dtos.*;
import com.senai.calculadoraV2.services.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    CalculadoraService service;

    public CalculadoraController(CalculadoraService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SaidaDto> calculadora(@RequestBody EntradaDto numeros){
        return ResponseEntity.ok().body(service.operacaoMatematica(numeros));
    }
}
