package com.senai.UsuarioCRUD_Marlos.Services;

import com.senai.UsuarioCRUD_Marlos.Dtos.RequisicaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RespostaDto;
import com.senai.UsuarioCRUD_Marlos.Models.UsuarioModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {


    List<UsuarioModel> listaUser = new ArrayList<>();

    UsuarioModel usuario = new UsuarioModel();

    public RespostaDto adicionarUsuario ( RequisicaoDto dados){
    RespostaDto resposta = new RespostaDto();

     for (UsuarioModel valida : listaUser){
         if (dados.getLogin().equals(valida)){
             resposta.setMsg("Usuário já existente!");
         }
     }

     usuario.setNome(dados.getNome());
     usuario.setLogin(dados.getLogin());
     usuario.setSenha(dados.getSenha());

     listaUser.add(usuario);

     resposta.setMsg("Usuário cadastrado!");
     resposta.setNome(dados.getNome());

     return resposta;
    }






}
