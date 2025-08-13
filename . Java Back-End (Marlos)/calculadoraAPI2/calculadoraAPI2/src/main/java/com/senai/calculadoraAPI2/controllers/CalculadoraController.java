package com.senai.calculadoraAPI2.controllers;

import com.senai.calculadoraAPI2.dtos.CalculadoraDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/calc")
public class CalculadoraController {

    @PostMapping("/somar")
    public ResponseEntity<CalculadoraDto> somar(@RequestBody CalculadoraDto calc){
        calc.setResultado(calc.getNum1() + calc.getNum2());
        return ResponseEntity.ok(calc);
    }

    @PostMapping("/subtrair")
    public ResponseEntity<CalculadoraDto> subtrair(@RequestBody CalculadoraDto calc){
        calc.setResultado(calc.getNum1() - calc.getNum2());
        return ResponseEntity.ok(calc);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<CalculadoraDto> multiplicar(@RequestBody CalculadoraDto calc){
        calc.setResultado(calc.getNum1() * calc.getNum2());
        return ResponseEntity.ok(calc);
    }

    @PostMapping("/dividir")
    public ResponseEntity<CalculadoraDto> dividir(@RequestBody CalculadoraDto calc){
        calc.setResultado(calc.getNum1() / calc.getNum2());
        return ResponseEntity.ok(calc);
    }
}

