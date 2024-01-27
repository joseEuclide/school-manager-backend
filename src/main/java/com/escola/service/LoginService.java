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
    	String nome = "";
    	login2.setStatusLogin(false);
		login2.setMensagem("Não Existe Ninguém Na Escola Com Os Dados Informados !");
    	if(login.getUsername().equalsIgnoreCase("admin")) {
    		if(login.getPassword() != null) {
    			Optional<Admin> admin=  adR.findByBi(login.getPassword());
    			if(admin.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(admin.get());
    				login2.setId(admin.get().getId());
    				nome = admin.get().getNome();
    				if(nome.contains(" ")) {
    					String[] novoNome = nome.split(" ");
    					if(novoNome != null) {
    						// Aqui éstá a Pegar O Primeiro E O Ultimo Nome Do Integrante
    						nome = novoNome[0] + " "+novoNome[novoNome.length-1];
    					}
    				}
    				login2.setNome(nome);
    				login2.setFuncao("admin");
    				login2.setMensagem("Existe Admin Com Os Dados Informados !");
    				
    			}
    		}
    		
    	}else if(login.getUsername().equalsIgnoreCase("Tesouraria") || login.getUsername().equalsIgnoreCase("T")) {
    		if(login.getPassword() != null) {
    			Optional<Tesouraria> tesouraria=  teR.findByBi(login.getPassword());
    			if(tesouraria.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(tesouraria.get());
    				login2.setId(tesouraria.get().getId());
    				nome = tesouraria.get().getNome();
    				if(nome.contains(" ")) {
    					String[] novoNome = nome.split(" ");
    					if(novoNome != null) {
    						// Aqui éstá a Pegar O Primeiro E O Ultimo Nome Do Integrante
    						nome = novoNome[0] + " "+novoNome[novoNome.length-1];
    					}
    				}
    				login2.setNome(nome);
    				login2.setFuncao("tesouraria");
    				login2.setMensagem("Existe Tesoureiro(a) Com Os Dados Informados !");
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("Secretaria") || login.getUsername().equalsIgnoreCase("s")) {
    		if(login.getPassword() != null) {
    			Optional<Secretaria> secretaria=  sr.findByBi(login.getPassword());
    			if(secretaria.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(secretaria.get());
    				login2.setId(secretaria.get().getId());
    				nome = secretaria.get().getNome();
    				if(nome.contains(" ")) {
    					String[] novoNome = nome.split(" ");
    					if(novoNome != null) {
    						// Aqui éstá a Pegar O Primeiro E O Ultimo Nome Do Integrante
    						nome = novoNome[0] + " "+novoNome[novoNome.length-1];
    					}
    				}
    				login2.setNome(nome);
    				login2.setFuncao("secretaria");
    				login2.setMensagem("Existe Secretario(a) Com Os Dados Informados !");
    				
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("Professor") || login.getUsername().equalsIgnoreCase("p")) {
    		System.out.println("Entrou no Professor");
    		if(login.getPassword() != null) {
    			System.out.println("Entrou no Professor 2");
    			Optional<Professor> professor=  pr.findByBi(login.getPassword());
    			if(professor.isPresent()) {
    				login2.setStatusLogin(true);
    				login2.setUsuario(professor.get());
    				login2.setId(professor.get().getId());
    				nome = professor.get().getNome();
    				if(nome.contains(" ")) {
    					String[] novoNome = nome.split(" ");
    					if(novoNome != null) {
    						// Aqui éstá a Pegar O Primeiro E O Ultimo Nome Do Integrante
    						nome = novoNome[0] + " "+novoNome[novoNome.length-1];
    					}
    				}
    				login2.setNome(nome);
    				login2.setFuncao("professor");
    				login2.setMensagem("Existe Professor(a) Com Os Dados Informados !");
    				
    				
    			}
    		}
    	}else if(login.getUsername().equalsIgnoreCase("aluno") && login.getPassword() != null) {
    		try {
    			Long idAluno = Long.parseLong(login.getPassword());
        		Optional<Aluno> aluno=  ar.findById(idAluno);
        			if(aluno.isPresent()) {
        				login2.setStatusLogin(true);
        				login2.setUsuario(aluno.get());
        				login2.setId(aluno.get().getId());
        				login2.setIdTurma(aluno.get().getTurma().getId());
        				nome = aluno.get().getNome();
        				if(nome.contains(" ")) {
        					String[] novoNome = nome.split(" ");
        					if(novoNome != null) {
        						// Aqui éstá a Pegar O Primeiro E O Ultimo Nome Do Integrante
        						nome = novoNome[0] + " "+novoNome[novoNome.length-1];
        					}
        				}
        				login2.setNome(nome);
        				login2.setFuncao("aluno");
        				login2.setMensagem("Existe aluno(a) Com Os Dados Informados !");
        				
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

