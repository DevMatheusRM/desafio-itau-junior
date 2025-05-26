package com.itau.transacao_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.itau.transacao_api.dto.TransacaoRequestDto;
import com.itau.transacao_api.model.Transacao;
import com.itau.transacao_api.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransacaoService {

    private static final Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void criar(TransacaoRequestDto dto) {
        logger.debug("Criando transação com valor {} e dataHora {}", dto.getValor(), dto.getDataHora());
        OffsetDateTime agora = OffsetDateTime.now();

        if (dto.getDataHora().isAfter(agora) || dto.getValor() < 0) {
            logger.warn("Tentativa de criar transação inválida");
            throw new IllegalArgumentException("Transação inválida.");
        }

        Transacao transacao = new Transacao(dto.getValor(), dto.getDataHora());
        repository.salvar(transacao);
        logger.info("Transação criada com sucesso");
    }

    public List<Transacao> listar() {
        return repository.todas();
    }

    public void limpar() {
        repository.limpar();
    }
}
