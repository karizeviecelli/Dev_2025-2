package com.senai.calculadoracontinuacao.services;


import com.senai.calculadoracontinuacao.dtos.EntradaDto;
import com.senai.calculadoracontinuacao.dtos.SaidaDto;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public SaidaDto somar (EntradaDto dados){
        // Criar objeto do tipo saida DTO
        SaidaDto resultado = new SaidaDto();
        resultado.setN1(dados.getN1());
        resultado.setN2(dados.getN2());
        resultado.setResultado(dados.getN1()+dados.getN2());
        return resultado;

    }

    public SaidaDto subtrair (EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setN1(dados.getN1());
        resultado.setN2(dados.getN2());
        resultado.setResultado(dados.getN1()- dados.getN2());
        return resultado;
    }

    public SaidaDto dividir (EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setN1(dados.getN1());
        resultado.setN2(dados.getN2());
        resultado.setResultado(dados.getN1()/dados.getN2());
        return  resultado;
    }

    public SaidaDto multiplicar (EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setN1(dados.getN1());
        resultado.setN2(dados.getN2());
        resultado.setResultado(dados.getN1()* dados.getN2());
        return resultado;
    }



}
