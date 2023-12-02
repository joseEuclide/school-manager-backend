package com.escola.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.PagamentoDTO;
import com.escola.dto.PropinaDTO;
import com.escola.model.Aluno;
import com.escola.model.PrecoPropina;
import com.escola.model.Propina;
import com.escola.model.Turma;
import com.escola.relatorio.RelatorioService;
import com.escola.repository.AlunoRepository;
import com.escola.repository.PrecoPropinaRepository;
import com.escola.repository.PropinaRepository;
import com.escola.repository.TurmaRepository;

@Service
public class PropinaService {
	
	@Autowired
    private PropinaRepository pr;

	@Autowired
    private TurmaRepository tr;
	
	@Autowired
    private AlunoRepository ar;
	
	@Autowired
    private PrecoPropinaRepository ppr;
	
	@Autowired
    private RelatorioService relatorioService;

    public PagamentoDTO registrarPagamento(PropinaDTO propinaDTO) throws Exception {
     
        // Verifique se já existe um pagamento registrado para o aluno, mês e ano especificados.
        // Se sim, você pode atualizar o pagamento existente em vez de criar um novo.

        PagamentoDTO p = new PagamentoDTO();
    	Optional<Turma> t2 = tr.findById(propinaDTO.getIdTurma());
    	String statusPagamento="";
        Optional<Aluno> aluno = ar.findById(propinaDTO.getIdAluno());
        if(aluno.isPresent() && t2.isPresent()) {
        	 Optional<Propina> prop =pr.findByAlunoAndTurma(aluno.get(), t2.get());
             if(prop.isPresent()) {
            	 
            	 
            		 Optional<PrecoPropina> p3 =  ppr.findByIdCursoAndNivel(t2.get().getCurso().getId(), t2.get().getNivel());
            	     if(p3.isPresent() && propinaDTO.getMesesAPagar() != null) {
            	    	 prop.get().setData(LocalDate.now());
            	    	 
            	    	 for (String c : propinaDTO.getMesesAPagar()) {
            	    		 if(c.equalsIgnoreCase("setembro")) {
            	    			 prop.get().setSetembro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Outubro")) {
            	    			 prop.get().setOutubro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Novembro")) {
            	    			 prop.get().setNovembro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Dezembro")) {
            	    			 prop.get().setDezembro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Janeiro")) {
            	    			 prop.get().setJaneiro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Fevereiro")) {
            	    			 prop.get().setFevereiro(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Marco")) {
            	    			 prop.get().setMarco(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Abril")) {
            	    			 prop.get().setAbril(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Maio")) {
            	    			 prop.get().setMaio(p3.get().getValor());
            	    		 }
            	    		 if(c.equalsIgnoreCase("Junho")) {
            	    			 prop.get().setJunho(p3.get().getValor());
            	    		 }
            	    	 }
                    	 
                    	 
                    	 pr.save(prop.get());
                    	 statusPagamento = "Pagamento Efectuado Com Sucesso !";
                    	 p.setMensagem(statusPagamento);

                         byte[] pdfBytes = relatorioService.gerarRelatorioAluno(aluno.get());
            	         p.setRelatorio(pdfBytes);
            	     }
            	 
            	 
             }else {
            	 statusPagamento = "Não Existe Registro De Propina Para Esse Aluno !";
             }
             
        }else {
        	statusPagamento = "Não Existe Aluno Com Esse ID Na Escola !";
        }
       
       return p; 
    }
    
    
    
    public PagamentoDTO dadosFinanceirosDoAluno(PropinaDTO propinaDTO) {
        
        // Verifique se já existe um pagamento registrado para o aluno, mês e ano especificados.
        // Se sim, você pode atualizar o pagamento existente em vez de criar um novo.

    	PagamentoDTO p4 = new PagamentoDTO();
        p4.setMensagem("Não Existe Aluno Com os Dados Informados");
    	ArrayList<String> mesesAPagar = new ArrayList<>();
    	Optional<Turma> t2 = tr.findById(propinaDTO.getIdTurma());
        Optional<Aluno> aluno = ar.findById(propinaDTO.getIdAluno());
        if(aluno.isPresent() && t2.isPresent()) {
        	 Optional<Propina> prop =pr.findByAlunoAndTurma(aluno.get(), t2.get());
                 if(prop.isPresent()) {
            	 
		                	 
            	    		 if( prop.get().getSetembro() == null) {
            	    			 mesesAPagar.add("Setembro");
            	    		 }
            	    		 if(prop.get().getOutubro()==null) {
		    	    			 mesesAPagar.add("Outubro");
		    	    		 }
            	    		 if(prop.get().getNovembro()==null) {
            	    			 mesesAPagar.add("Novembro");
            	    		 }
            	    		 if(prop.get().getDezembro()==null) {
            	    			 mesesAPagar.add("Dezembro");
            	    		 }
            	    		 if(prop.get().getJaneiro()==null) {
            	    			 mesesAPagar.add("Janeiro");
            	    		 }
            	    		 if(prop.get().getFevereiro()==null) {
            	    			 mesesAPagar.add("Fevereiro");
            	    		 }
            	    		 if(prop.get().getMarco()==null) {
            	    			 mesesAPagar.add("Marco");
            	    		 }
            	    		 if(prop.get().getAbril()==null) {
            	    			 mesesAPagar.add("Abril");
            	    		 }
            	    		 if(prop.get().getMaio()==null) {
            	    			 mesesAPagar.add("Maio");
            	    		 }
            	    		 if(prop.get().getJunho()==null) {
            	    			 mesesAPagar.add("Junho");
            	    		 }
            	    	 
                    	     System.out.println("============= Aluno:\n\n");
                    	     System.out.println("Nome: "+aluno.get().getNome());
                    	     System.out.println("ID: "+aluno.get().getId());
                    	     System.out.println("Turma: "+aluno.get().getTurma().getNome());
                    	     System.out.println("BI. "+ aluno.get().getBi());
                    	     p4.setId(aluno.get().getId());
                             p4.setNome(aluno.get().getNome());
                             p4.setCurso(t2.get().getCurso().getNome());
                             p4.setNivel(t2.get().getNivel());
                             p4.setTurno(t2.get().getTurno());
                             p4.setTurma(t2.get().getNome());
                             p4.setMensagem("Existe Aluno Com os Dados Informados");
                    	     p4.setMesesAPagar(mesesAPagar);
                    	     
                    	  
            	     
            	 
            	 
             }
             
        }else {
            p4.setMensagem("Não Existe Aluno Com os Dados Informados");
        }
       
       return p4; 
    }

	public Propina dadosFinanceirosDoAluno2(PropinaDTO propinaDTO) {
        
        // Verifique se já existe um pagamento registrado para o aluno, mês e ano especificados.
        // Se sim, você pode atualizar o pagamento existente em vez de criar um novo.
        Optional<Propina> prop = null;
    	ArrayList<String> mesesAPagar = new ArrayList<>();
    	Optional<Turma> t2 = tr.findById(propinaDTO.getIdTurma());
        Optional<Aluno> aluno = ar.findById(propinaDTO.getIdAluno());
        if(aluno.isPresent() && t2.isPresent()) {
        	 prop = pr.findByAlunoAndTurma(aluno.get(), t2.get());
             return prop.get();   
             
        }else {
              return null; 
        }
       

    }

}
