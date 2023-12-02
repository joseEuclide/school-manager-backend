package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.CalendarioAulas;
import com.escola.service.CalendarioAulasService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite CORS para este controlador
public class CalendarioAulasController {
    private final CalendarioAulasService calendarioAulasService;

    @Autowired
    public CalendarioAulasController(CalendarioAulasService calendarioAulasService) {
        this.calendarioAulasService = calendarioAulasService;
    }

    @PostMapping("/cadastrar-Calendario-Aulas")
    public ResponseEntity<String> cadastrarAula(@RequestBody List<CalendarioAulas> calendarios) {
        String novaAula = calendarioAulasService.cadastrarAula(calendarios);
        return new ResponseEntity<>(novaAula, HttpStatus.CREATED);
    }
	
	

    // Implemente outros endpoints para consultar, atualizar e excluir aulas do calendário
}
