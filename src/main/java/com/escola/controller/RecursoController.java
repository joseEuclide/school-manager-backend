package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Aluno;
import com.escola.model.Recurso;
import com.escola.model.Turma;
import com.escola.service.RecursoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/recursos")
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<Recurso>> listarRecursos() {
        List<Recurso> recursos = recursoService.listarRecursos();
        return ResponseEntity.ok(recursos);
    }

    @PostMapping
    public ResponseEntity<Recurso> cadastrarRecurso(@RequestBody Recurso recurso) {
        Recurso novoRecurso = recursoService.cadastrarRecurso(recurso);
        return ResponseEntity.ok(novoRecurso);
    }
    
    @GetMapping("/aluno/{alunoId}/turma/{turmaId}")
    public ResponseEntity<List<Recurso>> encontrarRecursosPorAlunoETurma(
            @PathVariable Aluno aluno,
            @PathVariable Turma turma) {
        List<Recurso> recursos = recursoService.encontrarRecursosPorAlunoETurma(aluno, turma);
        return ResponseEntity.ok(recursos);
    }

}

