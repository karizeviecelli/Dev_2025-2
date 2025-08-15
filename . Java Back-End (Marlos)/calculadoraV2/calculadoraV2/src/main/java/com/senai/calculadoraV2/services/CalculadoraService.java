package com.senai.calculadoraV2.services;

import com.senai.calculadoraV2.dtos.EntradaDto;
import com.senai.calculadoraV2.dtos.SaidaDto;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public SaidaDto operacaoMatematica(EntradaDto dados){
        if (dados.getOperacao().equals("+")){
            return somar(dados);
        } else if(dados.getOperacao().equals("-")){
            return subtrair(dados);
        } else if(dados.getOperacao().equals("*")){
            return multiplicar(dados);
        } else if(dados.getOperacao().equals("/")){
            if (dados.getNumero2()==0){
                divisaoZero(dados);
            } else {
                return dividir(dados);
            }
        } else if(dados.getOperacao().equals("%")){
            return modulo(dados);
        } else if(dados.getOperacao().equals("^")){
            return potencia(dados);
        }
        else {
            //método de devolver 0 no resultado
            return erro(dados);
        }
        return null;
    }

    public SaidaDto somar(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(dados.getNumero1() + dados.getNumero2());
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto subtrair(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(dados.getNumero1() - dados.getNumero2());
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto multiplicar(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(dados.getNumero1() * dados.getNumero2());
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto dividir(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(dados.getNumero1() / dados.getNumero2());
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto modulo(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(dados.getNumero1() % dados.getNumero2());
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto potencia(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(Math.pow(dados.getNumero1(), dados.getNumero2()));
        resultado.setOperacao(dados.getOperacao());
        resultado.setNumero1(dados.getNumero1());
        resultado.setNumero2(dados.getNumero2());
        return resultado;
    }

    public SaidaDto erro(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(0);
        resultado.setNumero1(0);
        resultado.setNumero2(0);
        resultado.setOperacao("Use uma das operações válidas: + - / * % ^");
        return resultado;
    }

    public SaidaDto divisaoZero(EntradaDto dados){
        SaidaDto resultado = new SaidaDto();
        resultado.setResultado(0);
        resultado.setOperacao("Não pode dividir por zero");
        resultado.setNumero1(0);
        resultado.setNumero2(0);
        return resultado;
    }
}
