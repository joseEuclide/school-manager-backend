package com.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.CalendarioAulas;
import com.escola.repository.CalendarioAulasRepository;

@Service
public class CalendarioAulasService {
    private final CalendarioAulasRepository calendarioAulasRepository;

    @Autowired
    public CalendarioAulasService(CalendarioAulasRepository calendarioAulasRepository) {
        this.calendarioAulasRepository = calendarioAulasRepository;
    }

    public String cadastrarAula(List<CalendarioAulas> calendarioDeAulas) {
    	if(calendarioDeAulas != null) {
    		for(CalendarioAulas calendario : calendarioDeAulas) {
    			calendarioAulasRepository.saveAndFlush(calendario);
    		}
    		return "Calendario Das Turmas Foram Cadastrados";
    	}else {
    		return "Nenhum Calendario Foi Cadastrado";
    	}
        
    }

    // Outros métodos relacionados ao calendário de aulas, se necessário
}