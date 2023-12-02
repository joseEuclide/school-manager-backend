package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Aluno;
import com.escola.model.Recurso;
import com.escola.model.Turma;
import com.escola.repository.RecursoRepository;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> listarRecursos() {
        return recursoRepository.findAll();
    }

    public Recurso cadastrarRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }
    
    public List<Recurso> encontrarRecursosPorAlunoETurma(Aluno aluno, Turma turma) {
        return recursoRepository.findByAlunoIdAndTurmaId(aluno, turma);
    }

    // Outros métodos, como obter recurso por ID, atualizar, excluir, etc.
}

