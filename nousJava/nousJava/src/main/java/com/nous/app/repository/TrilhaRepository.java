package com.nous.app.repository;

import com.nous.app.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    boolean existsByDsTituloIgnoreCase(String dsTitulo);
}
