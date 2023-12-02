package com.escola.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Disciplina;
import com.escola.model.ProfessorDisciplinasTurma;
import com.escola.model.Turma;
import com.escola.repository.DisciplinaRepository;
import com.escola.repository.ProfessorDisciplinasTurmaRepository;
import com.escola.repository.TurmaRepository;

@Service
public class ProfessorDisciplinasTurmaService {

    @Autowired
    private ProfessorDisciplinasTurmaRepository pdtr;
    
    @Autowired
    private TurmaRepository tr;
    
    @Autowired
    private DisciplinaRepository dr;

    public String cadastrarListaProfessorDisciplinasTurma(List<ProfessorDisciplinasTurma> professorDisciplinasTurmaList) {
        if(professorDisciplinasTurmaList != null) {
           pdtr.saveAll(professorDisciplinasTurmaList);
           return "O Professor Foi Cadastrado Com Sucesso !";
        }else {
        	return "O Professor Não Foi Cadastrado, Selecione As Turmas e as Disciplinas"
        			+ " Onde PRetendes Cadastrá-lo !";
        }
    	
    }
    
   public Set<Disciplina> disiciplinasDoProfessor(Long idProf, Long idTurma){
	   Optional<List<ProfessorDisciplinasTurma>>  dados = pdtr.findDisciplinasByIdProfAndIdTurma(idProf, idTurma);
	   Set<Disciplina> disciplinas2 = new HashSet<>();
	   if(dados.isPresent()){
    	   
    	   List<ProfessorDisciplinasTurma>  dadosProf = dados.get();
    	   Set<String> listaDisciplinas = new HashSet<>();
    	   for(ProfessorDisciplinasTurma d : dadosProf) {
    		   listaDisciplinas.addAll(d.getDisciplinas());
    		   
    	   }
    	   
    	   Optional<Turma> turma =  tr.findById(idTurma);
    	   if(turma.isPresent()) {
    		   ArrayList<Disciplina> disciplinas =  dr.findByCursoAndNivel(turma.get().getCurso(), turma.get().getNivel());
    		   
    		   if(disciplinas != null) {
    	    	   for(Disciplina d : disciplinas) {
    	    		   sair:
    	    		   for(String d2 :listaDisciplinas) {
    	    			   if(d.getNome().equalsIgnoreCase(d2)) {
    	    				   disciplinas2.add(d);
    	    				   break sair;
    	    			   }
    	    		   }
    	    	   }
    	       }
    	   }
    	   
       }
	   return disciplinas2;
   }
    
    public List<ProfessorDisciplinasTurma> listarTudo() {
    	return pdtr.findAll();
    }

    // Outros métodos de serviço conforme necessário
}
