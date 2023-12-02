package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.EditarNota;
import com.escola.repository.EditarNotaRepository;

@Service
public class EditarNotaService {
	
	
    @Autowired
    private EditarNotaRepository editarNotaRepository;

    public List<EditarNota> listarTodos() {
        return editarNotaRepository.findAll();
    }

    public EditarNota criarEditarNota(EditarNota editarNota) {
        return editarNotaRepository.save(editarNota);
    }

    public EditarNota obterPorId(Long id) {
        return editarNotaRepository.findById(id).orElse(null);
    }

    public void removerEditarNota(Long id) {
        editarNotaRepository.deleteById(id);
    }
}
