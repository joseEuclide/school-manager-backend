package com.escola.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.PermissaoDTO;
import com.escola.dto.ProfessorDTO2;
import com.escola.model.Permissao;
import com.escola.model.Professor;
import com.escola.repository.ProfessorRepository;
import com.escola.service.PermissaoService;

@RestController
@CrossOrigin(origins = "*")
public class PermissaoController {
   
	@Autowired
    private PermissaoService permissaoService;
	
	@Autowired
	private ProfessorRepository pr;

    @GetMapping("/listar-permissoes")
    public List<Permissao> listarPermissoes() {
        return permissaoService.listarPermissoes();
    }

    @PostMapping("/Atribuir-E-Remover-permissoes")
    public ResponseEntity<ProfessorDTO2> criarPermissao(@RequestBody PermissaoDTO permissaoDTOs) {
    	List<Professor> profs =  pr.findAll();
    	List<PermissaoDTO> permissaoDTOs2 = new ArrayList<>();
    	if(permissaoDTOs.getIdPRof() == null && profs != null) {
    		 for(Professor  cadaC : profs) {
    			 PermissaoDTO permissaoDTO = new PermissaoDTO();
    			 permissaoDTO.setIdPRof(cadaC.getId());
    			 permissaoDTO.setPermissao(permissaoDTOs.getPermissao());
    			 permissaoDTOs2.add(permissaoDTO);
    		 }
    	}else if(permissaoDTOs.getIdPRof() != 0 && profs != null) {
	    		 PermissaoDTO permissaoDTO = new PermissaoDTO();
				 permissaoDTO.setIdPRof(permissaoDTOs.getIdPRof());
				 permissaoDTO.setPermissao(permissaoDTOs.getPermissao());
				 permissaoDTOs2.add(permissaoDTO);
    	}
    	String mensagem = permissaoService.criarPermissao(permissaoDTOs2);
    	ProfessorDTO2 permisaoProf = new ProfessorDTO2();
    	permisaoProf.setMensagem(mensagem);
    	
        return ResponseEntity.ok(permisaoProf);
    }

  
}