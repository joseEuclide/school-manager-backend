package com.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Aluno;
import com.escola.model.Recurso;
import com.escola.model.Turma;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long>{
	public  List<Recurso> findByAlunoIdAndTurmaId(Aluno aluno, Turma turma);

}
