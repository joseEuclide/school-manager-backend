package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Salario;
import com.escola.repository.SalarioRepository;

@Service
public class SalarioService {
    private final SalarioRepository salarioRepository;

    @Autowired
    public SalarioService(SalarioRepository salarioRepository) {
        this.salarioRepository = salarioRepository;
    }

    public List<Salario> realizarPagamento(List<Salario> salarios) {
        // Implemente a lógica para realizar o pagamento, calcular o valor, definir a data, etc.
        return salarioRepository.saveAll(salarios);
    }

    // Outros métodos relacionados a salários, se necessário
}
