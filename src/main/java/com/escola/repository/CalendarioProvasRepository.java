package com.escola.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.CalendarioProvas;

@Repository
public interface CalendarioProvasRepository extends JpaRepository<CalendarioProvas, Long> {
	 Optional<CalendarioProvas>  findByCursoAndTurnoAndNivel(Long curso, String turno, String nivel);

}
