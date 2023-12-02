package com.escola.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.model.Aluno;
import com.escola.model.Turma;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
   
	public ArrayList<Aluno> findByTurma(Turma turma);
	@Query("SELECT a.bi FROM Aluno a WHERE a.bi = :bi")
    Optional<String> findBiByBi(@Param("bi") String bi);
}
