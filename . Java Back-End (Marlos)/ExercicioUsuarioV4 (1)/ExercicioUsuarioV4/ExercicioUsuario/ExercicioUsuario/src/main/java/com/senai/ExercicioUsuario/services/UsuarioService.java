package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.*;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import com.senai.ExercicioUsuario.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private List<UsuarioModel> usuarios = new ArrayList<>();
    private Long ultimoId = 0L;
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }


    //metodo para criar usuarios
    public MensagemDto adicionarUsuario(RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNome(dados.getNome());
        usuarioModel.setLogin(dados.getLogin());
        usuarioModel.setSenha(dados.getSenha());

        repository.save(usuarioModel);

        mensagem.setMensagemUsuario("Usuário cadastrado com sucesso");
        return mensagem;
    }

    //metodo para listar usuarios
    public List<RespostaDto> listaUsuarios() {
        List<RespostaDto> listaUsuarioDto = new ArrayList<>();

        List<UsuarioModel> listadeUsuarioDto = repository.findAll();

        for (UsuarioModel usuario : listadeUsuarioDto) {
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
    public Object buscarUsuarioId(Long id) {
        RespostaDto resposta = new RespostaDto();
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()) {
            resposta.setId(usuarioOP.get().getId());
            resposta.setNome(usuarioOP.get().getNome());
            resposta.setSenha(usuarioOP.get().getSenha());
            resposta.setLogin(usuarioOP.get().getLogin());
            return resposta;
        }


        mensagem.setMensagemUsuario("Nenhum usuário foi encontrado com esse ID");
        return mensagem;
    }


    //metodo para atualizar usuarios por id
    //Não deixar atualizar caso aquele login já exista
    //Deixar atualizar "nome, senha" sem alterar o login
    public MensagemDto alterarUsuario(long id, RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();


        Optional<UsuarioModel> usuarioOP = repository.findById(id);
        if (usuarioOP.isPresent()) {
            //Obtém o objeto usuário model de dentro do usuarioOP
            UsuarioModel usuario = usuarioOP.get();

            usuario.setLogin(dados.getLogin());
            usuario.setNome(dados.getNome());
            usuario.setSenha(dados.getSenha());
            repository.save(usuario);
            mensagem.setMensagemUsuario("Alterado com sucesso");
            return mensagem;
        }

        for (UsuarioModel usuario : usuarios) {
            if (id == usuario.getId()) {
                usuario.setLogin(dados.getLogin());
                usuario.setNome(dados.getNome());
                usuario.setSenha(dados.getSenha());

            }
        }

        mensagem.setMensagemUsuario("Usuário não existe ou não foi encontrado!");
        return mensagem;
    }

    public MensagemDto alterarUsuario(long id, RespostaDto dados) {
        MensagemDto mensagem = new MensagemDto();


        Optional<UsuarioModel> usuarioOP = repository.findById(id);
        if (usuarioOP.isPresent()) {
            //Obtém o objeto usuário model de dentro do usuarioOP
            UsuarioModel usuario = usuarioOP.get();

            usuario.setLogin(dados.getLogin());
            usuario.setNome(dados.getNome());
            usuario.setSenha(dados.getSenha());
            repository.save(usuario);
            mensagem.setMensagemUsuario("Alterado com sucesso");
            return mensagem;
        }

        for (UsuarioModel usuario : usuarios) {
            if (id == usuario.getId()) {
                usuario.setLogin(dados.getLogin());
                usuario.setNome(dados.getNome());
                usuario.setSenha(dados.getSenha());

            }
        }

        mensagem.setMensagemUsuario("Usuário não existe ou não foi encontrado!");
        return mensagem;
    }

    //metodo para deletar usuarios
    public MensagemDto deletarUsuario(Long id) {
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioOP = repository.findById(id);

        if (usuarioOP.isPresent()) {
            //Signfiica que encontrou o usuario pelo id
            repository.delete(usuarioOP.get());
            mensagem.setMensagemUsuario("Usuario deletado com sucesso");
            return mensagem;
        }

        mensagem.setMensagemUsuario("Usuário não existe na lista");
        return mensagem;
    }

    public Boolean login(LoginDto dados) {

        Optional<UsuarioModel> usuarioOP = repository.findByLogin(dados.getLogin());
        if (usuarioOP.isPresent()){
            if (usuarioOP.get().getSenha().equals(dados.getSenha())){
                return true;
            }
        }
        return false;
    }

}
