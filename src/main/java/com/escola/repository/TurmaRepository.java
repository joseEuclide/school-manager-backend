package com.escola.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.model.Curso;
import com.escola.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
	  List<Turma> findByCurso(Curso curso);
	  
	  // Listar o Curso de Uma Truma
	  
	  @Query("SELECT t.curso FROM Turma t WHERE t.id = :turmaId")
	    Optional<Curso> findCursoByTurmaId(@Param("turmaId") Long turmaId);
	  
      // saber O Nivel De Uma Turma
	  @Query("SELECT t.nivel FROM Turma t WHERE t.id = :turmaId")
	    String findNivelByTurmaId(@Param("turmaId") Long turmaId);
	  
	// Listar O Turno De Uma Turma
		  @Query("SELECT t.turno FROM Turma t WHERE t.id = :turmaId")
		    String findTurnoByTurmaId(@Param("turmaId") Long turmaId);
	  
	  // listar todas turmas de um lista de cursos uma lista de niveis e uma lista de turnos
	  List<Turma> findByCursoInAndNivelInAndTurnoIn(List<Curso> cursos, List<String> niveis, List<String> turnos);

	  // Encontrar uma Turma com pelo Curso e Nome da turma
	  Optional<Turma> findByCursoAndNome(Curso curso, String nome);
}