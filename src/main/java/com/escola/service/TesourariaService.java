package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.Tesouraria;
import com.escola.repository.TesourariaRepository;

@Service
public class TesourariaService {


    @Autowired
    private TesourariaRepository tesoureiroRepository;

    public List<Tesouraria> cadastrarListaTesoureiros(List<Tesouraria> tesoureiros) {
        return tesoureiroRepository.saveAll(tesoureiros);
    }
    
    public List<Tesouraria> listarTodos() {
        return tesoureiroRepository.findAll();
    }
    
    
}
