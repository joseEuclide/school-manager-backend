package com.escola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.DisciplinaDTO;
import com.escola.model.Curso;
import com.escola.model.Disciplina;
import com.escola.model.Turma;
import com.escola.repository.CursoRepository;
import com.escola.repository.DisciplinaRepository;
import com.escola.repository.TurmaRepository;

@Service
public class DisciplinaService {
	// private final AlunoRepository alunoRepository;

	@Autowired
	private DisciplinaRepository dr;

	@Autowired
	private CursoRepository cr;
	
	@Autowired
	private TurmaRepository tr;
	


	public String cadastrar( Long idCurso,List<DisciplinaDTO> disciplinaDTO) {

		Optional<Curso> curso = cr.findById(idCurso);
		boolean continuar = true;
		String retorno = "";
		if (curso.isPresent() && disciplinaDTO != null) {
			
			
				
				for (DisciplinaDTO disciplinaDTO2 : disciplinaDTO) {
					if(disciplinaDTO2.getNiveis() != null) {
						for(String nivel : disciplinaDTO2.getNiveis()) {
							
							Disciplina d = new Disciplina();
							d.setCurso(curso.get());
							d.setNivel(nivel);
							d.setNome(disciplinaDTO2.getNome());
							
							// Saber se ja existe uma disciplina com o mesmo nome
							Optional<Disciplina> disc =  dr.findByNomeAndCursoAndNivel(d.getNome(),curso.get(),d.getNivel());
							
							continuar = true;
							if( disc.isPresent()) {			
								continuar = false;
							}
							
							if(continuar) {
								dr.saveAndFlush(d);
								retorno = "Disciplina(as) Cadastrada com sucesso no Curso de "+curso.get().getNome();
								// Essa ideia é para sectar a disciplina nas respectivas turmas do mesmo nivel
								List<Turma>  turmas = tr.findAll();
								if(turmas != null) {
									for(Turma turma : turmas) {
										sair:
										if(turma.getNivel().equalsIgnoreCase(nivel)) {
											ArrayList<String> disciplinas3 = turma.getDisciplinas();
											for(String disci : disciplinas3) {
												if(disci.equalsIgnoreCase(disciplinaDTO2.getNome())) {
													System.out.println("Entrou aqui");
													break sair;
												}
											}
											
											
											turma.getDisciplinas().add(disciplinaDTO2.getNome());
											tr.saveAndFlush(turma);
											
										}
									}
								}
							}
							
							
						}
					}
				}
				
			
			
			return retorno;
		} else {
			return "Falha ao Cadastrar Por 2 Motivos \n 1. O Curso Informado Nao existe na Escola\n Informe as Disciplinas que deseja Cadastrar ";
		}

	}

	public List<Disciplina> todosDisciplinas() {
		return dr.findAll();
	}

	public ArrayList<Disciplina> todasDisciplinasDeUmCurso(Long idCurso,String nivel) {
		Optional<Curso> curso = cr.findById(idCurso);
		if(curso.isPresent()) {
			System.out.println("Tem Curso");
			return dr.findByCursoAndNivel(curso.get(), nivel);
		}else {
			System.out.println("Nao Tem Curso");
			return null;}
		
	}
	
	public ArrayList<String> todasDisciplinasDeUmCurso2(Long idCurso,String nivel) {
		Optional<Curso> curso = cr.findById(idCurso);
		if(curso.isPresent()) {
			System.out.println("Tem Curso");
			ArrayList<Disciplina> cursos =  dr.findByCursoAndNivel(curso.get(), nivel);
			ArrayList<String> disciplinas = new ArrayList<>();
			for(Disciplina disciplina : cursos) {
				disciplinas.add(disciplina.getNome());
			}
			return disciplinas;
		}else {
			System.out.println("Nao Tem Curso");
			return null;}
		
	}

	public List<String> todosNiveisDeUmaDisciplina(String disciplina) {
		return dr.findByNivel(disciplina);
	}

	public Disciplina actualizarDisciplina(Long id) {
		Optional<Disciplina> disciplinaBD = dr.findById(id);
		if (disciplinaBD.isPresent()) {
			return dr.save(disciplinaBD.get());
		} else {
			return null;
		}

	}

	public Boolean deletarDisciplina(Long id) {
		Optional<Disciplina> disciplinaBD = dr.findById(id);
		if (disciplinaBD.isPresent()) {
			dr.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}
