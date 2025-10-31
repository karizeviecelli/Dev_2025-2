package com.senai.ExercicioUsuario.sessao;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltroConfig {

    //--Telas e rotas que vão ser monitoradas nos filtros!
    @Bean
    public FilterRegistrationBean<FiltroAutenticacao> filtroAutenticacao() {
        FilterRegistrationBean<FiltroAutenticacao> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FiltroAutenticacao());
        registration.addUrlPatterns("/home/*", "/produtolista/*", "/categorialista", "/contatolista");
        registration.setOrder(1); // prioridade de execução, se houver outros filtros
        return registration;
    }

}