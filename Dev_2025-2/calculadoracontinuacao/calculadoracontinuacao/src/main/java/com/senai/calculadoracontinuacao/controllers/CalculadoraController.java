package com.senai.calculadoracontinuacao.controllers;


import com.senai.calculadoracontinuacao.dtos.*; //* Chama todas as classes de determinado package AJUDAMUITO
import com.senai.calculadoracontinuacao.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//Anotação nescessária para transforma-la em um componente, a maioria é componente menos dto
@RestController
// Possibilita a criação de rota para acessar a classe, depois se torna o caminho para minha requisição
@RequestMapping("/calc")
public class CalculadoraController {


CalculadoraService service;

    //INJEÇÃO DE DEPÊNDENCIA
    public CalculadoraController (CalculadoraService service){
        this.service = service;
    }

    //Não pode haver rotas duplicada tipo: http://localhost/:8080/calc/somar e http://localhost/:8080/calc/somar da erro
    //http://localhost/:8080/calc/somar = a rota nescessária para poder chegar ao metodo
    // Tipo de retorno - ResponseEntity<Dentro vai o dto> //ResquestBody - é o corpo da requisição, chama os atributos criados nos dtos
    @PostMapping("/somar")
    public ResponseEntity<SaidaDto>somar(@RequestBody EntradaDto dados ) {
        SaidaDto resultado = service.somar(dados);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/subtrair")
    public  ResponseEntity<SaidaDto>subtrair(@RequestBody  EntradaDto dados){
        SaidaDto resultado = service.subtrair(dados);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/multiplicar")
    public  ResponseEntity<SaidaDto>multiplicar(@RequestBody EntradaDto dados){
        SaidaDto resultado =service.multiplicar(dados);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping("/dividir")
    public ResponseEntity<SaidaDto>dividir(@RequestBody EntradaDto dados){
        SaidaDto resultado = service.dividir(dados);
        return ResponseEntity.ok().body(resultado);
    }



}
