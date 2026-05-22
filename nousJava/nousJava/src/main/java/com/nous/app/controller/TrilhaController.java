package com.nous.app.controller;

import com.nous.app.model.Trilha;
import com.nous.app.service.TrilhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
@RequiredArgsConstructor
public class TrilhaController {

    private final TrilhaService trilhaService;

    @GetMapping
    public ResponseEntity<List<Trilha>> listarTodas() {
        return ResponseEntity.ok(trilhaService.listarTodas());
    }
}
