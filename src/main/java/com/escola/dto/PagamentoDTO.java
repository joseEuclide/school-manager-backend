package com.escola.dto;

import java.util.ArrayList;


public class PagamentoDTO {

        private Long id;
        private String nome;
        private String turma;
        private String curso;
        private String turno;
        private String nivel;
        private String mensagem;
        private byte[] relatorio;

	    private ArrayList<String> mesesAPagar = new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
        public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
        public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
        public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
        public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
        public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
        public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public ArrayList<String> getMesesAPagar() {
		return mesesAPagar;
	}
	public void setMesesAPagar(ArrayList<String> mesesAPagar) {
		this.mesesAPagar = mesesAPagar;
	}
	public byte[] getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(byte[] relatorio) {
		this.relatorio = relatorio;
	}

	
	
	
}
