package com.nous.app.repository;

import com.nous.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByDsEmail(String dsEmail);
    Optional<Usuario> findByDsEmail(String dsEmail);
}
