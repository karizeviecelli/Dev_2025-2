package com.senai.ExercicioUsuario.sessao;

import com.senai.ExercicioUsuario.dtos.UsuarioSessaoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleSessao {

    public static void registrar(HttpServletRequest request, UsuarioSessaoDto usuarioSessao) {

        //--Obter a sessão da requisição ativa do momento
        HttpSession session = request.getSession(true); // cria se não existir

        //--armazenar os dados do usuário logado!
        session.setAttribute("codigoUsuario", usuarioSessao.getId());
        session.setAttribute("nomeUsuario", usuarioSessao.getNome());
    }

    public static UsuarioSessaoDto obter(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        UsuarioSessaoDto usuarioSessao = new UsuarioSessaoDto();
        if (session != null && session.getAttribute("codigoUsuario") != null) {
            usuarioSessao.setId((long) session.getAttribute("codigoUsuario"));
            usuarioSessao.setNome((String) session.getAttribute("nomeUsuario"));
        } else {
            usuarioSessao = null;
        }
        return usuarioSessao;
    }

    public static void encerrar(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}