package com.escola.exception;

public class PagamentoInvalidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagamentoInvalidoException(String message) {
		super(message);
		System.out.println(message);
		// TODO Auto-generated constructor stub
	}
	

}
