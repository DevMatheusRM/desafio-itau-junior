package com.itau.transacao_api.controller;

import com.itau.transacao_api.dto.EstatisticaResponseDto;
import com.itau.transacao_api.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponseDto> obterEstatisticas() {
        return ResponseEntity.ok(service.calcular());
    }
}
