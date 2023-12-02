package com.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="permissoes")
public class Permissao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String tipoDeProva; // Ex: "MAC1", "NPP1", "NPT1", "Prova1", "Prova2", "Trabalho", etc.

  @ManyToOne
  @JoinColumn(name="professor_fk")
  private Professor professorPermissoes;
  
  private Long idProf;
  
  private boolean lancarEmCasa;

  private boolean lancarNaEscola;

  private boolean eEpocaDeLancamento;
  
  
  

public Long getIdProf() {
	return idProf;
}

public void setIdProf(Long idProf) {
	this.idProf = idProf;
}

public String getTipoDeProva() {
	return tipoDeProva;
}

public void setTipoDeProva(String tipoDeProva) {
	this.tipoDeProva = tipoDeProva;
}



public Professor getProfessorPermissoes() {
	return professorPermissoes;
}

public void setProfessorPermissoes(Professor professorPermissoes) {
	this.professorPermissoes = professorPermissoes;
}

public boolean isLancarEmCasa() {
	return lancarEmCasa;
}

public void setLancarEmCasa(boolean lancarEmCasa) {
	this.lancarEmCasa = lancarEmCasa;
}

public boolean isLancarNaEscola() {
	return lancarNaEscola;
}

public void setLancarNaEscola(boolean lancarNaEscola) {
	this.lancarNaEscola = lancarNaEscola;
}



public boolean iseEpocaDeLancamento() {
	return eEpocaDeLancamento;
}

public void seteEpocaDeLancamento(boolean eEpocaDeLancamento) {
	this.eEpocaDeLancamento = eEpocaDeLancamento;
}

public Long getId() {
	return id;
}

  // Construtores, getters e setters
  
  
  
}