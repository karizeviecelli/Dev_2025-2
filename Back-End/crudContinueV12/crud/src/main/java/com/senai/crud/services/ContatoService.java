package com.senai.crud.services;

import org.springframework.stereotype.Service;

@Service
public class ContatoService {


    private ContatoService contatoService;

    public ContatoService(ContatoService contatoService) {this.contatoService = contatoService;}


}
