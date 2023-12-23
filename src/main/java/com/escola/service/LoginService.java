package com.escola.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.Login;
import com.escola.model.Admin;
import com.escola.model.Aluno;
import com.escola.model.Professor;
import com.escola.model.Secretaria;
import com.escola.model.Tesouraria;
import com.escola.repository.AdminRepository;
import com.escola.repository.AlunoRepository;
import com.escola.repository.ProfessorRepository;
import com.escola.repository.SecretariaRepository;
import com.escola.repository.TesourariaRepository;

@Service
public class LoginService {

    @Autowired
    private AdminRepository adR;
    
    @Autowired
    private TesourariaRepository teR;
    
    @Autowired
    private SecretariaRepository sr;
    
    @Autowired
    private ProfessorRepository pr;
    
    @Autowired
    private AlunoRepository ar;
    
    

    public Login findByUsername(Login  login) {
    	Login login2 = new Login();
    	login2.setStatusLogin(false);
		login2.setMensagem("Não Existe Ninguém Na Escola Com Os Dados Informados !");
    	if(login.getUsername().equalsIgnoreCase("admin")) {
    		if(login.getPassword() != null) {
    			Optional<Admin> admin=  adR.findByBi(null);
    			if(admin.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(admin.get());
    				login2.setId(admin.get().getId());
    				login2.setNome(admin.get().getNome());
    				login2.setFuncao("admin");
    				
    			}
    		}
    		
    	}else if(login.getUsername().equalsIgnoreCase("Tesoureiro") || login.getUsername().equalsIgnoreCase("t")) {
    		if(login.getPassword() != null) {
    			Optional<Tesouraria> tesouraria=  teR.findByBi(login.getPassword());
    			if(tesouraria.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(tesouraria.get());
    				login2.setId(tesouraria.get().getId());
    				login2.setNome(tesouraria.get().getNome());
    				login2.setFuncao("tesouraria");
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("Secretaria") || login.getUsername().equalsIgnoreCase("s")) {
    		if(login.getPassword() != null) {
    			Optional<Secretaria> secretaria=  sr.findByBi(login.getPassword());
    			if(secretaria.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(secretaria.get());
    				login2.setId(secretaria.get().getId());
    				login2.setNome(secretaria.get().getNome());
    				login2.setFuncao("secretaria");
    				
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("Professor") || login.getUsername().equalsIgnoreCase("p")) {
    		if(login.getPassword() != null) {
    			Optional<Professor> professor=  pr.findByBi(login.getPassword());
    			if(professor.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(professor.get());
    				login2.setId(professor.get().getId());
    				login2.setNome(professor.get().getNome());
    				login2.setFuncao("professor");
    				
    				
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("aluno") && login.getPassword() != null) {
    		try {
    			Long idAluno = Long.parseLong(login.getUsername());
        		Optional<Aluno> aluno=  ar.findById(idAluno);
        			if(aluno.isPresent()) {
        				login2.setStatusLogin(true);
        				login2.setUsuario(aluno.get());
        				login2.setId(aluno.get().getId());
        				login2.setIdTurma(aluno.get().getTurma().getId());
        				login2.setNome(aluno.get().getNome());
        				login2.setFuncao("aluno");
        				
        			}
    		}catch (Exception e) {
    			login2.setStatusLogin(false);
    			login2.setMensagem("Coloque Apenas Numeros Nos Campos Login e Senha, Sem Espaço");
			}
    		
    	}else if(login.getUsername().equalsIgnoreCase("cadastrar") || login.getPassword().equalsIgnoreCase("cadastrar")) {
    				login2.setStatusLogin(true);
    				login2.setMensagem("cadastrar");
    	}else {
    		login2.setStatusLogin(false);
    	}
        return login2;
    }



    // Outros métodos de serviço conforme necessário
}

