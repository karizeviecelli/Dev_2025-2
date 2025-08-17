package com.senai.ConversorGraus.services;

import com.senai.ConversorGraus.dtos.EntradaDto;
import com.senai.ConversorGraus.dtos.SaidaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConversorService {


    public SaidaDto converter (EntradaDto dados){

        SaidaDto result = new SaidaDto();

        result.setValor(dados.getValor());
        result.setTipoConversao(dados.getTipoConversao());


        if (dados.getTipoConversao().equals("cm-m")){
            result.setResultado(dados.getValor()/100);
            return result;
        }
        else if (dados.getTipoConversao().equals("m-cm")) {
            result.setResultado(dados.getValor()*100);
            return result;
        }
        else if (dados.getTipoConversao().equals("kg-g")) {
            result.setResultado(dados.getValor()*1000);
            return result;
        }
        else if (dados.getTipoConversao().equals("g-kg")) {
                result.setResultado(dados.getValor()/1000);
                return result;
        }
        else if (dados.getTipoConversao().equals("c-f")) {
            result.setResultado((dados.getValor()*9/5)+32);
            return result;
        }
        else if (dados.getTipoConversao().equals("f-c")) {
            result.setResultado((dados.getValor()-32)*5/9);
            return result;
        }
        else{
            result.setResultado(null);
            result.setTipoConversao("Parâmetro Inválido");
        }
       return result;
    };


}
