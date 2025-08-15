package com.senai.conversorV1.services;

import com.senai.conversorV1.dtos.*;
import org.springframework.stereotype.Service;

//Comprimento
//cm-m → Centímetros para Metros (valor / 100)
//m-cm → Metros para Centímetros (valor * 100)
//Massa
//kg-g → Quilogramas para Gramas (valor * 1000)
//g-kg → Gramas para Quilogramas (valor / 1000)
//Temperatura
//c-f → Celsius para Fahrenheit ((valor * 9/5) + 32)
//f-c → Fahrenheit para Celsius ((valor - 32) * 5/9)
@Service
public class ConversorService {

    public Object converter(RequisicaoDto dados){
        RespostaDto resultado = new RespostaDto();

        resultado.setTipoConversao(dados.getTipoConversao());
        resultado.setValorOriginal(dados.getValor());

        if (dados.getTipoConversao().equals("cm-m")){
            resultado.setValorConvertido(converteCm(dados.getValor()));
        }
        if (dados.getTipoConversao().equals("m-cm")){
            resultado.setValorConvertido(converteM(dados.getValor()));
        }

        if (dados.getTipoConversao().equals("kg-g")){
            resultado.setValorConvertido(converteKg(dados.getValor()));
        }
        if (dados.getTipoConversao().equals("g-kg")){
            resultado.setValorConvertido(converteG(dados.getValor()));
        }

        if (dados.getTipoConversao().equals("c-f")){
            resultado.setValorConvertido(converteC(dados.getValor()));
        }
        if (dados.getTipoConversao().equals("f-c")){
            resultado.setValorConvertido(converteF(dados.getValor()));
        } else {
            ErroDto erro = new ErroDto();
            erro.setErro("Tipo de conversão inválido. Use um dos seguintes: cm-m, m-cm, kg-g, g-kg, c-f, f-c.");
            return erro;
        }
        return resultado;
    }

    //converte cm para metro
    public double converteCm(double valor){
        return valor / 100;
    }
    //converte metro para cm
    public double converteM(double valor){
        return valor * 100;
    }
    //converte kg para g
    public double converteKg(double valor){
        return valor*1000;
    }
    //converte g para kg
    public double converteG(double valor){
        return valor / 1000;
    }
    //converte C para F
    public double converteC(double valor){
        return ((valor*9/5)+32);
    }
    public double converteF(double valor){
        return ((valor-32)*5/9);
    }

}
