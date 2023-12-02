package com.escola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	public Optional<Admin> findByBi(String bi);
    // Você pode adicionar métodos personalizados de consulta, se necessário
}

