package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.CalendarioProvas;
import com.escola.service.CalendarioProvasService;

@RestController
@CrossOrigin(origins = "*")
public class CalendarioProvasController {
    private final CalendarioProvasService calendarioProvasService;

    @Autowired
    public CalendarioProvasController(CalendarioProvasService calendarioProvasService) {
        this.calendarioProvasService = calendarioProvasService;
    }

    @PostMapping("/cadastrar-Calendario-Provas")
    public ResponseEntity<String> cadastrarProva(@RequestBody List<CalendarioProvas> prova) {
        String calendarioProva = calendarioProvasService.cadastrarProva(prova);
        return new ResponseEntity<>(calendarioProva, HttpStatus.CREATED);
    }

    // Implemente outros endpoints para consultar, atualizar e excluir provas do calendário
}
