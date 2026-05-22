package com.nous.app.controller;

import com.nous.app.model.CheckinEmocional;
import com.nous.app.service.CheckinEmocionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
@RequiredArgsConstructor
public class CheckinEmocionalController {

    private final CheckinEmocionalService checkinEmocionalService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CheckinEmocional>> listarPorUsuario(
            @PathVariable Long idUsuario) {

        List<CheckinEmocional> checkins =
                checkinEmocionalService.listarPorUsuario(idUsuario);

        if (checkins.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(checkins);
    }
}