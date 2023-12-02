package com.escola.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CalendarioAulas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAula;
    private String disciplina;
    private String horario;
    private String salaDeAula;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turmaCalendario;
    
    

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSalaDeAula() {
		return salaDeAula;
	}

	public void setSalaDeAula(String salaDeAula) {
		this.salaDeAula = salaDeAula;
	}


	public Long getId() {
		return id;
	}

	public Turma getTurmaCalendario() {
		return turmaCalendario;
	}

	public void setTurmaCalendario(Turma turmaCalendario) {
		this.turmaCalendario = turmaCalendario;
	}
    
    
    

    // Getters e setters
}
