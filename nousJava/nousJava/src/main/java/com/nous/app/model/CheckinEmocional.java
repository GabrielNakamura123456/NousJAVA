package com.nous.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tds_nous_checkin_emocional")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckinEmocional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkin")
    private Long idCheckin;

    @Column(name = "dt_checkin", nullable = false)
    private LocalDate dtCheckin;

    @NotNull(message = "O humor é obrigatório.")
    @Min(value = 1, message = "O humor deve ser no mínimo 1.")
    @Max(value = 5, message = "O humor deve ser no máximo 5.")
    @Column(name = "nr_humor", nullable = false)
    private Integer nrHumor;

    @Size(max = 255, message = "O comentário deve ter no máximo 255 caracteres.")
    @Column(name = "ds_comentario")
    private String dsComentario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Usuario usuario;
}
