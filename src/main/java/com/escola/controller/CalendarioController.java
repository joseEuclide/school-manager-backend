package com.escola.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.Aula;
import com.escola.dto.AulaOrganizada;
import com.escola.dto.Horario;
import com.escola.model.CalendarioProvas;
import com.escola.repository.CalendarioProvasRepository;

@RestController
public class CalendarioController {

	@Autowired
	private CalendarioProvasRepository cpr;
	
    @GetMapping("/organizarAulas/{Curso}/{nivel}/{turno}")
    public List<AulaOrganizada> organizarAulas(@PathVariable Long Curso,String nivel, String turno) {
        // Suponha que você tenha o objeto calendario com os dados

        List<AulaOrganizada> aulasOrganizadas = new ArrayList<>();

        Optional<CalendarioProvas>  calendarioDeProvas =  cpr.findByCursoAndTurnoAndNivel(Curso, turno, nivel);
        if(calendarioDeProvas.isPresent()) {
        	
        	 for (Aula aula : calendarioDeProvas.get().getDados()) {
                 for (Horario horario : aula.getHorarios()) {
                     aulasOrganizadas.add(new AulaOrganizada(aula.getNome(), horario.getDiaAula(), horario.getHoraInicio()));
                 }
             }
        }
        // Organizar as aulas em ordem cronológica
       

        // Ordenar as aulas por dia e horário
        Collections.sort(aulasOrganizadas, Comparator.comparing(AulaOrganizada::getDiaAula)
                .thenComparing(AulaOrganizada::getHoraInicio));

        return aulasOrganizadas;
    }
}