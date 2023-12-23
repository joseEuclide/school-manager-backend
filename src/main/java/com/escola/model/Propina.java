package com.escola.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="propinas")
public class Propina {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate data;
  
  
  
  private Double janeiro;
  private Double fevereiro;
  private Double marco;
  private Double abril;
  private Double maio;
  private Double junho;
  private Double julho;
  private Double agosto;
  private Double setembro;
  private Double Outubro;
  private Double novembro;
  private Double dezembro;

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;
  
  @ManyToOne
  @JoinColumn(name = "turma_id")
  private Turma turma;
  
    
	
	public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}

	public Turma getTurma() {
	return turma;
}

public void setTurma(Turma turma) {
	this.turma = turma;
}

	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Long getId() {
		return id;
	}

	public Double getAgosto() {
		return agosto;
	}

	public void setAgosto(Double agosto) {
		this.agosto = agosto;
	}

    public Double getJulho() {
		return julho;
	}

	public void setJulho(Double julho) {
		this.julho = julho;
	}
	public Double getSetembro() {
		return setembro;
	}

	public void setSetembro(Double setembro) {
		this.setembro = setembro;
	}

	public Double getOutubro() {
		return Outubro;
	}

	public void setOutubro(Double outubro) {
		Outubro = outubro;
	}

	public Double getNovembro() {
		return novembro;
	}

	public void setNovembro(Double novembro) {
		this.novembro = novembro;
	}

	public Double getDezembro() {
		return dezembro;
	}

	public void setDezembro(Double dezembro) {
		this.dezembro = dezembro;
	}

	public Double getJaneiro() {
		return janeiro;
	}

	public void setJaneiro(Double janeiro) {
		this.janeiro = janeiro;
	}

	public Double getFevereiro() {
		return fevereiro;
	}

	public void setFevereiro(Double fevereiro) {
		this.fevereiro = fevereiro;
	}

	public Double getMarco() {
		return marco;
	}

	public void setMarco(Double marco) {
		this.marco = marco;
	}

	public Double getAbril() {
		return abril;
	}

	public void setAbril(Double abril) {
		this.abril = abril;
	}

	public Double getMaio() {
		return maio;
	}

	public void setMaio(Double maio) {
		this.maio = maio;
	}

	public Double getJunho() {
		return junho;
	}

	public void setJunho(Double junho) {
		this.junho = junho;
	}
	
	
	  // Getters e setters
	  
	  
	}
