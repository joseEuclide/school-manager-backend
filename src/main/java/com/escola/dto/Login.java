package com.escola.dto;

public class Login {

	private String username;
	private String password;
	private Object usuario;
	private Boolean statusLogin;
	private String mensagem;
	private String funcao;
	private Long id;
	private Long idTurma;
	private String nome;
	
	
	
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
