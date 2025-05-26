package com.itau.transacao_api.dto;

import java.time.OffsetDateTime;

public class TransacaoResponseDto {
    private Double valor;
    private OffsetDateTime dataHora;

    public TransacaoResponseDto(Double valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {return valor;}
    public OffsetDateTime getDataHora() {return dataHora;}
}
