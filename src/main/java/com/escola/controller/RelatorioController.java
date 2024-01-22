package com.escola.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Aluno;
import com.escola.relatorio.RelatorioService;
import com.escola.service.AlunoService;

@RestController
@CrossOrigin(origins = "*")
public class RelatorioController {
	@Autowired
    private RelatorioService relatorioService;
	
	@Autowired
	private AlunoService as;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/relatorio-aluno/{alunoId}")
    public ResponseEntity<byte[]> imprimirRelatorioAluno(@PathVariable Long alunoId) {
        try {
            Aluno aluno = as.obterAlunoPorId(alunoId); // Obtenha os dados do aluno

            byte[] pdfBytes = relatorioService.gerarRelatorioAlunoPropina(aluno);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "relatorio_aluno.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            // Lida com erros, por exemplo, aluno não encontrado, erro de geração de relatório, etc.
            e.printStackTrace();
        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
