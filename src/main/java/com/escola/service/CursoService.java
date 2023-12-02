package com.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Curso;
import com.escola.repository.CursoRepository;

@Service
public class CursoService {
    //private final AlunoRepository alunoRepository;

	@Autowired
    private CursoRepository cr;
	
	public Curso cadastrar(Curso curso) {
		Optional<Curso> curso2 =cr.findByNome(curso.getNome());
		if(curso2.isPresent()) {
			return new Curso();
		}else {
			return cr.save(curso);
		}
		
		 
	}
	
	
	public List<Curso> todosCursos() {
		return cr.findAll();
	}
	
	// Listar Todos os Cursos Apartir de uma lista de IDs
	public List<Curso> obterCursosPorIds(List<Long> cursoIds) {
        return cr.findByIdIn(cursoIds);
    }
	
	public Curso actualizarCurso(Long id) {
		Optional<Curso> cursoBD =  cr.findById(id);
		if(cursoBD.isPresent()) {
			return cr.save(cursoBD.get());
		}else {
			return null;
		}
		
		
	}
	
	public Boolean deletarCurso(Long id) {
		Optional<Curso> cursoBD =  cr.findById(id);
		if(cursoBD.isPresent()) {
			 cr.deleteById(id);
			 return true;
		}else {
			return false;
		}
		
		
	}
	
	


}
