package com.escola.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
	
	// Listar todos os Cursos apartir de uma lista de Ids
	public List<Curso> findByIdIn(List<Long> cursoIds);
	
	public Optional<Curso> findByNome(String nome);
}
