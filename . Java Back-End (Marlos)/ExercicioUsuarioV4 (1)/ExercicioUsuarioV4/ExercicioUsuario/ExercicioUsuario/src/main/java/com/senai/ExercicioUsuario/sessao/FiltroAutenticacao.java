package com.senai.ExercicioUsuario.sessao;


import com.senai.ExercicioUsuario.dtos.UsuarioSessaoDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FiltroAutenticacao implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        UsuarioSessaoDto usuario = ControleSessao.obter(httpReq);

        //--Caso não seja possível determinar o usuário, realizar uma resposta forçada antes do
        //-- controlador um comando de redirect para o login!
        if (usuario == null || usuario.getId() == null) {
            httpRes.sendRedirect(httpReq.getContextPath() + "/login");
            return;
        }

        //-- segurança para não manter o cache ativo
        httpRes.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpRes.setHeader("Pragma", "no-cache");
        httpRes.setDateHeader("Expires", 0);

        chain.doFilter(request, response);
    }

}
