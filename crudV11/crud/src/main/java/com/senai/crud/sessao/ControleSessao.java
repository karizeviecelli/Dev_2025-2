package com.senai.crud.sessao;

import com.senai.crud.dtos.UsuarioSessaoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleSessao {

    public static void registrar(HttpServletRequest request, UsuarioSessaoDto usuarioSessao) {
        HttpSession session = request.getSession(true); // cria se não existir
        session.setAttribute("codigoUsuario", usuarioSessao.getId());
        session.setAttribute("nomeUsuario", usuarioSessao.getNome());
    }

    public static UsuarioSessaoDto obter(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        UsuarioSessaoDto usuarioSessao = new UsuarioSessaoDto();
        if (session != null) {
            usuarioSessao.setId((long) session.getAttribute("codigoUsuario"));
            usuarioSessao.setNome((String) session.getAttribute("nomeUsuario"));
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
