package com.senai.calculadoraAPI2.controllers;

import com.senai.calculadoraAPI2.dtos.CalculadoraDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculadoraController {
    CalculadoraDto resultado;

    @PostMapping("/somar")
    public ResponseEntity<CalculadoraDto> somar(@RequestBody CalculadoraDto calc){
        Double r = calc.getNum1()+ calc.getNum2();
        resultado.setResultado(r);
        return ResponseEntity.ok(resultado);
    }
}
