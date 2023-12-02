package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.PrecoPropina;

@Repository
public interface PrecoPropinaRepository extends JpaRepository<PrecoPropina, Long>{
	public Optional<PrecoPropina> findByIdCursoAndNivel(Long idCurso, String nivel);

}
