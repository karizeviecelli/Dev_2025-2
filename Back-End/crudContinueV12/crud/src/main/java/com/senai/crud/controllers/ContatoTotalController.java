package com.senai.crud.controllers;

import com.senai.crud.dtos.ContatoDto;
import com.senai.crud.dtos.RespostaDto;
import com.senai.crud.services.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contato") // separando do fluxo de páginas
public class ContatoTotalController {
    private final ContatoService contatoService;

    public ContatoTotalController(ContatoService contatoService) {
        this.contatoService = contatoService;
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

    @PostMapping("/{id}")
    public String atualizar(@RequestBody ContatoDto contatoDto, @PathVariable Long id){
        
         contatoService.atualizarContato(id, contatoDto);

        return "redirect:/contatolista";
    }


}
