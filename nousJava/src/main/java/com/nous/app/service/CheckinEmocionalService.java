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

    private static final int HUMOR_CRITICO = 2;
    private static final int HUMOR_INTERMEDIARIO = 3;
    private static final int QUANTIDADE_MINIMA_ALERTAS = 3;

    private static final String RECOMENDACAO_ALERTA =
            "Seu check-in indica atenção. Faça uma pausa, converse com alguém de confiança e siga uma trilha de autocuidado.";

    private static final String RECOMENDACAO_INTERMEDIARIA =
            "Você parece em um estado intermediário. Que tal revisar sua rotina e completar uma atividade leve hoje?";

    private static final String RECOMENDACAO_POSITIVA =
            "Ótimo sinal. Continue mantendo sua rotina de estudos e autocuidado.";

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

        return checkinRepository.findByUsuarioIdUsuarioOrderByDtCheckinDesc(
                idUsuario
        );
    }

    public CheckinEmocional buscarPorId(Long id) {

        return checkinRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                NOT_FOUND,
                                "Check-in não encontrado."
                        )
                );
    }

    public String gerarRecomendacao(CheckinEmocional checkin) {

        int humor = checkin.getNrHumor();

        if (humor <= HUMOR_CRITICO) {
            return RECOMENDACAO_ALERTA;
        }

        if (humor == HUMOR_INTERMEDIARIO) {
            return RECOMENDACAO_INTERMEDIARIA;
        }

        return RECOMENDACAO_POSITIVA;
    }

    public boolean possuiAlerta(Long idUsuario) {

        long quantidadeAlertas =
                checkinRepository.countByUsuarioIdUsuarioAndNrHumorLessThanEqual(
                        idUsuario,
                        HUMOR_CRITICO
                );

        return quantidadeAlertas >= QUANTIDADE_MINIMA_ALERTAS;
    }
}