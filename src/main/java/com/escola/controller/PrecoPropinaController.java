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
import com.escola.model.PrecoPropina;
import com.escola.service.CursoService;
import com.escola.service.PrecoPropinaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite CORS para este controlador
public class PrecoPropinaController {
    @Autowired
    private PrecoPropinaService pps;
    
    @Autowired
    private CursoService cs;

 
    @GetMapping(value =  "/listar-cursos", produces = "application/json")
    public ResponseEntity< List<Curso>> todosCursos() {
        List<Curso> cursos = cs.todosCursos();
        return ResponseEntity.ok(cursos);
    }
    
    @PostMapping(value="/precos-propina", consumes="application/json",produces="application/json")
    public ResponseEntity<String> cadastrarRecurso(@RequestBody PrecoPropina precoPropina) {
    	String rertorno = pps.cadastrarPRecoPropina(precoPropina);
        return ResponseEntity.ok(rertorno);
    }
    


}
