package com.escola.model;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professores")
public class Professor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String bi;
    private ArrayList<Curso> cursos = new ArrayList<>();

    
    public Professor() {}
    
	public Professor(String nome, String bi) {
		super();
		this.nome = nome;
		this.bi= bi;
	}

	
	
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public Long getId() {
		return id;
	}

	

	public String getBi() {
		return bi;
	}

	public void setBi(String bi) {
		this.bi = bi;
	}
    
	
    
}
