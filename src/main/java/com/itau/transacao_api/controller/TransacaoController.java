package com.itau.transacao_api.controller;

import com.itau.transacao_api.dto.TransacaoRequestDto;
import com.itau.transacao_api.dto.TransacaoResponseDto;
import com.itau.transacao_api.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid TransacaoRequestDto dto) {
        service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<TransacaoResponseDto> listarTransacoes() {
        return service.listar().stream()
                .map(t -> new TransacaoResponseDto(t.getValor(), t.getDataHora()))
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTodas() {
        service.limpar();
        return ResponseEntity.noContent().build();
    }
}
