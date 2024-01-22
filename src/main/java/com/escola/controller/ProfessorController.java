package com.escola.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.ApiResponse;
import com.escola.dto.NotaDTO;
import com.escola.dto.ProfessorDTO2;
import com.escola.dto.ProfessorDetalheDTO;
import com.escola.dto.TurmaDTO2;
import com.escola.model.Aluno;
import com.escola.model.Curso;
import com.escola.model.Disciplina;
import com.escola.model.Nota;
import com.escola.model.Professor;
import com.escola.model.ProfessorDisciplinasTurma;
import com.escola.model.Turma;
import com.escola.service.CursoService;
import com.escola.service.NotaService;
import com.escola.service.ProfessorDisciplinasTurmaService;
import com.escola.service.ProfessorService;
import com.escola.service.TurmaService;

@RestController
@CrossOrigin(origins = "*")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private NotaService ns;
    
    @Autowired
    private CursoService cs;
    
    @Autowired
    private TurmaService ts;
    
    @Autowired
    private ProfessorDisciplinasTurmaService pdts;
    
    @PostMapping(value =  "/cadastrar-Professor", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {
    	Professor prof =  professorService.cadastrarProfessor(professor);
        return ResponseEntity.ok(prof);
    }
    /*@PostMapping(value =  "/cadastrar-Professor", consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> cadastrarProfessor(@RequestBody Professor professor, @RequestBody List<ProfessorDisciplinasTurma> professorDTOs) {
    	String prof =  professorService.cadastrarProfessor(professor, professorDTOs);
        return ResponseEntity.ok(prof);
    }*/

    
    
    @GetMapping("/filtrar-turmas-para-o-professor")
    public ResponseEntity<List<TurmaDTO2>> filtrarTurmas(
            @RequestParam("cursos") List<Long> cursoIds,
            @RequestParam("niveis") List<String> nivelIds,
            @RequestParam("turnos") List<String> turnoIds
    ) {
        // Aqui você precisa obter as entidades Curso, Nivel e Turno com base nos IDs (você precisa ter serviços para isso)
        List<Curso> cursos = cs.obterCursosPorIds(cursoIds);

        if (cursos.isEmpty() || nivelIds.isEmpty() || nivelIds.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        List<TurmaDTO2> turmasFiltradas = ts.listarTurmasPorCursosNiveisETurnos2(cursos, nivelIds, turnoIds);
        return ResponseEntity.ok(turmasFiltradas);
    }  
     
    @PostMapping(value = "/cadastrar-Professor-2", consumes = "application/json",produces = "application/json")
    public ResponseEntity<ApiResponse> cadastrarListaProfessorDisciplinasTurma(@RequestBody List<ProfessorDisciplinasTurma> professorDisciplinasTurmaList) {
        String cadastrados = pdts.cadastrarListaProfessorDisciplinasTurma(professorDisciplinasTurmaList);
        return ResponseEntity.ok(new ApiResponse(cadastrados));
    }
    
    @GetMapping("/listar-Dados-Dos-Professores")
    public ResponseEntity<List<ProfessorDisciplinasTurma>> listarTodasTurmas() {
        List<ProfessorDisciplinasTurma> dados = pdts.listarTudo();
        return ResponseEntity.ok(dados);
    }
    
    @GetMapping("/listar-disciplinas-Do-Prof/{idProf}/{idTurma}")
    public ResponseEntity<Set<Disciplina>> disciplinasDoProf(@PathVariable Long idProf, @PathVariable Long idTurma) {
    	Set<Disciplina> dados = pdts.disiciplinasDoProfessor(idProf, idTurma);
        return ResponseEntity.ok(dados);
    }
    
    
    
    @GetMapping("/buscar-um-professor/{id}")
    public ResponseEntity<Professor> listarProfessorPorId(@PathVariable Long id) {
        Professor professor = professorService.buscarProfessorPorId(id);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/listar-turmas-do-professor/{idProfessor}")
    public ResponseEntity<ArrayList<ProfessorDetalheDTO>> listarTurmasDoProfessor(@PathVariable Long idProfessor) {
    	Set<Turma> turmasDoProfessor = professorService.listarTurmasDoProfessor(idProfessor);
    	ArrayList<ProfessorDetalheDTO> turmas = professorService.listarTurmasDoProfessor2(turmasDoProfessor);
    	return ResponseEntity.ok(turmas);
    }
    /*
    @PostMapping("/atribuir-permissao/{professorId}")
    public ResponseEntity<String> atribuirPermissao(
            @PathVariable Long professorId,
            @RequestBody Permissao permissao
    ) {
        professorService.atribuirPermissao(professorId, permissao);
        return ResponseEntity.ok("Permissão atribuída com sucesso.");
    }
    
    */  
    
    
    @PostMapping(value =  "/lancar-notas-turma/{idTurma}/{idProf}/{idDisciplina}", consumes = "application/json",produces = "application/json")
    public ResponseEntity<ProfessorDTO2> lancarNotasDeUmaTurma(@PathVariable Long idTurma,@PathVariable Long idProf,@PathVariable Long idDisciplina ,@RequestBody List<NotaDTO> notaDto) {
    	String mensagem = ns.lançarNotasParaDisciplina(idProf, idTurma, idDisciplina, notaDto);
        
    	ArrayList<Aluno> notasDosAlunos = new ArrayList<>();
    	
    	List<Nota> notas =  ns.listarNotasPorTurmahDisciplina(idTurma, idDisciplina);
    	int j;
    	for(int i=0; i< notas.size();i++) {
    		j = i + 1;
    		System.out.println("entrou no aluno.....");
    		System.out.println(" aluno "+j);
    		Aluno aluno = new Aluno();
    		
    		aluno.setNota(notaDto.get(i).getNotaDoAluno());
    		aluno.setNome(notas.get(i).getAluno().getNome());
    		notasDosAlunos.add(aluno);
    		
    		
    	}
    	
    	ProfessorDTO2 pd2 = new ProfessorDTO2();
    	pd2.setMensagem(mensagem);
    	if(mensagem.contains("notas Lançadas Com Sucesso")) {
    		pd2.setNotas(notasDosAlunos);
    	}else {
    		pd2.setNotas(null);
    	}
    	
    	return ResponseEntity.ok(pd2);
    }
 
    
    

    // Outros endpoints relacionados a professores, se necessário
}
