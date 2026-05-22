package com.nous.app.repository;

import com.nous.app.model.ProgressoTrilha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressoTrilhaRepository extends JpaRepository<ProgressoTrilha, Long> {
    List<ProgressoTrilha> findByUsuarioIdUsuario(Long idUsuario);
}
