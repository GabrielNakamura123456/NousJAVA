package com.nous.app.controller;

import com.nous.app.model.CheckinEmocional;
import com.nous.app.service.CheckinEmocionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
@RequiredArgsConstructor
public class CheckinEmocionalController {

    private final CheckinEmocionalService service;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CheckinEmocional>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(service.listarPorUsuario(idUsuario));
    }
}
