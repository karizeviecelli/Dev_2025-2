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

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository=repository;
    }

    //metodo para criar usuarios
    public MensagemDto adicionarUsuario(RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();

        if (repository.existsByLogin(dados.getLogin()).isPresent()){
            mensagem.setMensagemUsuario("Login já existente");
            return mensagem;
        }

        /*
        for (UsuarioModel usuario : usuarios) {
            if (dados.getLogin().equals(usuario.getLogin())) {
                //pensar numa solução para retornar erro

            }
            if (dados.getNome().isEmpty() || dados.getSenha().isEmpty() || dados.getLogin().isEmpty()) {
                mensagem.setMensagemUsuario("Preencha todos os campos!");
                return mensagem;
            }
        }
        */
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(dados.getNome());
        usuarioModel.setLogin(dados.getLogin());
        usuarioModel.setSenha(dados.getSenha());
        //adicionando no Banco
        repository.save(usuarioModel);

        mensagem.setMensagemUsuario("Usuário cadastrado com sucesso");
        return mensagem;
    }

    //metodo para listar usuarios
    public List<RespostaDto> listaUsuarios() {
        List<RespostaDto> listaUsuarioDto = new ArrayList<>();
        List<UsuarioModel> usuarios = repository.findAll();

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
    public Object buscarUsuarioId(Long id) {
        RespostaDto resposta = new RespostaDto();
        MensagemDto mensagem = new MensagemDto();
        Optional<UsuarioModel> usuario = repository.findById(id);
        if (repository.existsById(id)) {
            resposta.setId(usuario.get().getId());
            resposta.setLogin(usuario.get().getLogin());
            resposta.setNome(usuario.get().getNome());
            resposta.setSenha(usuario.get().getSenha());
            return resposta;
        }
        mensagem.setMensagemUsuario("Nenhum usuário foi encontrado com esse ID");
        return mensagem;
    }


    //metodo para atualizar usuarios por id
    //Não deixar atualizar caso aquele login já exista
    //Deixar atualizar "nome, senha" sem alterar o login
    public MensagemDto alterarUsuario(Long id, RequisicaoDto dados) {
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioModel = repository.findById(id);

        if(usuarioModel.isPresent()){
            //--obtêm o objeto UsuarioModel de dentro do Opcional
            UsuarioModel usuario = usuarioModel.get();
            usuario.setNome(dados.getNome());
            usuario.setLogin(dados.getLogin());
            usuario.setSenha(dados.getSenha());
            repository.save(usuario);

            mensagem.setMensagemUsuario("Usuario atualizado!");
            return mensagem;
        }

        mensagem.setMensagemUsuario("Usuário não existe ou não foi encontrado!");
        return mensagem;
    }

    //metodo para deletar usuarios
    public MensagemDto deletarUsuario(Long id) {

        Optional<UsuarioModel> usuarioModel = repository.findById(id);

        MensagemDto mensagem = new MensagemDto();
        if (usuarioModel.isPresent()){
            repository.deleteById(id);
            mensagem.setMensagemUsuario("Usuario deletado com sucesso");
            return mensagem;
        }
        else {
            mensagem.setMensagemUsuario("Usuário não encontrado!");
            return mensagem;
        }
    }

    public MensagemDto login(LoginDto dados){
        MensagemDto mensagem = new MensagemDto();
        /*
        for (UsuarioModel usuario : usuarios){
            if (dados.getLogin().equals(usuario.getLogin()) && dados.getSenha().equals(usuario.getSenha())){
                mensagem.setMensagemUsuario("Autenticação bem-sucedida!");
                return mensagem;
            }
        }
         */

        mensagem.setMensagemUsuario("Nenhum usuário foi encontrado!");
        return mensagem;
    }

}
