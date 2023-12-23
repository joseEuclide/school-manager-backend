package com.escola.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Aluno;
import com.escola.model.Nota;
import com.escola.model.Turma;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
   
	public List<Nota> findByAluno(Aluno aluno);
	public List<Nota> findAllByTurma(Turma turma);
	public Optional<Nota> findByIdAlunoAndTurma(Long idAluno,Turma turma);
	public List<Nota> findByTurmaAndIdAluno(Turma turma,Long idAluno);
	public Optional<Nota> findByIdAlunoAndTurmaAndIdDisciplina(Long idAluno,Turma turma, Long idDisciplina);
	public List<Nota> findByTurmaAndIdDisciplina(Turma turma, Long idDisciplina);
}
