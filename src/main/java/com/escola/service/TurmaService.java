package com.escola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.TurmaDTO;
import com.escola.dto.TurmaDTO2;
import com.escola.model.Curso;
import com.escola.model.Disciplina;
import com.escola.model.Turma;
import com.escola.repository.CursoRepository;
import com.escola.repository.TurmaRepository;

@Service
public class TurmaService {
    //private final AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository tr;
    
    @Autowired
    private CursoRepository cr;
    
    @Autowired
    private DisciplinaService ds;
    
 
    
    public String cadastrarTurma(TurmaDTO turmaDTO) {
 
        Optional<Curso> curso2 = cr.findById(turmaDTO.getCursoId());
        boolean primariaOuSecundaria = false;
        Curso c4 = null;
        if(curso2.isPresent()) {
        	//Optional<Turma>  turma2 = tr.findByNomeAndCurso(turmaDTO.getNome(), curso2.get());
        	Optional<Turma>  turma2 = tr.findByCursoAndNome(curso2.get(), turmaDTO.getNome());
        	if(turma2.isPresent()) {
            	return "Ja Existe Uma Turma Com O Nome de "+
                turmaDTO.getNome()+" No Curso de "+curso2.get().getNome();
            }else {
            	 Turma turma = new Turma();
                 turma.setNome(turmaDTO.getNome());
                 turma.setCurso(curso2.get());
                 turma.setNivel(turmaDTO.getNivel());
                 turma.setTurno(turmaDTO.getTurno());
                 
                 if((turmaDTO.getNivel().equalsIgnoreCase("1")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("2")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("3")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("4")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("5")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("6")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("7")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("8")) ||
                    (turmaDTO.getNivel().equalsIgnoreCase("9")) ) {
                	 
                	 primariaOuSecundaria = true;
                	 boolean temCursoNenhum = false;
                	 List<Curso> cursos = cr.findAll();
                	 if(cursos != null) {
                		 sair:
                		 for(Curso c :cursos) {
                			 if(c.getNome().equalsIgnoreCase("nenhum")) {
                				 temCursoNenhum = true;
                				 c4 = c;
                				 break sair;
                			 }
                		 }
                		 if(!temCursoNenhum) {
                			 Curso c2 = new Curso();
                			 c2.setNome("nenhum");
                			 c4 =cr.saveAndFlush(c2);
                		 }
                	 }
                	 
                 }
                 
                ArrayList<Disciplina> disciplinasdoCursoENivel = null;
                if(primariaOuSecundaria) {
                	
                	 disciplinasdoCursoENivel = ds.todasDisciplinasDeUmCurso(c4.getId(), turmaDTO.getNivel());
                }else {
                	 disciplinasdoCursoENivel = ds.todasDisciplinasDeUmCurso(curso2.get().getId(), turmaDTO.getNivel());
                }
               
         		ArrayList<String> nomesDasDisciplinas = new ArrayList<>();
         		for(Disciplina cadaC : disciplinasdoCursoENivel) {
         			nomesDasDisciplinas.add(cadaC.getNome());
         		}
         		
                turma.setDisciplinas(nomesDasDisciplinas);
                tr.saveAndFlush(turma);
                return "A Turma "+ turmaDTO.getNome()+" Foi Cadastrada Com Sucesso "
                		+ "No Curso de "+curso2.get().getNome();
                        
            }
        
        }else {
        	return "O Curso Informado Não Existe Ma Escola";
        }
        
       
    }
	
	
	public List<Turma> todosTurmas() {
		return tr.findAll();
	}
	public List<String> todosTurmas2() {
		List<Turma> turmas = tr.findAll();
		ArrayList<String> nomesTurmas = new ArrayList<>(); 
		for(Turma turma : turmas) {
			nomesTurmas.add(turma.getNome());
		}
		return nomesTurmas;
	}
	
	// Lista das Disciplinas de Uma Turma
	public List<String> disciplinasDaTurma(Long idTurma) {
		Optional<Turma> turma =  tr.findById(idTurma);
		if(turma.isPresent()) {
			return turma.get().getDisciplinas();
		}else { return null; }
		
	}
	
	public List<Turma> todasTurmasDeUmCurso(Long idCurso) {
		Optional<Curso> cursoBD = cr.findById(idCurso);
		if(cursoBD.isPresent()) {
			return tr.findByCurso(cursoBD.get());
		}else {return null;}
		
	}
	
	public List<Turma> listarTurmasPorCursosNiveisETurnos(List<Curso> cursos, List<String> niveis, List<String> turnos) {
        return tr.findByCursoInAndNivelInAndTurnoIn(cursos, niveis, turnos);
    }
	
   public List<TurmaDTO2> listarTurmasPorCursosNiveisETurnos2(List<Curso> cursos, List<String> niveis, List<String> turnos) {
        
		List<Turma> listaDeTurmas = tr.findByCursoInAndNivelInAndTurnoIn(cursos, niveis, turnos);
		List<TurmaDTO2> t2 = new ArrayList<>();
		if(listaDeTurmas != null) {
			for(Turma turma : listaDeTurmas) {
				TurmaDTO2 t = new TurmaDTO2();
				t.setId(turma.getId());
				t.setNome(turma.getNome());
				t.setDisciplinas(turma.getDisciplinas());
				t2.add(t);
			}
			return t2;
		}else {
			return null;
		}
		
		
    }
	
	public Curso listarCursoDaTurma(Long turmaId) {
		Optional<Curso> curso =  tr.findCursoByTurmaId(turmaId);
		if(curso.isPresent()) {
			return curso.get();
		}else { return null; }
         
    }
	
	public Turma actualizarTurma(Long id) {
		Optional<Turma> TurmaBD =  tr.findById(id);
		if(TurmaBD.isPresent()) {
			return tr.save(TurmaBD.get());
		}else {
			return null;
		}
		
		
	}
	
	public Boolean deletarTurma(Long id) {
		Optional<Turma> TurmaBD =  tr.findById(id);
		if(TurmaBD.isPresent()) {
			 tr.deleteById(id);
			 return true;
		}else {
			return false;
		}
		
		
	}
	

}
