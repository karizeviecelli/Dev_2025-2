package com.senai.UsuarioCRUD_Marlos.Services;

import com.senai.UsuarioCRUD_Marlos.Dtos.RequisicaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RespostaDto;
import com.senai.UsuarioCRUD_Marlos.Models.UsuarioModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class UsuarioService {



    List<UsuarioModel> ListaUser = new ArrayList<>();

    UsuarioModel usuario = new UsuarioModel();

    public RespostaDto adicionarUsuario ( RequisicaoDto dados){
    RespostaDto resposta = new RespostaDto();

     for (UsuarioModel valida : ListaUser){
         if (dados.getLogin().equals(valida)){
             resposta.setMsg("Usuário já existente!");
         }
     }

     usuario.setNome(dados.getNome());
     usuario.setLogin(dados.getLogin());
     usuario.setSenha(dados.getSenha());

     resposta.setMsg("Usuário cadastrado!");

    }







}
