package com.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.model.PrecoPropina;
import com.escola.repository.PrecoPropinaRepository;

@Service
public class PrecoPropinaService {

	@Autowired
    private PrecoPropinaRepository ppr;
	
	public String cadastrarPRecoPropina(PrecoPropina precoPropina) {
		 try {
			 ppr.save(precoPropina);
	         return "cursos cadastrados com sucesso";
		 }catch(Exception e) {
			 e.printStackTrace();
			 return "Falha Ao Cadastrar o Curso";
		 }
         
    }
}
