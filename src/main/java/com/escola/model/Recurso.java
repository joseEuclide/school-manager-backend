package com.escola.model;

import javax.persistence.*;

@Entity
@Table(name="recursos")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com Aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    // Relacionamento com Turma
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    // Relacionamento com Disciplina
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    // Outros atributos do recurso
    private Double nota;
    
    
    

	public Long getId() {
		return id;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

    
    // getters e setters
    
    
}

