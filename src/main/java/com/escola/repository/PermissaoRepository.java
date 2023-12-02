package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Permissao;import com.escola.model.Professor;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	public Optional<Professor> findByProfessorPermissoes(Professor prof);
	public Optional<Permissao> findByIdProf(Long idProf);
}
