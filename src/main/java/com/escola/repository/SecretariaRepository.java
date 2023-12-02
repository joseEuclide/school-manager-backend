package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Secretaria;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
	public Optional<Secretaria> findByBi(String bi);
    // Você pode adicionar métodos personalizados de consulta, se necessário
}
