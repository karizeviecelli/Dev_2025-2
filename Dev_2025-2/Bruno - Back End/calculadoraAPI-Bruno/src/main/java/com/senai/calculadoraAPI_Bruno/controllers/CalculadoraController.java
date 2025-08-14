package com.senai.calculadoraAPI_Bruno.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Função de componente do spring para uma implementação de webservice*//
@RequestMapping("/calc") //Cria a rota de acesso  para os métodos da clase
public class CalculadoraController {

    //-- http:localhost:8080/calc/somar/5/16
    @PostMapping("/somar/{n1}/{n2}")
    public ResponseEntity<Double> somar(@PathVariable Double n1, @PathVariable Double n2){
        Double resultado = n1+n2;
        return ResponseEntity.ok(resultado);
    }

   //--  http:localhost:8080/calc/subtrair/5/16
    @PostMapping("/subtrair/{n1}/{n2}")
    public ResponseEntity<Double> subtrair(@PathVariable Double n1, @PathVariable Double n2){
        Double resultadoSubtr = n1-n2;
        return ResponseEntity.ok(resultadoSubtr);
    }

    //--  http:localhost:8080/calc/dividir/5/16
    @PostMapping("/dividir/{n1}/{n2}")
    public ResponseEntity<Double> dividir(@PathVariable Double n1, @PathVariable Double n2){
        Double resultadoDiv = n1/n2;
        return ResponseEntity.ok(resultadoDiv);
    }


    //-- http:localhost:8080/calc/multiplic/5/16
    @PostMapping("/multiplic/{n1}/{n2}")
    public ResponseEntity<Double> multiplic(@PathVariable  Double n1, @PathVariable Double n2){
      Double resultadoMult = n1*n2;
      return ResponseEntity.ok(resultadoMult);
    };


}
