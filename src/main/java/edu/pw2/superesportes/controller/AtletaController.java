package edu.pw2.superesportes.controller;

import edu.pw2.superesportes.model.atleta.AtletaUpdateDados;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.pw2.superesportes.model.atleta.Atleta;
import edu.pw2.superesportes.model.atleta.AtletaDados;
import edu.pw2.superesportes.model.atleta.AtletaRepository;

@Controller
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaRepository repository;

    @GetMapping("/cadastro")
    public String loadAtletaForm(Long id, Model model){
        if (id != null) {
            Atleta a1 = repository.getReferenceById(id);
            model.addAttribute("atleta", a1);
        }
        return "atleta/cadastro";
    }

    @GetMapping
    public String loadAtletaList(Model model){
        model.addAttribute("lista", repository.findAll());
        return "atleta/listagem";
    }


    @PostMapping
    @Transactional
    public String registrarAtleta(AtletaDados dados){
        Atleta a1 = new Atleta(dados);
        repository.save(a1);
        return "redirect:/atletas";
    }

    @DeleteMapping
    @Transactional
    public String deletarAtleta(Long id){
        repository.deleteById(id);
        return "redirect:/atletas";
    }

    @PutMapping
    @Transactional
    public String atualizaCompra(AtletaUpdateDados dados){
        Atleta a1 = repository.getReferenceById(dados.id());
        a1.atualizaAtleta(dados);
        return "redirect:/atletas";
    }

  
}
