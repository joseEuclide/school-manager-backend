package com.escola.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escola.dto.PagamentoDTO;
import com.escola.dto.PropinaDTO;
import com.escola.model.Propina;
import com.escola.service.PropinaService;

@RestController
@CrossOrigin(origins = "*")
public class PagamentoPropinasController {
    private final PropinaService propinaService;
    
  

    @Autowired
    public PagamentoPropinasController(PropinaService propinaService) {
        this.propinaService = propinaService;
    }

    @PostMapping("/cadastrar-Pagamento-Propina")
    public ResponseEntity<PagamentoDTO> registrarPagamentoPropina(
        @RequestBody PropinaDTO propinaDTO
    ) throws Exception {
    	
    	
    	PagamentoDTO statusPagamento = propinaService.registrarPagamento(propinaDTO );
    	
        return new ResponseEntity<>(statusPagamento, HttpStatus.CREATED);
    }
    
    @GetMapping(value =  "/pagar-propina-Aluno/{idTurma}/{idAluno}", produces = "application/json")
    public ResponseEntity<PagamentoDTO> todosAlunos( @PathVariable Long idTurma,@PathVariable Long idAluno) {
        PropinaDTO p = new PropinaDTO();
        p.setIdAluno(idAluno);
        p.setIdTurma(idTurma);
        
        PagamentoDTO dadosFinanceiroAluno = propinaService.dadosFinanceirosDoAluno(p);
        return ResponseEntity.ok(dadosFinanceiroAluno);
    }

    @GetMapping(value =  "/pagamento-aluno/{idTurma}/{idAluno}", produces = "application/json")
    public ResponseEntity<Propina> pagamentoAluno( @PathVariable Long idTurma,@PathVariable Long idAluno) {
        PropinaDTO p = new PropinaDTO();
        p.setIdAluno(idAluno);
        p.setIdTurma(idTurma);

        System.out.println("DADOS DO ALUNO  PARA AS PROPINAS ============");
        System.out.println("idAluno: "+idAluno);
        System.out.println("idTurma: "+idTurma);
        
        Propina dadosFinanceiroAluno = propinaService.dadosFinanceirosDoAluno2(p);
        return ResponseEntity.ok(dadosFinanceiroAluno);
    }

    // Implemente outros endpoints relacionados a pagamentos de propinas, se necessário
}
