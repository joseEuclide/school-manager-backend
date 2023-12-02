package com.escola.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.escola.dto.Aula;

@Entity
public class CalendarioProvas {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 

 private Long curso;
 private String turno;
 private String nivel;
 private ArrayList<Aula> dados = new ArrayList<>();

 
 
 private LocalDate dataProva;
 private String disciplina;
 private String horario;
 private String salaExame;

 @ManyToOne
 @JoinColumn(name = "turma_id")
 private Turma turmaCalendarioProvas;
 
 




public ArrayList<Aula> getDados() {
	return dados;
}

public void setDados(ArrayList<Aula> dados) {
	this.dados = dados;
}

public LocalDate getDataProva() {
	return dataProva;
}

public void setDataProva(LocalDate dataProva) {
	this.dataProva = dataProva;
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

public String getSalaExame() {
	return salaExame;
}

public void setSalaExame(String salaExame) {
	this.salaExame = salaExame;
}



public Long getId() {
	return id;
}

public Turma getTurmaCalendarioProvas() {
	return turmaCalendarioProvas;
}

public void setTurmaCalendarioProvas(Turma turmaCalendarioProvas) {
	this.turmaCalendarioProvas = turmaCalendarioProvas;
}



public Long getCurso() {
	return curso;
}

public void setCurso(Long curso) {
	this.curso = curso;
}

public String getTurno() {
	return turno;
}

public void setTurno(String turno) {
	this.turno = turno;
}

public String getNivel() {
	return nivel;
}

public void setNivel(String nivel) {
	this.nivel = nivel;
}



 // Getters e setters
 
 
}
