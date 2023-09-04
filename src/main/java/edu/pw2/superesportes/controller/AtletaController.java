package edu.pw2.superesportes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/atletas")
public class AtletaController {

    // Exemplo de tratamento de GET simples.
    // Na URL, testar com: 
    // http://localhost:8080/atletas
    @GetMapping()
    @ResponseBody
    public String olaMundo(){
        String resposta = "<h1>Olá mundo</h1>";
        return resposta;
    }


    // Exemplo de tratamento de GET com parâmetros.
    // Na URL, testar com: 
    // http://localhost:8080/atletas/imc?nome=Joao&altura=1.85&peso=85
    @GetMapping("/imc")
    @ResponseBody
    public String calcIMC(String nome, int peso, double altura){
        double imc = peso/(altura*altura);
        String resposta = nome + " possui IMC: " + imc + ".";
        return resposta;
    }

    // Exemplo de tratamento de Post com parâmetros.
    // Na URL, testar utilizando extensão Restman com:
    // URL: http://localhost:8080/atletas/imc
    // Body:
    // nome: Joao
    // altura: 1.85
    // peso: 85
    @PostMapping("/imc")
    @ResponseBody
    public String calcIMCPost(String nome, int peso, double altura){
        double imc = peso/(altura*altura);
        String resposta = nome + " possui IMC: " + imc + ".";
        return resposta;
    }

}
