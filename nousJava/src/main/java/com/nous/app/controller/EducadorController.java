package com.nous.app.controller;

import com.nous.app.model.Usuario;
import com.nous.app.service.CheckinEmocionalService;
import com.nous.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EducadorController {

    private static final String ROLE_ALUNO = "ROLE_ALUNO";

    private final UsuarioService usuarioService;
    private final CheckinEmocionalService checkinService;

    @GetMapping("/educador/dashboard")
    public String dashboard(Model model) {

        List<Usuario> alunos = listarApenasAlunos();

        long totalAlertas = alunos.stream()
                .filter(aluno -> checkinService.possuiAlerta(aluno.getIdUsuario()))
                .count();

        model.addAttribute("totalAlunos", alunos.size());
        model.addAttribute("totalAlertas", totalAlertas);
        model.addAttribute("alunos", alunos);

        return "educador-dashboard";
    }

    @GetMapping("/educador/alunos")
    public String listarAlunos(Model model) {

        model.addAttribute("alunos", listarApenasAlunos());

        return "alunos";
    }

    @GetMapping("/educador/alunos/{id}")
    public String detalharAluno(@PathVariable Long id, Model model) {

        Usuario aluno = usuarioService.buscarPorId(id);

        model.addAttribute("aluno", aluno);
        model.addAttribute("historico", checkinService.listarPorUsuario(id));
        model.addAttribute("temAlerta", checkinService.possuiAlerta(id));

        return "aluno-detalhe";
    }

    private List<Usuario> listarApenasAlunos() {

        return usuarioService.listarTodos().stream()
                .filter(usuario -> ROLE_ALUNO.equals(usuario.getRole()))
                .toList();
    }
}