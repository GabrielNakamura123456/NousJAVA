package com.nous.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tds_nous_usuario")
public class Usuario {

    private static final String ROLE_ALUNO = "ROLE_ALUNO";
    private static final String ROLE_EDUCADOR = "ROLE_EDUCADOR";

    private static final Set<String> EMAILS_EDUCADORES = Set.of(
            "diego@email.com",
            "eduarda@email.com"
    );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "O nome do usuário é obrigatório.")
    @Column(name = "nm_usuario", nullable = false)
    private String nmUsuario;

    @Email(message = "E-mail inválido.")
    @NotBlank(message = "O e-mail é obrigatório.")
    @Column(name = "ds_email", nullable = false, unique = true)
    private String dsEmail;

    @NotBlank(message = "A senha é obrigatória.")
    @Column(name = "ds_senha", nullable = false)
    private String dsSenha;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;

    @Transient
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @Builder.Default
    private List<CheckinEmocional> checkins = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @Builder.Default
    private List<ProgressoTrilha> progressos = new ArrayList<>();

    public String getRole() {

        if (dsEmail == null || dsEmail.isBlank()) {
            return ROLE_ALUNO;
        }

        return EMAILS_EDUCADORES.contains(dsEmail.toLowerCase())
                ? ROLE_EDUCADOR
                : ROLE_ALUNO;
    }
}