package com.escola.exception;

public class ProfessorNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorNotFoundException(String message) {
		super(message);
		System.out.println(message);
		// TODO Auto-generated constructor stub
	}
	

}
