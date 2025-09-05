package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import com.senai.ExercicioUsuario.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<UsuarioModel> usuarios = new ArrayList<>();
    private Long ultimoId = 0L;
    private  final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    //metodo para criar usuarios
    public MensagemDto adicionarUsuario(RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();
        UsuarioModel usuarioModel = new UsuarioModel();
        for (UsuarioModel usuario : usuarios) {
            if (dados.getLogin().equals(usuario.getLogin())) {
                //pensar numa solução para retornar erro
                mensagem.setMensagemUsuario("Login já existente");
                return mensagem;
            }
            if (dados.getNome().isEmpty() || dados.getSenha().isEmpty() || dados.getLogin().isEmpty()) {
                mensagem.setMensagemUsuario("Preencha todos os campos!");
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
        return mensagem;
    }

    //metodo para listar usuarios
    public List<RespostaDto> listaUsuarios() {
        List<RespostaDto> listaUsuarioDto = new ArrayList<>();

        for (UsuarioModel usuario : usuarios) {
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
    public Object buscarUsuarioId(int id) {
        RespostaDto resposta = new RespostaDto();
        MensagemDto mensagem = new MensagemDto();
        for (UsuarioModel usuario : usuarios) {
            if (id == usuario.getId()) {
                resposta.setId(usuario.getId());
                resposta.setLogin(usuario.getLogin());
                resposta.setNome(usuario.getNome());
                resposta.setSenha(usuario.getSenha());
                return resposta;
            }
        }
        mensagem.setMensagemUsuario("Nenhum usuário foi encontrado com esse ID");
        return mensagem;
    }


    //metodo para atualizar usuarios por id
    //Não deixar atualizar caso aquele login já exista
    //Deixar atualizar "nome, senha" sem alterar o login
    public MensagemDto alterarUsuario(int id, RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();

        for (UsuarioModel usuario : usuarios) {
            if (id != usuario.getId()) {
                if(dados.getLogin().equals(usuario.getLogin())){
                    mensagem.setMensagemUsuario("Login já existente!");
                    return mensagem;
                }
            }
        }
        for (UsuarioModel usuario : usuarios) {
            if (id == usuario.getId()) {
                usuario.setLogin(dados.getLogin());
                usuario.setNome(dados.getNome());
                usuario.setSenha(dados.getSenha());
                mensagem.setMensagemUsuario("Usuario atualizado!");
                return mensagem;
            }
        }

        mensagem.setMensagemUsuario("Usuário não existe ou não foi encontrado!");
        return mensagem;
    }

    //metodo para deletar usuarios
    public MensagemDto deletarUsuario(int id) {
        MensagemDto mensagem = new MensagemDto();
        for (UsuarioModel usuario : usuarios) {
            if (id == usuario.getId()) {
                usuarios.remove(usuario);
                mensagem.setMensagemUsuario("Usuario deletado com sucesso");
                return mensagem;
            }
        }
        mensagem.setMensagemUsuario("Usuário não existe na lista");
        return mensagem;
    }

    public MensagemDto login(LoginDto dados){
        MensagemDto mensagem = new MensagemDto();

        for (UsuarioModel usuario : usuarios){
            if (dados.getLogin().equals(usuario.getLogin()) && dados.getSenha().equals(usuario.getSenha())){
                mensagem.setMensagemUsuario("Autenticação bem-sucedida!");
                return mensagem;
            }
        }
        mensagem.setMensagemUsuario("Nenhum usuário foi encontrado!");
        return mensagem;
    }

}
