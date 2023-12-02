package com.escola.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    
	@ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
    
    @ManyToOne
    @JoinColumn(name = "professor_fk")
    private Professor professor;

    private double mac1;
    private double npp1;
    private double npt1;
    private double notaPrimeiroTrimestre;
    private double mac2;
    private double npp2;
    private double npt2;
    private double notaSegundoTrimestre;
    private double mac3;
    private double npp3;
    private double npt3;
    private double notaTerceiroTrimestre;
    private double nfd; 
    private double mec; 
    private double notaFinal;
    private double notaExame;
    private double notaRecurso;
    private Long idDisciplina;
    private Long idAluno;
    
    
    
    
	public double getMac1() {
		return mac1;
	}

	public void setMac1(double mac1) {
		this.mac1 = mac1;
	}

	public double getNpp1() {
		return npp1;
	}

	public void setNpp1(double npp1) {
		this.npp1 = npp1;
	}

	public double getNpt1() {
		return npt1;
	}

	public void setNpt1(double npt1) {
		this.npt1 = npt1;
	}

	public double getNotaPrimeiroTrimestre() {
		return notaPrimeiroTrimestre;
	}

	public void setNotaPrimeiroTrimestre(double notaPrimeiroTrimestre) {
		this.notaPrimeiroTrimestre = notaPrimeiroTrimestre;
	}

	public double getMac2() {
		return mac2;
	}

	public void setMac2(double mac2) {
		this.mac2 = mac2;
	}

	public double getNpp2() {
		return npp2;
	}

	public void setNpp2(double npp2) {
		this.npp2 = npp2;
	}

	public double getNpt2() {
		return npt2;
	}

	public void setNpt2(double npt2) {
		this.npt2 = npt2;
	}

	public double getNotaSegundoTrimestre() {
		return notaSegundoTrimestre;
	}

	public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
		this.notaSegundoTrimestre = notaSegundoTrimestre;
	}

	public double getMac3() {
		return mac3;
	}

	public void setMac3(double mac3) {
		this.mac3 = mac3;
	}

	public double getNpp3() {
		return npp3;
	}

	public void setNpp3(double npp3) {
		this.npp3 = npp3;
	}

	public double getNpt3() {
		return npt3;
	}

	public void setNpt3(double npt3) {
		this.npt3 = npt3;
	}

	public double getNotaTerceiroTrimestre() {
		return notaTerceiroTrimestre;
	}

	public void setNotaTerceiroTrimestre(double notaTerceiroTrimestre) {
		this.notaTerceiroTrimestre = notaTerceiroTrimestre;
	}

	public double getNfd() {
		return nfd;
	}

	public void setNfd(double nfd) {
		this.nfd = nfd;
	}

	public double getMec() {
		return mec;
	}

	public void setMec(double mec) {
		this.mec = mec;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public double getNotaExame() {
		return notaExame;
	}

	public void setNotaExame(double notaExame) {
		this.notaExame = notaExame;
	}

	public double getNotaRecurso() {
		return notaRecurso;
	}

	public void setNotaRecurso(double notaRecurso) {
		this.notaRecurso = notaRecurso;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public Long getId() {
		return id;
	}



	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
    
    
}