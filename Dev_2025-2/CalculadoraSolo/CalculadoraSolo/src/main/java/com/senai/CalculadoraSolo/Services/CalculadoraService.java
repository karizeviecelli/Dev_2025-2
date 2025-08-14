package com.senai.CalculadoraSolo.Services;



import com.senai.CalculadoraSolo.Dtos.EntradaDto;
import com.senai.CalculadoraSolo.Dtos.ResultadoDto;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {


    public ResultadoDto calculadora (EntradaDto dados){
        ResultadoDto resultado = new ResultadoDto();

        if (dados.getOperacao().equals("+")){

            resultado.setNumero1(dados.getNumero1());
            resultado.setNumero2(dados.getNumero2());
            resultado.setResultado(dados.getNumero1()+ dados.getNumero2());
            return resultado;

        } else if (dados.getOperacao().equals("-")) {

            resultado.setNumero1(dados.getNumero1());
            resultado.setNumero2(dados.getNumero2());
            resultado.setResultado(dados.getNumero1()- dados.getNumero1());
            return resultado;

        } else if (dados.getOperacao().equals("/")) {

            resultado.setNumero1(dados.getNumero1());
            resultado.setNumero2(dados.getNumero2());
            resultado.setResultado(dados.getNumero1()/dados.getNumero1());
            return resultado;

        } else if (dados.getOperacao().equals("*")) {

            resultado.setNumero1(dados.getNumero1());
            resultado.setNumero2(dados.getNumero2());
            resultado.setResultado(dados.getNumero1()*dados.getNumero1());
            resultado.setOperacao(dados.getOperacao());
            return resultado;
        }
        return null;
    }

}
