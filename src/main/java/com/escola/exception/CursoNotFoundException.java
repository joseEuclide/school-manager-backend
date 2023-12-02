package com.escola.exception;

public class CursoNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CursoNotFoundException(String message) {
		super(message);
		System.out.println(message);
		// TODO Auto-generated constructor stub
	}
	

}
