package com.escola.model;

import javax.persistence.*;

@Entity
@Table(name="tesoureiros")
public class Tesouraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String bi;
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	public Long getId() {
		return id;
	}
    
    
    
}

