package com.escola.exception;

public class TurmaNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TurmaNotFoundException(String message) {
		super(message);
		System.out.println(message);
		// TODO Auto-generated constructor stub
	}
	

}
