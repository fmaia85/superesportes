package edu.pw2.superesportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pw2.superesportes.model.Atleta;
import edu.pw2.superesportes.model.AtletaDados;

@Controller
@RequestMapping("/atletas")
public class AtletaController {
    @GetMapping
    public String loadAtletaForm(){
        return "atleta/cadastro";
    }

    @PostMapping
    public String registrarAtleta(AtletaDados dados, Model model){
        Atleta a1 = new Atleta(dados);
        model.addAttribute("atleta", a1);
        return "atleta/exibir";
    }
  
}
