package com.escola.model;

import java.io.Serializable;

public class NotasFinal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    private Long idDisciplina;
	private double mac1;
    private double npp1;
    private double npt1;

    
    
    
    
	public double getMac1() {
		return mac1;
	}
	public void setMac1(double mac1) {
		this.mac1 = mac1;
	}
	public double getNpp1() {
		return npp1;
	}
	public void setNpp1(double npp1) {
		this.npp1 = npp1;
	}
	public double getNpt1() {
		return npt1;
	}
	public void setNpt1(double npt1) {
		this.npt1 = npt1;
	}
	
	public Long getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
    
    
    
}
