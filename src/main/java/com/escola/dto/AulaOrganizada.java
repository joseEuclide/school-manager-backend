package com.escola.dto;

public class AulaOrganizada {
    private String nomeAula;
    private String diaAula;
    private String horaInicio;

    public AulaOrganizada(String nomeAula, String diaAula, String horaInicio) {
        this.nomeAula = nomeAula;
        this.diaAula = diaAula;
        this.horaInicio = horaInicio;
    }
    
    

	public String getNomeAula() {
		return nomeAula;
	}

	public void setNomeAula(String nomeAula) {
		this.nomeAula = nomeAula;
	}

	public String getDiaAula() {
		return diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
    
    

}
