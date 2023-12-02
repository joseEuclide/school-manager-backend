package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Aluno;
import com.escola.model.Propina;
import com.escola.model.Turma;

@Repository
public interface PropinaRepository extends JpaRepository<Propina, Long>{
   public Optional<Propina>  findByAlunoAndTurma(Aluno aluno,Turma turma);
}
