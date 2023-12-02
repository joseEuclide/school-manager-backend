package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Tesouraria;

@Repository
public interface TesourariaRepository extends JpaRepository<Tesouraria, Long> {
	public Optional<Tesouraria> findByBi(String bi);
    // Você pode adicionar métodos personalizados de consulta, se necessário
}

