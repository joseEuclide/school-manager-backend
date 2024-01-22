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
	   Optional<List<ProfessorDisciplinasTurma>>  dados = pdtr.findByIdProfAndIdTurma(idProf, idTurma);
	   Set<Disciplina> disciplinas2 = new HashSet<>();
	   if(dados.isPresent()){
		   System.out.println("Tem disciplinas");
    	   
    	   List<ProfessorDisciplinasTurma>  dadosProf = dados.get();
    	   System.out.println("*******************"+dadosProf.toString());
    	   Set<String> listaDisciplinas = new HashSet<>();
    	   for(ProfessorDisciplinasTurma d : dadosProf) {
    		   System.out.println("Turma: "+d.getIdTurma());
    		   System.out.println("Disciplinas: "+d.getDisciplinas().toString());
    		   listaDisciplinas.addAll(d.getDisciplinas());
    		   
    	   }
    	   System.out.println("============> listaDisciplinas: "+listaDisciplinas);
    	   
    	   Optional<Turma> turma =  tr.findById(idTurma);
    	   if(turma.isPresent()) {
    		   System.out.println("Entrou na Turma");
    		   System.out.println("Curso: "+turma.get().getCurso());
    		   System.out.println("Nivel: "+turma.get().getNivel());
    		   ArrayList<Disciplina> disciplinas =  dr.findByCursoAndNivel(turma.get().getCurso(), turma.get().getNivel());
    		   
    		   for(Disciplina cadaC : disciplinas) {
    			   System.out.println("Disciplina"+cadaC.getNome());
    		   }
    		   
    		   if(disciplinas != null) {
    			   System.out.println("Tem Disciplinas: ");
    	    	   for(Disciplina d : disciplinas) {
    	    		   System.out.println(" Disciplina: "+d.getNome());
    	    		   sair:
    	    		   for(String d2 :listaDisciplinas) {
    	    			   System.out.println("d2 ="+d2+ "--- d.getNome = "+d.getNome());
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
