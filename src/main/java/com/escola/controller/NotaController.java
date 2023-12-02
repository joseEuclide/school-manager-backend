package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Nota;
import com.escola.service.NotaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite CORS para este controlador
public class NotaController {
    
	@Autowired
    private NotaService ns;


    
    @GetMapping("/notas-turma/{idTurma}")
    public ResponseEntity<List<Nota>> listarTodasAsNotas(@PathVariable Long idTurma) {
        List<Nota> notas = ns.listarTodasAsNotas(idTurma);
        return ResponseEntity.ok(notas);
    }
}
