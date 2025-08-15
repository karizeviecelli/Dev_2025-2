package com.senai.calculadora.controllers;

import com.senai.calculadora.dtos.*;
import com.senai.calculadora.services.CalculadoraService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculadoraController {

    CalculadoraService service;

    //Serve para fazer a injeção de dependência entre o controller e o service
    public CalculadoraController(CalculadoraService service){
        this.service = service;
    }

    //-- POST http://localhost:8080/calc/somar

    @PostMapping("/somarS")
    public ResponseEntity<SaidaDto> somarService(@RequestBody EntradaDto numeros){
        SaidaDto resultado = service.somar(numeros);
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/subtrair")
    public ResponseEntity<SaidaDto> subtrair(@RequestBody EntradaDto numeros){
        SaidaDto resultado = service.subtrair(numeros);
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/dividir")
    public ResponseEntity<SaidaDto> dividir(@RequestBody EntradaDto numeros){
        SaidaDto resultado = service.dividir(numeros);
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<SaidaDto> multiplicar(@RequestBody EntradaDto numeros){
        SaidaDto resultado = service.multiplicar(numeros);
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());
        return ResponseEntity.ok().body(resultado);
    }

}
