package com.escola.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salarios")
public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPagamento;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    private Boolean statusPagamento;
    
   

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public Boolean getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(Boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
    
    
    
    // Outros campos e métodos, getters e setters
}

