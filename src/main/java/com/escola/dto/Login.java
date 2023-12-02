package com.escola.dto;

public class Login {

	private String username;
	private String password;
	private Object usuario;
	private Boolean statusLogin;
	private String mensagem;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Object getUsuario() {
		return usuario;
	}
	public void setUsuario(Object usuario) {
		this.usuario = usuario;
	}
	public Boolean getStatusLogin() {
		return statusLogin;
	}
	public void setStatusLogin(Boolean statusLogin) {
		this.statusLogin = statusLogin;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
