package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.CalendarioProvas;
import com.escola.repository.CalendarioProvasRepository;

@Service
public class CalendarioProvasService {
    private final CalendarioProvasRepository calendarioProvasRepository;

    @Autowired
    public CalendarioProvasService(CalendarioProvasRepository calendarioProvasRepository) {
        this.calendarioProvasRepository = calendarioProvasRepository;
    }

    public String cadastrarProva(List<CalendarioProvas> calendarioProvass) {
    	
    	if(calendarioProvass != null) {
    		for(CalendarioProvas calendario : calendarioProvass) {
    			calendarioProvasRepository.saveAndFlush(calendario);
    		}
    		return "Calendario Das Provas Foram Cadastrados";
    	}else {
    		return "Nenhum Calendario De Prova Foi Cadastrado";
    	}
    }

    // Outros métodos relacionados ao calendário de provas, se necessário
}
