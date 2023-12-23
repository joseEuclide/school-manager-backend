package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Secretaria;
import com.escola.service.SecretariaService;

@RestController
@CrossOrigin(origins = "*")
public class SecretariaController {

    @Autowired
    private SecretariaService secretarioService;

    
    @PostMapping("/cadastrar-secretarios")
    public ResponseEntity<List<Secretaria>> cadastrarListaSecretarios(@RequestBody List<Secretaria> secretarios) {
        List<Secretaria> cadastrados = secretarioService.cadastrarListaSecretarios(secretarios);
        return ResponseEntity.ok(cadastrados);
    }
    
    
    @GetMapping("/listar-secretarios")
    public ResponseEntity<List<Secretaria>> listarTodos() {
        List<Secretaria> secretarios = secretarioService.listarTodos();
        return ResponseEntity.ok(secretarios);
    }

    // Outros endpoints para cadastrar, atualizar, deletar, buscar por ID, etc.
}

