package com.itau.transacao_api.repository;

import com.itau.transacao_api.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TransacaoRepository {
    private final List<Transacao> lista = Collections.synchronizedList(new ArrayList<>());
    public void salvar(Transacao t) { lista.add(t); }
    public void limpar() { lista.clear(); }
    public List<Transacao> todas() { return new ArrayList<>(lista); }
}
