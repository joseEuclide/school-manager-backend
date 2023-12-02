package com.escola.dto;

import java.util.ArrayList;

public class TurmaDTO2 {

	private Long id;
	private String nome;
	private ArrayList<String> disciplinas = new ArrayList<>();
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<String> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(ArrayList<String> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}
