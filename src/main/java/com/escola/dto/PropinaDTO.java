package com.escola.dto;

import java.util.ArrayList;

public class PropinaDTO {

	  private Long idAluno;
	  private Long idTurma;
	  private ArrayList<String> mesesAPagar = new ArrayList<>();
	  
	  

	  
	
	public ArrayList<String> getMesesAPagar() {
		return mesesAPagar;
	}
	public void setMesesAPagar(ArrayList<String> mesesAPagar) {
		this.mesesAPagar = mesesAPagar;
	}
	public Long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	  
	  
	  
}
