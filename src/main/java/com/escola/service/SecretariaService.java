package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Secretaria;
import com.escola.repository.SecretariaRepository;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretarioRepository;

    public List<Secretaria> listarTodos() {
        return secretarioRepository.findAll();
    }
    
    public List<Secretaria> cadastrarListaSecretarios(List<Secretaria> secretarios) {
        return secretarioRepository.saveAll(secretarios);
    }

    // Outros métodos de serviço conforme necessário
}

