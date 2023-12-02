package com.escola.exception;

public class AlunoNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String message) {
		super(message);
		System.out.println(message);
		// TODO Auto-generated constructor stub
	}
	

}
