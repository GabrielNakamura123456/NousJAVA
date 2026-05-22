package com.nous.app.controller;

import com.nous.app.model.ProgressoTrilha;
import com.nous.app.service.ProgressoTrilhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progressos")
@RequiredArgsConstructor
public class ProgressoTrilhaController {

    private final ProgressoTrilhaService progressoTrilhaService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ProgressoTrilha>> listarPorUsuario(
            @PathVariable Long idUsuario) {

        List<ProgressoTrilha> progressos =
                progressoTrilhaService.listarPorUsuario(idUsuario);

        if (progressos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(progressos);
    }
}