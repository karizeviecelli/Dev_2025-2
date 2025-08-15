package com.senai.calculadora.services;

import com.senai.calculadora.dtos.EntradaDto;
import com.senai.calculadora.dtos.SaidaDto;
import org.springframework.stereotype.*;

@Service
public class CalculadoraService {

    public SaidaDto somar(EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(numeros.getN1()+numeros.getN2());
        return  resultado;
    }

    public SaidaDto subtrair(EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(numeros.getN1() - numeros.getN2());
        return resultado;
    }

    public SaidaDto dividir(EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(numeros.getN1() / numeros.getN2());
        return resultado;
    }

    public SaidaDto multiplicar(EntradaDto numeros){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(numeros.getN1() * numeros.getN2());
        return resultado;
    }

}
