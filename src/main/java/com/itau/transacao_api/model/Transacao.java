package com.itau.transacao_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class Transacao {

    private Double valor;

    @PositiveOrZero
    private OffsetDateTime dataHora;
}