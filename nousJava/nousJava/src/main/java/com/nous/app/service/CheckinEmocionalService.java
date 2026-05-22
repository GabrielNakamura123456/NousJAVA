package com.nous.app.service;

import com.nous.app.dto.CheckinEmocionalDTO;
import com.nous.app.model.CheckinEmocional;
import com.nous.app.model.Usuario;
import com.nous.app.repository.CheckinEmocionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CheckinEmocionalService {

    private final CheckinEmocionalRepository checkinRepository;

    public CheckinEmocional salvar(CheckinEmocionalDTO dto, Usuario usuario) {
        CheckinEmocional checkin = CheckinEmocional.builder()
                .dtCheckin(LocalDate.now())
                .nrHumor(dto.getNrHumor())
                .dsComentario(dto.getDsComentario())
                .usuario(usuario)
                .build();
        return checkinRepository.save(checkin);
    }

    public List<CheckinEmocional> listarPorUsuario(Long idUsuario) {
        return checkinRepository.findByUsuarioIdUsuarioOrderByDtCheckinDesc(idUsuario);
    }

    public CheckinEmocional buscarPorId(Long id) {
        return checkinRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Check-in não encontrado"));
    }

    public String gerarRecomendacao(CheckinEmocional checkin) {
        int humor = checkin.getNrHumor();
        if (humor <= 2) {
            return "Seu check-in indica atenção. Faça uma pausa, converse com alguém de confiança e siga uma trilha de autocuidado.";
        }
        if (humor == 3) {
            return "Você parece em um estado intermediário. Que tal revisar sua rotina e completar uma atividade leve hoje?";
        }
        return "Ótimo sinal. Continue mantendo sua rotina de estudos e autocuidado.";
    }

    public boolean possuiAlerta(Long idUsuario) {
        return checkinRepository.countByUsuarioIdUsuarioAndNrHumorLessThanEqual(idUsuario, 2) >= 3;
    }
}
