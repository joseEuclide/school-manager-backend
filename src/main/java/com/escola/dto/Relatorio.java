package com.escola.dto;

public class Relatorio {

	private Boolean retorno;
	private byte[] novoRelatorio;
	private String mensagem;
	
	
	
	public Boolean getRetorno() {
		return retorno;
	}
	public void setRetorno(Boolean retorno) {
		this.retorno = retorno;
	}
	public byte[] getNovoRelatorio() {
		return novoRelatorio;
	}
	public void setNovoRelatorio(byte[] novoRelatorio) {
		this.novoRelatorio = novoRelatorio;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
