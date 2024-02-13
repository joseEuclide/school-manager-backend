package com.escola.dto;

public class DisciplinaDTO {
	
  private String nome;
  private String[] niveis;
  private String mensagem;
  
  
  
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String[] getNiveis() {
		return niveis;
	}
	public void setNiveis(String[] niveis) {
		this.niveis = niveis;
	}
  
  
}
