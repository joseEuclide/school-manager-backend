package com.escola.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.ProfessorDetalheDTO;
import com.escola.model.Curso;
import com.escola.model.Permissao;
import com.escola.model.Professor;
import com.escola.model.ProfessorDisciplinasTurma;
import com.escola.model.Turma;
import com.escola.repository.CursoRepository;
import com.escola.repository.PermissaoRepository;
import com.escola.repository.ProfessorDisciplinasTurmaRepository;
import com.escola.repository.ProfessorRepository;
import com.escola.repository.TurmaRepository;

@Service
public class ProfessorService {
   
	@Autowired 
	private ProfessorRepository pr;
	
	@Autowired 
	private ProfessorDisciplinasTurmaRepository pdtr;

	@Autowired 
	private PermissaoRepository permissaoRepository;
	
	@Autowired 
	private CursoRepository cr;
	
	@Autowired
	private TurmaRepository tr;
    

	 public Professor cadastrarProfessor(Professor professor) {
		 Optional<String> prof = pr.findBiByBi(professor.getBi());
		 if(prof.isPresent()) {
			 return new Professor();
		 }else {
			 
			 Professor prof2 = pr.saveAndFlush(professor);
			 
			 // Sectando Que Esse Professor Receberá Autorizacoes de Lancar notas mais Tarde
			 Permissao profPErmissao =  new Permissao();
    		 profPErmissao.setProfessorPermissoes(prof2);
    		 profPErmissao.setIdProf(prof2.getId());
    		 permissaoRepository.saveAndFlush(profPErmissao);
    		 
    		 List<Curso> cursos = cr.findAll();
    		 ArrayList<Curso> cursos2 = new ArrayList<>();
    		 if(cursos !=null ) {
    			 for(Curso c :cursos) {
    				 cursos2.add(c);
        		 }
    		 }
    		 
    		 prof2.setCursos(cursos2);
			 return  prof2;
		 }
		 

	    }
	 
    public String cadastrarProfessor(Long idProf, List<ProfessorDisciplinasTurma> professorDTOs) {
    	if(!professorDTOs.isEmpty()) {
     			for(ProfessorDisciplinasTurma professor2 : professorDTOs) {
        			ProfessorDisciplinasTurma prof = new ProfessorDisciplinasTurma();
            		prof.setIdProf(idProf);
            		prof.setIdTurma(professor2.getIdTurma());
            		prof.setDisciplinas(professor2.getDisciplinas());
            		
            		pdtr.saveAndFlush(prof);
        		}
        		return "PRofessor Cadastrado Com Sucesso !";
     		
    		
    		
    	}else {
    		return "PRofessor Nao Cadastrado";
    	}

    }
        
    public List<Professor> listarProfessores() {
        return pr.findAll();
    }
    
    public Professor buscarProfessorPorId(Long id) {
        return pr.findById(id).orElse(null);
    }


    
    public void atribuirPermissao(Long professorId, Permissao permissao) {
        Optional<Professor> optionalProfessor = pr.findById(professorId);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            //professor.getPermissoes().add(permissao);
            pr.save(professor);
        }
    }
    
    public Set<Turma> listarTurmasDoProfessor(Long professorId) {
        Optional<Professor> optionalProfessor = pr.findById(professorId);
        Set<Turma> turmas = new HashSet<>();
        if (optionalProfessor.isPresent()) {
            //Professor professor = optionalProfessor.get();
        	Optional<List<ProfessorDisciplinasTurma>>  listaProfs = pdtr.findByIdProf(optionalProfessor.get().getId());
        	if(listaProfs.isPresent()) {
        		for(ProfessorDisciplinasTurma p : listaProfs.get()) {
        			
        			Optional<Turma> t = tr.findById(p.getIdTurma());
        			if(t.isPresent()) {
        				turmas.add(t.get());
        			}
        		}
        	}
        }
        return turmas; 
    }
    
    public ArrayList<ProfessorDetalheDTO> listarTurmasDoProfessor2(Set<Turma> turmas) {
    	    ArrayList<ProfessorDetalheDTO> turmasDoProfessor = new ArrayList<>();
        	if(turmas != null) {
        		for(Turma t : turmas) {
        			
        		    
        			
        			ProfessorDetalheDTO pDDTO = new ProfessorDetalheDTO();
        			pDDTO.setId(t.getId());
        			pDDTO.setCurso(t.getCurso().getNome());
        			pDDTO.setNome(t.getNome());
        			pDDTO.setTurno(t.getTurno());
        			pDDTO.setNivel(t.getNivel());
        			
        			turmasDoProfessor.add(pDDTO);
        		}
        	}
        
        return turmasDoProfessor; 
    }

    // Outros métodos relacionados a professores, se necessário
}