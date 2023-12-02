package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	// Encontrar o BI de Um Professor
		  @Query("SELECT p.bi FROM Professor p WHERE p.bi = :bi")
		  public Optional<String> findBiByBi(@Param("bi") String bi);
		  
		  public Optional<Professor> findByBi(String bi);
}
