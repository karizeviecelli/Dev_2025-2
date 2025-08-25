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
    private int proximoId = 1;

    public RespostaDto adicionarUsuario ( RequisicaoDto dados){
    RespostaDto resposta = new RespostaDto();

     for (UsuarioModel valida : listaUser){
         if (dados.getLogin().equals(valida.getLogin())){
             resposta.setMsg("Usuário já existente!");
             return resposta;
         }
     }

    UsuarioModel usuario = new UsuarioModel();

     usuario.setId(proximoId);
     usuario.setNome(dados.getNome());
     usuario.setLogin(dados.getLogin());
     usuario.setSenha(dados.getSenha());
     listaUser.add(usuario);
     resposta.setMsg("Usuário cadastrado!");

     return resposta;
    }


    public RespostaDto excluirUsuario (int id) {

        UsuarioModel usuarioModel = new UsuarioModel();
        RespostaDto respostaDto = new RespostaDto();

        for (UsuarioModel busca : listaUser) {
            if (busca.getId().equals(proximoId)) {
                listaUser.remove(busca);
               respostaDto.setMsg("Usuário excluido com sucesso!");
               break;

            } else {
                respostaDto.setMsg("Usuário não encontrado!");
            }
    }
        return respostaDto;
    }

    public List<RespostaDto> listaUsuarios (){

        List<RespostaDto> resposta = new ArrayList<>();

         for (UsuarioModel busca : listaUser){
             RespostaDto alimentando = new RespostaDto();

            alimentando.setSenha(busca.getSenha());
            alimentando.setNome(busca.getNome());
            alimentando.setLogin(busca.getLogin());
            resposta.add(alimentando);
         }

        return resposta;
    }
}
