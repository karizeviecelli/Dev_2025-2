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
    @PostMapping("/somar")
    public ResponseEntity<SaidaDto> somar(@RequestBody EntradaDto numeros){
        //instancia um objeto do tipo SaidaDto
        SaidaDto resultado = new SaidaDto();
        //faz a soma dos numeros que vem da EntradDto e coloca dentro do atributo resultado da classe SaidaDto
        resultado.setResultado(numeros.getN1() + numeros.getN2());
        //Colocando os valores para devolver na corpo de retorno do JSON
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());
        //retorna a SaidaDto
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/subtrair")
    public ResponseEntity<SaidaDto> subtrair(@RequestBody EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();

        resultado.setResultado(numeros.getN1() - numeros.getN2());
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());

        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<SaidaDto> multiplicar(@RequestBody EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();

        resultado.setResultado(numeros.getN1()+ numeros.getN2());
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());

        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/dividir")
    public ResponseEntity<SaidaDto> dividir(@RequestBody EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();

        resultado.setResultado(numeros.getN1() / numeros.getN2());
        resultado.setN1(numeros.getN1());
        resultado.setN2(numeros.getN2());

        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/somarS")
    public ResponseEntity<SaidaDto> somarService(@RequestBody EntradaDto numeros){
        SaidaDto resultado = service.somar(numeros);
        return ResponseEntity.ok().body(resultado);
    }

}
