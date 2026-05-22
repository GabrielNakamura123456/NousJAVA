package com.nous.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/pos-login")
    public String posLogin(Authentication authentication) {
        boolean educador = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_EDUCADOR"));
        return educador ? "redirect:/educador/dashboard" : "redirect:/aluno/dashboard";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("mensagem", "Você não tem permissão para acessar esta página.");
        return "error";
    }
}
