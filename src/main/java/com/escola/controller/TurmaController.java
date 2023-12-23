package com.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.TurmaDTO;
import com.escola.model.CalendarioAulas;
import com.escola.model.CalendarioProvas;
import com.escola.model.Curso;
import com.escola.model.Turma;
import com.escola.service.CursoService;
import com.escola.service.TurmaService;

@RestController
@CrossOrigin(origins = "*")
public class TurmaController {
	
	@Autowired
    private TurmaService ts;
	
	@Autowired
    private CursoService cs;

   

    @PostMapping("/cadastrar-turma/{cursoId}")
    public ResponseEntity<String> cadastrarTurma(@RequestBody TurmaDTO turmaDTO, @PathVariable Long cursoId) {
        turmaDTO.setCursoId(cursoId);
    	String turma = ts.cadastrarTurma(turmaDTO);
        return ResponseEntity.ok(turma);
    }
    
    @GetMapping("/todas-turmas")
    public ResponseEntity<List<String>> listarTodasTurmas() {
        List<String> turmas = ts.todosTurmas2();
        return ResponseEntity.ok(turmas);
    }
    
    @GetMapping("/calendario-aulas/{turmaId}")
    public ResponseEntity<List<CalendarioAulas>> listarCalendarioAulasDaTurma(@PathVariable Long turmaId) {
        // Verifique se a turma com o ID especificado existe e tem permissão para ver o calendário de aulas.
        // Dependendo da sua lógica de autenticação e autorização, você pode implementar verificações aqui.

        //List<CalendarioAulas> calendarioAulas = ts.listarCalendarioAulasDaTurma(turmaId);

        return ResponseEntity.ok(null);
    }
    
    // Listar Calendario das Provas de Uma Turma
    
    @GetMapping("/{turmaId}/calendario-provas")
    public ResponseEntity<List<CalendarioProvas>> listarCalendarioProvasDaTurma(@PathVariable Long turmaId) {
        // Verifique se a turma com o ID especificado existe e tem permissão para ver o calendário de provas.
        // Dependendo da sua lógica de autenticação e autorização, você pode implementar verificações aqui.

        //List<CalendarioProvas> calendarioProvas = ts.listarCalendarioProvasDaTurma(turmaId);

        return ResponseEntity.ok(null);
    }
    
    @GetMapping("/filtrar-turmas")
    public ResponseEntity<List<Turma>> filtrarTurmas(
            @RequestParam("cursos") List<Long> cursoIds,
            @RequestParam("niveis") List<String> nivelIds,
            @RequestParam("turnos") List<String> turnoIds
    ) {
        // Aqui você precisa obter as entidades Curso, Nivel e Turno com base nos IDs (você precisa ter serviços para isso)
        List<Curso> cursos = cs.obterCursosPorIds(cursoIds);

        if (cursos.isEmpty() || nivelIds.isEmpty() || nivelIds.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Turma> turmasFiltradas = ts.listarTurmasPorCursosNiveisETurnos(cursos, nivelIds, turnoIds);
        return ResponseEntity.ok(turmasFiltradas);
    }
    
    @GetMapping("/curso-da-turma/{turmaId}")
    public ResponseEntity<Curso> listarCursoDaTurma(@PathVariable Long turmaId) {
        Curso curso = ts.listarCursoDaTurma(turmaId);
        return ResponseEntity.ok(curso);
    }
    
    @GetMapping("/disciplinas-da-turma/{turmaId}")
    public ResponseEntity<List<String>> disciplinasDaTurma(@PathVariable Long turmaId) {
    	List<String> disciplinas = ts.disciplinasDaTurma(turmaId);
        return ResponseEntity.ok(disciplinas);
    }
}
