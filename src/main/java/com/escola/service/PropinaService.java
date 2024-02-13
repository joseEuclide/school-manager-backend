package com.escola.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.PagamentoDTO;
import com.escola.dto.PropinaDTO;
import com.escola.dto.TesourariaDTO;
import com.escola.model.Aluno;
import com.escola.model.PrecoPropina;
import com.escola.model.Propina;
import com.escola.model.Turma;
import com.escola.relatorio.service.RelatorioService;
//import com.escola.relatorio.RelatorioService;
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
    private RelatorioService rs;
	
	//@Autowired
    //private RelatorioService relatorioService;

    public PagamentoDTO registrarPagamento(PropinaDTO propinaDTO) throws Exception {
     
        // Verifique se já existe um pagamento registrado para o aluno, mês e ano especificados.
        // Se sim, você pode atualizar o pagamento existente em vez de criar um novo.

        PagamentoDTO p = new PagamentoDTO();
    	Optional<Turma> t2 = tr.findById(propinaDTO.getIdTurma());
    	String statusPagamento="";
    	ArrayList<TesourariaDTO> listaDePagamentos = new ArrayList<>();
    	Aluno aluno2 = null;
    	
        Optional<Aluno> aluno = ar.findById(propinaDTO.getIdAluno());
        if(aluno.isPresent() && t2.isPresent()) {
        	 aluno2 = aluno.get();
        	 Optional<Propina> prop =pr.findByAlunoAndTurma(aluno.get(), t2.get());
             if(prop.isPresent()) {
            	 
            	 
            		 Optional<PrecoPropina> p3 =  ppr.findByIdCursoAndNivel(t2.get().getCurso().getId(), t2.get().getNivel());
            	     if(p3.isPresent() && propinaDTO.getMesesAPagar() != null) {
            	    	 prop.get().setData(LocalDate.now());
            	    	// Depois do dia 15 do corrente mes Vao Pagar Com Multa de 3000 Kz
        	    		 
        	    		 int diaHoje = LocalDate.now().getDayOfMonth();
        	    		 
            	    	 
            	    	 for (String c : propinaDTO.getMesesAPagar()) {
            	    		 
            	    		 TesourariaDTO tDTO = new TesourariaDTO();
            	    		 tDTO.setMes(c);
            	    		 
            	    		 
            	    		 if(diaHoje > 15) {
            	    			 tDTO.setMultaPropina(3000);
            	    			 tDTO.setPropina(p3.get().getValor() + 3000);
            	    			 
            	    			 if(c.equalsIgnoreCase("setembro")) {
                	    			 prop.get().setSetembro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Outubro")) {
                	    			 prop.get().setOutubro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Novembro")) {
                	    			 prop.get().setNovembro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Dezembro")) {
                	    			 prop.get().setDezembro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Janeiro")) {
                	    			 prop.get().setJaneiro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Fevereiro")) {
                	    			 prop.get().setFevereiro(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Marco")) {
                	    			 prop.get().setMarco(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Abril")) {
                	    			 prop.get().setAbril(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Maio")) {
                	    			 prop.get().setMaio(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Junho")) {
                	    			 prop.get().setJunho(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Julho")) {
                	    			 prop.get().setJulho(p3.get().getValor() + 3000);
                	    		 }
                	    		 if(c.equalsIgnoreCase("Agosto")) {
                	    			 prop.get().setAgosto(p3.get().getValor() + 3000);
                	    		 }
            	    		 }else {
            	    			 tDTO.setMultaPropina(0);
            	    			 tDTO.setPropina(p3.get().getValor());
            	    			 
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
                	    		 if(c.equalsIgnoreCase("Julho")) {
                	    			 prop.get().setJulho(p3.get().getValor());
                	    		 }
                	    		 if(c.equalsIgnoreCase("Agosto")) {
                	    			 prop.get().setAgosto(p3.get().getValor());
                	    		 }
            	    		 }
            	    		 //listaDePagamentos.add(tDTO);
            	    		 
            	    		 
            	    		 
            	    	 }
                    	 
                    	 
                    	 pr.save(prop.get());
                    	 statusPagamento = "Pagamento Efectuado Com Sucesso !";
                    	 p.setMensagem(statusPagamento);

                    	 if(aluno2 != null && listaDePagamentos!=null) {
                    		 rs.gerarRelatorioMAtricula(listaDePagamentos, aluno2,"propina"); 
                    	 }
                    	 
                    	 String caminhoRelatorio = rs.caminhoRelatorio("propina");
            	         p.setRelatorio(caminhoRelatorio);
            	     }
            	 
            	 
             }else {
            	 statusPagamento = "Não Existe Registro De Propina Para Esse Aluno !";
            	 p.setMensagem(statusPagamento);
             }
             
        }else {
        	statusPagamento = "Não Existe Aluno Com Esse ID Na Escola !";
        	p.setMensagem(statusPagamento);
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
            	 System.out.println("==========> "+prop.get().getMarco());
		                	 
            	    		 if(prop.get().getJaneiro()==0) {
            	    			 
            	    			 System.out.println("Janeiro");
            	    			 mesesAPagar.add("Janeiro");
            	    		 }
            	    		 if(prop.get().getFevereiro()==0) {
            	    			 System.out.println("Fevereiro");
            	    			 mesesAPagar.add("Fevereiro");
            	    		 }
            	    		 if(prop.get().getMarco()==0) {
            	    			 System.out.println("Março");
            	    			 mesesAPagar.add("Marco");
            	    		 }
            	    		 if(prop.get().getAbril()==0) {
            	    			 System.out.println("Abril");
            	    			 mesesAPagar.add("Abril");
            	    		 }
            	    		 if(prop.get().getMaio()==0) {
            	    			 System.out.println("Maio");
            	    			 mesesAPagar.add("Maio");
            	    		 }
            	    		 if(prop.get().getJunho()==0) {
            	    			 System.out.println("Junho");
            	    			 mesesAPagar.add("Junho");
            	    		 }if(prop.get().getJulho()==0) {
            	    			 System.out.println("Julho");
            	    			 mesesAPagar.add("Julho");
            	    		 }if(prop.get().getAgosto()==0) {
            	    			 System.out.println("Agosto");
            	    			 mesesAPagar.add("Agosto");
            	    		 }if( prop.get().getSetembro() == 0) {
            	    			 System.out.println("Setembro");
            	    			 mesesAPagar.add("Setembro");
            	    		 }
            	    		 if(prop.get().getOutubro()==0) {
            	    			 System.out.println("Outubro");
		    	    			 mesesAPagar.add("Outubro");
		    	    		 }
            	    		 if(prop.get().getNovembro()==0) {
            	    			 System.out.println("Novembro");
            	    			 mesesAPagar.add("Novembro");
            	    		 }
            	    		 if(prop.get().getDezembro()==0) {
            	    			 System.out.println("Dezembro");
            	    			 mesesAPagar.add("Dezembro");
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
                    	     
                    	     int diaHoje = LocalDate.now().getDayOfMonth();
                    	     if(diaHoje > 15) {
                    	    	 p4.setMulta(3000+"");
                    	     }
                    	     Optional<PrecoPropina> p3 =  ppr.findByIdCursoAndNivel(t2.get().getCurso().getId(), t2.get().getNivel());
                    	     if(p3.isPresent()) {
                    	    	 p4.setPropina(p3.get().getValor()+"");
                    	     }
                    	  
            	     
            	 
            	 
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
    	Optional<Turma> t2 = tr.findById(propinaDTO.getIdTurma());
        Optional<Aluno> aluno = ar.findById(propinaDTO.getIdAluno());
        if(aluno.isPresent() && t2.isPresent()) {
			 System.out.println("============= Existe Aluno Com Esses Dados Financeiros");
        	 prop = pr.findByAlunoAndTurma(aluno.get(), t2.get());
             return prop.get();   
             
        }else {
              return null; 
        }
       

    }

}
