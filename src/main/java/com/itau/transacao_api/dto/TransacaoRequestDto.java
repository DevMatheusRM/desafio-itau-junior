package com.itau.transacao_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public class TransacaoRequestDto {

    @NotNull
    @PositiveOrZero
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public OffsetDateTime getDataHora() { return dataHora; }
    public void setDataHora(OffsetDateTime dataHora) { this.dataHora = dataHora; }
}
