package com.escola.dto;

import java.util.ArrayList;

import com.escola.model.Aluno;

public class ProfessorDTO2 {
	
	private ArrayList<Aluno> notas;
	private String mensagem;
	
	
	public ArrayList<Aluno> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Aluno> notas) {
		this.notas = notas;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
