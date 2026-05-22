package com.nous.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CheckinEmocionalDTO {

    @NotNull(message = "O humor é obrigatório")
    @Min(value = 1, message = "O humor deve ser entre 1 e 5")
    @Max(value = 5, message = "O humor deve ser entre 1 e 5")
    private Integer nrHumor;

    @Size(max = 255, message = "O comentário deve ter no máximo 255 caracteres")
    private String dsComentario;
}
