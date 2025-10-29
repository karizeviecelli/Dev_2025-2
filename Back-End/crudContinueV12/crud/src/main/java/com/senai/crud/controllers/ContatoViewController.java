package com.senai.crud.controllers;

import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.services.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Controller para páginas (HTML)
@Controller
public class ContatoViewController {

    private final ContatoService contatoService;

    public ContatoViewController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/contatocadastro")
    public String contatoCadastro(Model model){
        model.addAttribute("contatoDto", new ContatoDto());
        return "contatocadastro";
    }

    @PostMapping("/cadastrocontato")
    public String cadastrarContato(@ModelAttribute ContatoDto contatoDto){
        contatoService.cadastrarContato(contatoDto);
        return "redirect:/contatolista";
    }

    @GetMapping("/contatolista")
    public String viewContatoLista(Model model){
        List<ContatoDto> contatoDtoList = contatoService.obterContato();
        model.addAttribute("contatoDtoList", contatoDtoList);
        return "contatolista";
    }

    @GetMapping("/contatoatualizar/{id}")
    public String viewAtualizar(@PathVariable Long id, Model model){
        ContatoDto contatoDto = contatoService.obterContato(id);
        model.addAttribute("contatoDto", contatoDto);
        return "contatoatualizar";
    }

    @PostMapping("/contatoatualizar/{id}")
    public String atualizar(@ModelAttribute("contatoDto") ContatoDto contatoDto, @PathVariable Long id){
        contatoService.atualizarContato(id, contatoDto);
        return "redirect:/contatolista"; // corrigido para apontar para o controller correto
    }


}
