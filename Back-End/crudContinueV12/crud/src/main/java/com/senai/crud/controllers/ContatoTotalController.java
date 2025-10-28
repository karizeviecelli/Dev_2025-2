package com.senai.crud.controllers;

import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contato")
public class ContatoTotalController {

    private final ContatoService contatoService;

    public ContatoTotalController(ContatoService contatoService) {this.contatoService = contatoService;}

    @GetMapping("/contatocadastro")
    public String contatoCadastro(Model model){
        model.addAttribute("contatoDto", new ContatoDto());
        return "contatocadastro"; // retorna o template correto
    }

    @PostMapping("/cadastrocontato")
    public String cadastrarContato(@ModelAttribute ContatoDto contatoDto){
        contatoService.cadastrarContato(contatoDto);
        return "redirect:/contatolista"; // redireciona para a lista
    }

    @GetMapping("/contatolista")
    public String viewContatoLista(Model model){
        List<ContatoDto> contatoDtoList = contatoService.obterContato();
        model.addAttribute("contatoDtoList", contatoDtoList);
        return "contatolista"; // retorna o template da lista
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RespostaDto> excluir(@PathVariable Long id){
        RespostaDto resposta = contatoService.excluirContato(id);

        if ("sucesso".equals(resposta.getMensagem())) {
            resposta.setMensagem("Contato excluído com sucesso");
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }
    }
}