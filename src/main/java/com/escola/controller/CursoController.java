package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Curso;
import com.escola.service.CursoService;


/**
 * Classe Responsavel por Controlar Todas Requisicoes Da APP
 * 
 * 
 * @author Jose Euclides - Programador
 * @version 1.0
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite CORS para este controlador
public class CursoController {

    @Autowired
    CursoService cs;
    

    @PostMapping(value =  "/cadastrar-Curso",produces = "application/json")
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoCadastrado = cs.cadastrar(curso);
        return ResponseEntity.ok(cursoCadastrado);
    }
    
    @GetMapping(value =  "/todos-cursos", produces = "application/json")
    public ResponseEntity< List<Curso>> todosCursos() {
        List<Curso> cursos = cs.todosCursos();
        return ResponseEntity.ok(cursos);
    }
    
    
    

    // Outros endpoints relacionados a alunos, se necessário
}
