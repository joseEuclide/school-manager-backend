package com.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.PermissaoDTO;
import com.escola.model.Permissao;
import com.escola.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
	
	@Autowired
    private PermissaoRepository permissaoRepository;


    public List<Permissao> listarPermissoes() {
        return permissaoRepository.findAll();
    }

    public String criarPermissao(List<PermissaoDTO> permissaoDTOs) {
      String retorno ="";
      if(permissaoDTOs != null) {
    		
    		for(PermissaoDTO permissao : permissaoDTOs) {
    			
    			Optional<Permissao> permissao2 =  permissaoRepository.findByIdProf(permissao.getIdPRof());
    	    	if(permissao2.isPresent()) {
    	    		     
    	    		     Optional<Permissao> p = permissaoRepository.findById(permissao2.get().getId());
    	    			 System.out.println("Nome do Professor: "+permissao2.get().getProfessorPermissoes().getNome());
        	    		 System.out.println("BI do Professor: "+permissao2.get().getProfessorPermissoes().getBi());
        	    		
        	    		 Permissao p2 =  p.get();
        	    		 p2.seteEpocaDeLancamento(permissao.getPermissao().iseEpocaDeLancamento());
        	    		 p2.setLancarEmCasa(permissao.getPermissao().isLancarEmCasa());
        	    		 p2.setLancarNaEscola(permissao.getPermissao().isLancarNaEscola());
        	    		 p2.setTipoDeProva(permissao.getPermissao().getTipoDeProva());
        	    		 permissaoRepository.saveAndFlush(p2);
    	    		 
    	    		
    	    	
    		     }else {
    		    	 System.out.println("Não Existe PRofessor Com Esse ID");
    		     }
    	    }
    		retorno = "As Autorizações e Remoção das mesmas Foram Concedidas Ao Professor";
    }else {
    	   retorno = "Nenhuma Autorizacao Foi Concedida aos Professores ";
    }

      return retorno;
  }


}