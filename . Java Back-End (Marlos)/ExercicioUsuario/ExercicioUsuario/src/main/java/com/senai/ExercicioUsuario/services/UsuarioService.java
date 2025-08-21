package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    List<UsuarioModel> usuarios = new ArrayList<>();

    UsuarioModel usuarioModel = new UsuarioModel();

    //metodo para criar usuarios
    public MensagemDto adicionarUsuario(RequisicaoDto dados){
        MensagemDto mensagem = new MensagemDto();

        for (UsuarioModel usuario : usuarios){
            if (dados.getLogin().equals(usuario.getLogin())){
                //pensar numa solução para retornar erro
                mensagem.setMensagemUsuario("Login já existente");
                return mensagem;
            }
        }

        usuarioModel.setId(usuarios.size()+1);

        usuarioModel.setNome(dados.getNome());
        usuarioModel.setLogin(dados.getLogin());
        usuarioModel.setSenha(dados.getSenha());
        //adicionando no Array
        usuarios.add(usuarioModel);


        mensagem.setMensagemUsuario("Usuário cadastrado com sucesso");
        System.out.println(usuarioModel);
        return mensagem;
    }

    //metodo para listar usuarios

    //metodo para devolver usuarios por id

    //metodo para atualizar usuarios por id

    //metodo para deletar usuarios

}
