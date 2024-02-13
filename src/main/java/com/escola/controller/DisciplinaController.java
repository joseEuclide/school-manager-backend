package com.escola.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.DisciplinaDTO;
import com.escola.model.Disciplina;
import com.escola.service.DisciplinaService;
import com.escola.dto.DisciplinaDTO;


/**
 * Classe Responsavel por Controlar Todas Requisicoes Da APP
 * 
 * 
 * @author Jose Euclides - Programador - 
 * @version 1.0
 *
 */

@RestController
@CrossOrigin(origins = "*")
public class DisciplinaController {

    @Autowired
    DisciplinaService ds;
    

    @PostMapping(value =  "/cadastrar-disciplina/{idCurso}", consumes = "application/json",produces = "application/json")
    public ResponseEntity<DisciplinaDTO> cadastrarDisciplina(@RequestBody List<DisciplinaDTO> disciplinaDTO, /*@RequestBody Disciplina disciplina,*/ @PathVariable Long idCurso) {
        String estadoDeCadastro = ds.cadastrar(idCurso,disciplinaDTO);
        DisciplinaDTO d = new DisciplinaDTO();
        d.setMensagem(estadoDeCadastro);
        return ResponseEntity.ok(d);
    }
     
  
    @GetMapping("/{cursoId}/{nivel}/disciplinas/")
    public ResponseEntity<List<String>> listarDisciplinasDoCurso(@PathVariable Long cursoId,@PathVariable String nivel) {
        List<String> disciplinas = ds.todasDisciplinasDeUmCurso2(cursoId, nivel);
        return ResponseEntity.ok(disciplinas);
    }
    

    // Outros endpoints relacionados a alunos, se necessário
}
