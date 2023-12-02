package com.escola.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Salario;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {
    
}
