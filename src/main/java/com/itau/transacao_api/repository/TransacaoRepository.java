package com.itau.transacao_api.repository;

import com.itau.transacao_api.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private static final List<Transacao> transacoes = new ArrayList<>();

    public void salvar(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> todas() {
        return new ArrayList<>(transacoes);
    }

    public void limpar() {
        transacoes.clear();
    }
}
