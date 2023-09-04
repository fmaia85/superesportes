package edu.pw2.superesportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pw2.superesportes.model.atleta.Atleta;
import edu.pw2.superesportes.model.atleta.AtletaDados;
import edu.pw2.superesportes.model.atleta.AtletaRepository;

@Controller
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository repository;

    @GetMapping("/cadastro")
    public String loadAtletaForm(){
        return "atleta/cadastro";
    }

    @GetMapping
    public String loadAtletaList(Model model){
        model.addAttribute("lista", repository.findAll());
        return "atleta/listagem";
    }


    @PostMapping("/cadastro")
    public String registrarAtleta(AtletaDados dados, Model model){
        Atleta a1 = new Atleta(dados);
        repository.save(a1);
        model.addAttribute("atleta", a1);
        return "atleta/exibir";
    }
  
}
