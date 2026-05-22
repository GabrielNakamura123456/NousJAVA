package com.nous.app.controller;

import com.nous.app.model.ProgressoTrilha;
import com.nous.app.service.ProgressoTrilhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/progressos")
@RequiredArgsConstructor
public class ProgressoTrilhaController {

    private final ProgressoTrilhaService progressoService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ProgressoTrilha>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(progressoService.listarPorUsuario(idUsuario));
    }
}
