package com.senai.UsuarioCRUD_Marlos.Services;

import com.senai.UsuarioCRUD_Marlos.Dtos.AuthenticacaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.MsgDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RequisicaoDto;
import com.senai.UsuarioCRUD_Marlos.Dtos.RespostaDto;
import com.senai.UsuarioCRUD_Marlos.Models.UsuarioModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {


    List<UsuarioModel> listaUser = new ArrayList<>();
    private int proximoId = 1;

    public RespostaDto adicionarUsuario(RequisicaoDto dados) {
        RespostaDto resposta = new RespostaDto();

        for (UsuarioModel valida : listaUser) {
            if (dados.getLogin().equals(valida.getLogin())) {
                resposta.setMsg("Usuário já existente!");
                return resposta;
            }
        }

        UsuarioModel usuario = new UsuarioModel();

        usuario.setId(proximoId++);
        usuario.setNome(dados.getNome());
        usuario.setLogin(dados.getLogin());
        usuario.setSenha(dados.getSenha());
        listaUser.add(usuario);
        resposta.setMsg("Usuário cadastrado!");

        return resposta;
    }


    public RespostaDto excluirUsuario(int id) {

        UsuarioModel usuarioModel = new UsuarioModel();
        RespostaDto respostaDto = new RespostaDto();

        for (UsuarioModel busca : listaUser) {
            if (busca.getId().equals(id)) {
                listaUser.remove(busca);
                respostaDto.setMsg("Usuário excluido com sucesso!");
                break;

            } else {
                respostaDto.setMsg("Usuário não encontrado!");
            }
        }
        return respostaDto;
    }

    public List<RespostaDto> listaUsuarios() {

        List<RespostaDto> resposta = new ArrayList<>();

        for (UsuarioModel busca : listaUser) {
            RespostaDto alimentando = new RespostaDto();

            alimentando.setSenha(busca.getSenha());
            alimentando.setNome(busca.getNome());
            alimentando.setLogin(busca.getLogin());
            resposta.add(alimentando);
        }

        return resposta;
    }

    // Preciso do RespostaDTo pois preciso imprimir os dados do usuário, e preciso do pathvariable int id pois vou buscar o usuário por id
    public RespostaDto buscaUsuario(@PathVariable int id) {

        RespostaDto buscandoU = new RespostaDto();


        //passo verificando se que está dentro do scanner é igual ao oque o usuário solicitou
        for (UsuarioModel busca : listaUser) {
            if (id == busca.getId()) {
                //Adiciono as informações que estavam dentor do ListaUser eu passo para o busca, e do busca eu passo para o buscandoU, pois o model não pode passar as informações direto.
                buscandoU.setLogin(busca.getLogin());
                buscandoU.setNome(busca.getNome());
                buscandoU.setSenha(busca.getSenha());
                return buscandoU;
            }
        }//retorno as informações do usuário por id
        buscandoU.setMsg("Usuário não encontrado!");
        return buscandoU;
    }

    public MsgDto autLogin(AuthenticacaoDto dados) {
        AuthenticacaoDto ver = new AuthenticacaoDto();
        MsgDto msg = new MsgDto();

        for (UsuarioModel passando : listaUser) {
            if (dados.getLogin().equals(passando.getLogin()) && dados.getSenha().equals(passando.getSenha())) {
                msg.setMsg("Login realizado com sucesso!");
                return msg;
            }

        }

        msg.setMsg("Login inválido, por getileza verificar Login e senha!");
        return msg;
    }
}
