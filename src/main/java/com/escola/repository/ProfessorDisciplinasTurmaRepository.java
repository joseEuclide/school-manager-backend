package com.escola.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.ProfessorDisciplinasTurma;

@Repository
public interface ProfessorDisciplinasTurmaRepository extends JpaRepository<ProfessorDisciplinasTurma, Long>{
   
    Optional<List<ProfessorDisciplinasTurma>> findDisciplinasByIdProfAndIdTurma(Long idProf,Long idTurma);
    Optional<List<ProfessorDisciplinasTurma>> findByIdProf(Long idProf);
}
