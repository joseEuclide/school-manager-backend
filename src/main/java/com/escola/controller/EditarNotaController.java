package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.EditarNota;
import com.escola.service.EditarNotaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/editar-notas")
public class EditarNotaController {
	
	
    @Autowired
    private EditarNotaService editarNotaService;

    @GetMapping
    public List<EditarNota> listarEditarNotas() {
        return editarNotaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditarNota> obterEditarNotaPorId(@PathVariable Long id) {
        EditarNota editarNota = editarNotaService.obterPorId(id);
        if (editarNota != null) {
            return ResponseEntity.ok(editarNota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EditarNota> criarEditarNota(@RequestBody EditarNota editarNota) {
        EditarNota novaEditarNota = editarNotaService.criarEditarNota(editarNota);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEditarNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEditarNota(@PathVariable Long id) {
        editarNotaService.removerEditarNota(id);
        return ResponseEntity.noContent().build();
    }
}
