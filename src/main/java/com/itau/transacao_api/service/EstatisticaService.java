package com.itau.transacao_api.service;

import com.itau.transacao_api.dto.EstatisticaResponseDto;
import com.itau.transacao_api.model.Transacao;
import com.itau.transacao_api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstatisticaService {

    @Value("${estatistica.intervalo.segundos:60}") // valor padrão 60 segundos
    private int intervaloSegundos;

    private final TransacaoRepository repository;

    public EstatisticaService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public EstatisticaResponseDto calcular() {
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = agora.minusSeconds(intervaloSegundos);

        List<Transacao> recentes = repository.todas().stream()
                .filter(t -> !t.getDataHora().isBefore(limite))
                .collect(Collectors.toList());

        if (recentes.isEmpty()) {
            return new EstatisticaResponseDto(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics stats = recentes.stream()
                .collect(Collectors.summarizingDouble(Transacao::getValor));

        return new EstatisticaResponseDto(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
