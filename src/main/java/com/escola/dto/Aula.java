package com.escola.dto;

import java.util.List;

public class Aula {
	private String nome;
    private List<Horario> horarios;
    
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
    
    
}
