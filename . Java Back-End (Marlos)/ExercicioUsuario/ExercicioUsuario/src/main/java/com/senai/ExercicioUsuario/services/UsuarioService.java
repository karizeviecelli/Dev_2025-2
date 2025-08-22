package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<UsuarioModel> usuarios = new ArrayList<>();
    private int ultimoId = 0;
    private UsuarioModel usuarioModel = new UsuarioModel();
    private MensagemDto mensagem = new MensagemDto();
    private RespostaDto resposta = new RespostaDto();

    //metodo para criar usuarios
    public MensagemDto adicionarUsuario(RequisicaoDto dados){
        for (UsuarioModel usuario : usuarios){
            if (dados.getLogin().equals(usuario.getLogin())){
                //pensar numa solução para retornar erro
                mensagem.setMensagemUsuario("Login já existente");
                return mensagem;
            }
        }
        ultimoId++;
        usuarioModel.setId(ultimoId);

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
    public List<RespostaDto> listaUsuarios(){
        List<RespostaDto> listaUsuarioDto = new ArrayList<>();

        for (UsuarioModel usuario : usuarios){
            RespostaDto respostaDto = new RespostaDto();

            respostaDto.setId(usuario.getId());
            respostaDto.setNome(usuario.getNome());
            respostaDto.setLogin(usuario.getLogin());
            respostaDto.setSenha(usuario.getSenha());

            listaUsuarioDto.add(respostaDto);
        }
        return listaUsuarioDto;
    }


    //metodo para devolver usuarios por id
    public Object buscarUsuarioId(int id){
        for (UsuarioModel usuario : usuarios){
            if (id == usuario.getId()){
                resposta.setId(usuario.getId());
                resposta.setLogin(usuario.getLogin());
                resposta.setNome(usuario.getNome());
                resposta.setSenha(usuario.getSenha());
                return resposta;
            }
        }
        mensagem.setMensagemUsuario("Usuário não encontrado");
        return mensagem;
    }


    //metodo para atualizar usuarios por id
    //Não deixar atualizar caso aquele login já exista
    //Deixar atualizar "nome, senha" sem alterar o login


    //metodo para deletar usuarios
    public MensagemDto deletarUsuario(int id){
        for (UsuarioModel usuario : usuarios){
            if (id == usuario.getId()){
                usuarios.remove(usuario);
                mensagem.setMensagemUsuario("Usuario deletado com sucesso");
                return mensagem;
            }
        }
        mensagem.setMensagemUsuario("Usuário não existe na lista");
        return mensagem;
    }

}
