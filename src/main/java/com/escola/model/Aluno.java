package com.escola.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alunos")
public class Aluno {

	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private String bi;

	    @ManyToOne
	    @JoinColumn(name = "turma_id") // Nome da coluna na tabela de Aluno que faz referência à Turma
	    private Turma turma;

	    
	    // Construtores
	    
	    public Aluno() {}
	    
	    public Aluno(String nome, String bi) {
			super();
			this.nome = nome;
			this.bi = bi;
		}

		

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

		public Turma getTurma() {
			return turma;
		}

		public void setTurma(Turma turma) {
			this.turma = turma;
		}
	    
	    
	    
}
