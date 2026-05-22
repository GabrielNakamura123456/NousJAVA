package com.nous.app.controller;

import com.nous.app.dto.CheckinEmocionalDTO;
import com.nous.app.model.CheckinEmocional;
import com.nous.app.model.Usuario;
import com.nous.app.service.CheckinEmocionalService;
import com.nous.app.service.ProgressoTrilhaService;
import com.nous.app.service.TrilhaService;
import com.nous.app.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AlunoController {

    private final UsuarioService usuarioService;
    private final CheckinEmocionalService checkinService;
    private final TrilhaService trilhaService;
    private final ProgressoTrilhaService progressoTrilhaService;

    @GetMapping("/aluno/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        Usuario usuario = usuarioService.buscarPorEmail(authentication.getName());
        List<CheckinEmocional> historico = checkinService.listarPorUsuario(usuario.getIdUsuario());
        model.addAttribute("usuario", usuario);
        model.addAttribute("historico", historico.stream().limit(5).toList());
        model.addAttribute("temAlerta", checkinService.possuiAlerta(usuario.getIdUsuario()));
        return "aluno-dashboard";
    }

    @GetMapping("/aluno/checkin")
    public String exibirFormulario(Model model) {
        model.addAttribute("checkinForm", new CheckinEmocionalDTO());
        return "checkin-form";
    }

    @PostMapping("/aluno/checkin")
    public String salvarCheckin(@Valid @ModelAttribute("checkinForm") CheckinEmocionalDTO dto,
                                BindingResult bindingResult,
                                Authentication authentication,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "checkin-form";
        }

        Usuario usuario = usuarioService.buscarPorEmail(authentication.getName());
        CheckinEmocional checkin = checkinService.salvar(dto, usuario);
        model.addAttribute("recomendacao", checkinService.gerarRecomendacao(checkin));
        model.addAttribute("checkin", checkin);
        return "checkin-sucesso";
    }

    @GetMapping("/aluno/historico")
    public String historico(Authentication authentication, Model model) {
        Usuario usuario = usuarioService.buscarPorEmail(authentication.getName());
        model.addAttribute("historico", checkinService.listarPorUsuario(usuario.getIdUsuario()));
        return "checkin-historico";
    }

    @GetMapping("/aluno/trilhas")
    public String trilhas(Authentication authentication, Model model) {
        Usuario usuario = usuarioService.buscarPorEmail(authentication.getName());
        model.addAttribute("trilhas", trilhaService.listarTodas());
        model.addAttribute("progressos", progressoTrilhaService.listarPorUsuario(usuario.getIdUsuario()));
        return "trilhas";
    }
}
