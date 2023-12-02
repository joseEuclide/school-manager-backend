package com.escola.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.AlunoDTO;
import com.escola.dto.Relatorio;
import com.escola.model.Aluno;
import com.escola.model.Disciplina;
import com.escola.model.Nota;
import com.escola.model.Propina;
import com.escola.model.Turma;
import com.escola.repository.AlunoRepository;
import com.escola.repository.DisciplinaRepository;
import com.escola.repository.NotaRepository;
import com.escola.repository.PropinaRepository;
import com.escola.repository.TurmaRepository;

@Service
public class AlunoService {
    //private final AlunoRepository alunoRepository;

 
    
    @Autowired
    private TurmaRepository tr;
    
    @Autowired
    private AlunoRepository ar;
    
    @Autowired
    private PropinaRepository pr;
    
    @Autowired
	private NotaRepository nr;
    
    @Autowired
	private DisciplinaRepository dr;

    
    //@Autowired
    //private RelatorioService rs;
    
    public Relatorio cadastrar(AlunoDTO alunoDTO,Long idTurma) {
    	
    	Relatorio relatorio = new Relatorio();
    	relatorio.setRetorno(false);
    	Optional<Turma> turma = tr.findById(idTurma);
    	if(turma.isPresent()) {
    		Optional<String> bi_BD = ar.findBiByBi(alunoDTO.getBi());
    		
        	if(!bi_BD.isPresent()) {
        		Aluno aluno = new Aluno(alunoDTO.getNome(),alunoDTO.getBi());
        		aluno.setTurma(turma.get());
        		relatorio.setRetorno(true);
        		relatorio.setMensagem("Aluno Cadastrado Com Sucesso");
        		// relatorio.setRetorno(null);
        		Aluno aluno2 =ar.saveAndFlush(aluno);
        		
        		
        		
        		
        		ArrayList<Disciplina> disciplinasDaTurma = dr.findByCursoAndNivel(turma.get().getCurso(), turma.get().getNivel());
        		for(Disciplina cadaC : disciplinasDaTurma) {
        			
        			Nota nota2 = new Nota();
            		
            		nota2.setAluno(aluno2);	
            		nota2.setTurma(turma.get());
            		nota2.setIdAluno(aluno2.getId());
            		nota2.setIdDisciplina(cadaC.getId());
        			
            		nr.saveAndFlush(nota2);
        			System.out.println("====================================="+cadaC.getId());
        			
        			 
        		}
        		
        	
        		Propina p = new Propina();
        		p.setAluno(aluno2);
        		p.setTurma(turma.get());
        		pr.saveAndFlush(p);
				
        	}else {
        		relatorio.setMensagem("Ja Existe Um Aluno Cadastrado Com o BI = "+alunoDTO.getBi());
        	}
    	}
    	return relatorio;
    }
    
   public ArrayList<Aluno> alunosDaTurma(Long idTurma) {
    	
    	Optional<Turma> turmaBD =  tr.findById(idTurma);
        if(turmaBD.isPresent()) {
        	System.out.println("Existe Turma Com Esse ID");
        	Turma turma = turmaBD.get();
        	ArrayList<Aluno>  alunosDaTurma = ar.findByTurma(turma);
        	return alunosDaTurma;
        	
        }else {
        	return null;
        }
    }
   
   public Aluno obterAlunoPorId(Long alunoId) {
       // Consulte o aluno por ID no banco de dados
       Optional<Aluno> alunoOptional = ar.findById(alunoId);

       if (!alunoOptional.isPresent()) {
           return null;
       }else {return alunoOptional.get(); }

       
       
   }
  


}
