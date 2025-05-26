package com.itau.transacao_api.service;


import com.itau.transacao_api.dto.TransacaoRequestDto;
import com.itau.transacao_api.model.Transacao;
import com.itau.transacao_api.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void criar(TransacaoRequestDto dto) {
        Transacao transacao = new Transacao(dto.getValor(), dto.getDataHora());
        repository.salvar(transacao);
    }

    public List<Transacao> listar() {
        return repository.todas();
    }

    public void limpar() {
        repository.limpar();
    }
}
