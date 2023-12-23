package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Tesouraria;
import com.escola.service.TesourariaService;

@RestController
@CrossOrigin(origins = "*")
public class TesourariaController {

    @Autowired
    private TesourariaService tesoureiroService;
    
    @PostMapping("/cadastrar-tesoureiros")
    public ResponseEntity<List<Tesouraria>> cadastrarListaTesoureiros(@RequestBody List<Tesouraria> tesoureiros) {
        List<Tesouraria> cadastrados = tesoureiroService.cadastrarListaTesoureiros(tesoureiros);
        return ResponseEntity.ok(cadastrados);
    }

    @GetMapping("/listar-tesoureiros")
    public ResponseEntity<List<Tesouraria>> listarTodos() {
        List<Tesouraria> tesoureiros = tesoureiroService.listarTodos();
        return ResponseEntity.ok(tesoureiros);
    }

    // Outros endpoints para cadastrar, atualizar, deletar, buscar por ID, etc.
}

