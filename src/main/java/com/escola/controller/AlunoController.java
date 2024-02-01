package com.escola.controller;



import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.escola.dto.AlunoDTO;
import com.escola.dto.Relatorio;
import com.escola.model.Aluno;
import com.escola.service.AlunoService;
import com.escola.service.NotaService;
import com.escola.model.Nota;


/**
 * Classe Responsavel por Controlar Todas Requisicoes Da APP
 * 
 * 
 * @author Jose Euclides - Programador
 * @version 1.0
 *
 */

@RestController
@CrossOrigin(origins = "*") // Permite CORS para este controlador
public class AlunoController {

    @Autowired
    private AlunoService as;
    
    @Autowired
    private NotaService ns;
    

    @PostMapping(value =  "/cadastrar-aluno/{idTurma}", consumes = "application/json")
    public ResponseEntity<Relatorio> cadastrarAluno(@RequestBody AlunoDTO aluno, @PathVariable Long idTurma) {
        Relatorio alunoCadastrado = as.cadastrar(aluno,idTurma);
        
        if(alunoCadastrado!= null) {
        	String relatorio = "data:application/pdf;base64,"+ Base64.encodeBase64String(alunoCadastrado.getNovoRelatorio());
        	alunoCadastrado.setRelatorio(relatorio);
        	return ResponseEntity.ok(alunoCadastrado);
        }else {
        	return ResponseEntity.status(500).body(null);
        }
        
    }
    
    @GetMapping(value =  "/alunos-da-turma/{idTurma}", produces = "application/json")
    public ResponseEntity<ArrayList<Aluno>> todosAlunos( @PathVariable Long idTurma) {
        ArrayList<Aluno> alunosDaTurma2 = as.alunosDaTurma(idTurma);
        return ResponseEntity.ok(alunosDaTurma2);
    }
    
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<Aluno> obterAluno(@PathVariable Long alunoId) {
        // Verifique se o aluno com o ID especificado existe e tem permissão para ver as notas.
        // Dependendo da sua lógica de autenticação e autorização, você pode implementar verificações aqui.

        Aluno aluno = as.obterAlunoPorId(alunoId);

        return ResponseEntity.ok(aluno);
    }
    
    @GetMapping("/notas/{alunoId}/{idTurma}")
    public ResponseEntity<List<Nota>> obterNotasDoAluno(@PathVariable Long alunoId,@PathVariable Long idTurma) {
        // Verifique se o aluno com o ID especificado existe e tem permissão para ver as notas.
        // Dependendo da sua lógica de autenticação e autorização, você pode implementar verificações aqui.

        System.out.println("DADOS DO ALUNO  PARA AS NOTAS ============");
        System.out.println("alunoId: "+alunoId);
        System.out.println("IdTurma: "+idTurma);
    	List<Nota> notasDoAluno = ns.listarNotasDoAluno(alunoId);
        

        return ResponseEntity.ok(notasDoAluno);
    }
    

}

