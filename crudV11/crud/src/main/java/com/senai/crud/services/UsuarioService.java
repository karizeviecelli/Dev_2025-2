package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public MensagemDto adicionarUsuario(RequestDto usuarioDto){

        //--Convertendo o objeto DTO em Model
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setLogin(usuarioDto.getLogin());
        usuarioModel.setSenha(usuarioDto.getSenha());

        //listaUsuarios.add(usuarioModel);
        repository.save(usuarioModel);

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Cadastrado com sucesso!");
        return mensagem;
    }

    public boolean atualizarUsuario( Long id, UsuarioAtualizarDto usuarioDto ){

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        Optional<UsuarioModel> usuarioOptionalLogin = repository.findByLogin(usuarioDto.getLogin());

        if( usuarioOptionalLogin.isPresent() && !usuarioOptionalLogin.get().getId().equals(id) ){
            throw new InvalidOperationException("Já existe um usuário com este login!");
        }

        System.out.println("chegou no service=" + usuarioOptional.isPresent());

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            //--Atualizar

            //--Obter o usuario dentro do optinal
            UsuarioModel usuario = usuarioOptional.get();

            //--atualizar valores do usuario
            usuario.setNome(usuarioDto.getNome());
            usuario.setLogin(usuarioDto.getLogin());
            if (!usuarioDto.getSenha().isEmpty()) {
                usuario.setSenha(usuarioDto.getSenha());
            }

            //--persistir usuário no banco de dados
            repository.save(usuario);

            return true;

        }

        return false;

    }

    public UsuarioAtualizarDto buscarUsuarioId(Long id){

         Optional<UsuarioModel> usuarioOP = repository.findById(id);
         if (!usuarioOP.isPresent()){
             //--quando não encontra retorna um objeto com id ZERO
             return new UsuarioAtualizarDto(0L);
         }
         return new UsuarioAtualizarDto(usuarioOP.get());

    }

    public ResponseDto buscarUsuarioPorId(Long id){

        ResponseDto usuarioRetorno = new ResponseDto();

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            //--Obter o usuario do optinal
            UsuarioModel usuario = usuarioOptional.get();

            //--Converter usuarioModel para o DTO
            usuarioRetorno.setId(usuario.getId());
            usuarioRetorno.setNome(usuario.getNome());
            usuarioRetorno.setLogin(usuario.getLogin());
            usuarioRetorno.setSenha(usuario.getSenha());

        }

        //--retornar o DTO
        return  usuarioRetorno;
    }

    public List<ListaUsuariosDto> listarUsuarios(){

        //--Obter os usuários do banco de dados
        List<UsuarioModel> listaUsuarios = repository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<ListaUsuariosDto> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( UsuarioModel usuario :  listaUsuarios ){

            //--Crio UM objeto DTO
            ListaUsuariosDto usuarioRetorno = new ListaUsuariosDto();

            //--Converto UM objeto model em UM objeto DTO
            usuarioRetorno.setId(usuario.getId());
            usuarioRetorno.setNome(usuario.getNome());
            usuarioRetorno.setLogin(usuario.getLogin());

            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(usuarioRetorno);
        }

        return lista;
    }

    public MensagemDto removerUsuario(Long id){

        MensagemDto mensagem = new MensagemDto();
        mensagem.setMensagem("Erro ao excluir");
        mensagem.setSucesso(false);

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            repository.delete(usuarioOptional.get());

            mensagem.setMensagem("Sucesso ao excluir o usuário");
            mensagem.setSucesso(true);

        }

        return mensagem;
    }

    public UsuarioSessaoDto logar(LoginDto login){

        UsuarioSessaoDto usuarioSessao = new UsuarioSessaoDto();

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(login.getLogin());

        if (usuarioOptional.isPresent()){

            if (usuarioOptional.get().getSenha().equals(login.getSenha())){

                //-Deu certo
                usuarioSessao.setId(usuarioOptional.get().getId());
                usuarioSessao.setNome(usuarioOptional.get().getNome());
            }
        }

        return  usuarioSessao;
    }

}
