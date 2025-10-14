package com.senai.Conversor.Controllers;


import com.senai.Conversor.Services.ConversorService;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController


    public class ConversorController {

    ConversorService service;
//Injeão de depêndecia criada
    public ConversorController(ConversorService service) {this.service = service;}




}
