package com.senai.crud.sessao;

import com.senai.crud.sessao.FiltroAutenticacao;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltroConfig {

    @Bean
    public FilterRegistrationBean<FiltroAutenticacao> filtroAutenticacao() {
        FilterRegistrationBean<FiltroAutenticacao> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FiltroAutenticacao());
        registration.addUrlPatterns("/home", "/produtolista");
        registration.setOrder(1); // prioridade de execução, se houver outros filtros
        return registration;
    }
}
