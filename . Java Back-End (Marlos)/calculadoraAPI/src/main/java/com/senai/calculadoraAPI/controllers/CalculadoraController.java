package com.senai.calculadoraAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //-- função de componente do spring para uma implementação de webservice
@RequestMapping("/calc") //-- cria a rota de acesso para métodos da classe
public class CalculadoraController {

    //-- http://localhost:8080/calc/somar
    @PostMapping("/somar/{n1}/{n2}")
    public ResponseEntity<Double> somar(@PathVariable Double n1,@PathVariable Double n2) {
        return ResponseEntity.ok(n1 + n2);
    }
    //-- http://localhost:8080/calc/subtrair
    @PostMapping("/subtrair/{n1}/{n2}")
    public ResponseEntity<Double> divir(@PathVariable Double n1,@PathVariable Double n2){
        return ResponseEntity.ok(n1-n2);
    }
    //-- http://localhost:8080/calc/multiplicar
    @PostMapping("/multiplicar/{n1}/{n2}")
    public ResponseEntity<Double> multiplicar(@PathVariable Double n1,@PathVariable Double n2){
        return ResponseEntity.ok(n1*n2);
    }
    //-- http://localhost:8080/calc/dividir
    @PostMapping("/dividir/{n1}/{n2}")
    public ResponseEntity<Double> dividir(@PathVariable Double n1,@PathVariable Double n2){
        return ResponseEntity.ok(n1/n2);
    }


}
