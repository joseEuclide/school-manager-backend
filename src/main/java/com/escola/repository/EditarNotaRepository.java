package com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.EditarNota;

@Repository
public interface EditarNotaRepository extends JpaRepository<EditarNota, Long> {
}
