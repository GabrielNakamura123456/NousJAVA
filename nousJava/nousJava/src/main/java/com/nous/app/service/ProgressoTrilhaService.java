package com.nous.app.service;

import com.nous.app.model.ProgressoTrilha;
import com.nous.app.repository.ProgressoTrilhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressoTrilhaService {

    private final ProgressoTrilhaRepository progressoTrilhaRepository;

    public List<ProgressoTrilha> listarPorUsuario(Long idUsuario) {
        return progressoTrilhaRepository.findByUsuarioIdUsuario(idUsuario);
    }
}
