package com.escola.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Salario;
import com.escola.repository.SalarioRepository;
import com.escola.service.SalarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite CORS para este controlador
public class SalarioController {
	
	@Autowired
	private SalarioService ss;
	
	@Autowired
	private SalarioRepository salarioRep;

    @PostMapping("/cadastrar-salarios")
    public ResponseEntity<List<Salario>> cadastrarListaTesoureiros(@RequestBody Salario salario) {
    	List<Salario> salariosrios = salarioRep.findAll();
    	 List<Salario> cadastrados2 = new ArrayList<>();
    	if(salario.getStatusPagamento() && salariosrios != null) {
    		for(Salario s : salariosrios) {     	
            	s.setDataPagamento(LocalDate.now());
            	cadastrados2.add(s);
            }
            List<Salario> salarios2 =  ss.realizarPagamento(cadastrados2);
            return ResponseEntity.ok(salarios2);
    	}else {
    		return ResponseEntity.ok(new ArrayList<>());
    	}
    	
       
        
    }
}
