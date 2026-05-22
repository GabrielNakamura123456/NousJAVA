package com.nous.app.repository;

import com.nous.app.model.CheckinEmocional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckinEmocionalRepository extends JpaRepository<CheckinEmocional, Long> {
    List<CheckinEmocional> findByUsuarioIdUsuarioOrderByDtCheckinDesc(Long idUsuario);
    long countByUsuarioIdUsuarioAndNrHumorLessThanEqual(Long idUsuario, Integer humor);
}
