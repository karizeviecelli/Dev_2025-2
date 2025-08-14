package com.senai.CalculadoraSolo.Controllers;


import com.senai.CalculadoraSolo.Dtos.EntradaDto;
import com.senai.CalculadoraSolo.Dtos.ResultadoDto;
import com.senai.CalculadoraSolo.Services.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    CalculadoraService service;

    public CalculadoraController (CalculadoraService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResultadoDto> calculadora(@RequestBody EntradaDto dados){
            ResultadoDto resultado = service.calculadora(dados);
            return ResponseEntity.ok().body(resultado);
    }



}
