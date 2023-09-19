package edu.pw2.superesportes.controller;

import edu.pw2.superesportes.model.usuario.NovoUsuarioDados;
import edu.pw2.superesportes.model.usuario.Usuario;
import edu.pw2.superesportes.model.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping("cadastro")
    public String loadNovoUsuarioForm(){
        return "usuario/cadastro";
    }

    @PostMapping("salvar")
    @Transactional
    public String guardarUsuario(NovoUsuarioDados dados){
        System.out.println("Salvando os " + dados);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(dados.password());
        Usuario u = new Usuario(dados.username(), dados.email(), password);
        usuarioRepo.save(u);
        return "redirect:/login";
    }

}
