package com.nous.app.service;

import com.nous.app.model.Trilha;
import com.nous.app.repository.TrilhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }
}
