package com.escola.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfessorDisciplinasTurma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idProf;
	private Long idTurma;
    private ArrayList<String> disciplinas = new ArrayList<>();
    
    
    
	
    
	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	public Long getId() {
		return id;
	}
	public ArrayList<String> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(ArrayList<String> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Long getIdProf() {
		return idProf;
	}
	public void setIdProf(Long idProf) {
		this.idProf = idProf;
	}
	
    
    
    
    
}
