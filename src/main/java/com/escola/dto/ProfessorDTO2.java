package com.escola.dto;

import java.util.List;

import com.escola.model.Nota;

public class ProfessorDTO2 {
	
	private List<Nota> notas;
	private String mensagem;
	
	
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
