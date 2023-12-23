package com.escola.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.dto.NotaDTO;
import com.escola.dto.NotaDTO3;
import com.escola.model.Aluno;
import com.escola.model.Disciplina;
import com.escola.model.Nota;
import com.escola.model.Permissao;
import com.escola.model.Professor;
import com.escola.model.Turma;
import com.escola.repository.AlunoRepository;
import com.escola.repository.DisciplinaRepository;
import com.escola.repository.NotaRepository;
import com.escola.repository.PermissaoRepository;
import com.escola.repository.ProfessorRepository;
import com.escola.repository.TurmaRepository;

@Service
public class NotaService {

    @Autowired
	private AlunoRepository alunoRepository;

    
    @Autowired
	private TurmaRepository tr;
    
    @Autowired
	private NotaRepository nr;
    
    @Autowired
    private PermissaoRepository permisaoR;
    
    @Autowired
    private ProfessorRepository pr;
    
    @Autowired
    private DisciplinaRepository dr;

    public String lançarNotasParaDisciplina( Long idProf,Long idTurma,Long idDisciplina,List<NotaDTO> notaDtos) {
       
    	String retorno = "";
    	if(notaDtos != null) {
    			
    	    	Optional<Permissao> existeProfessor = permisaoR.findByIdProf(idProf);
    	    	// Existe PRofessor Com Esse Id
    	    	
    	    	if(existeProfessor.isPresent()) {
    	    		Permissao permissao = existeProfessor.get();
    	    		System.out.println("Tipo de Prova: "+permissao.getTipoDeProva());
    	    		System.out.println("Epoca de Lancar Prova: "+permissao.iseEpocaDeLancamento());
    	    		System.out.println("Lancar Em Casa: "+permissao.isLancarEmCasa());
    	    		System.out.println("Lancar Na Escola: "+permissao.isLancarNaEscola());
    	    		
    	    		if((permissao.iseEpocaDeLancamento() && permissao.isLancarEmCasa()) || 
    	    				(permissao.iseEpocaDeLancamento() && permissao.isLancarNaEscola())){
    	    			
    	    			System.out.println("Entro Agoraaaaaaaaaaaaaaaaaaaaaaaa");
    	    			Optional<Turma>  turma = tr.findById(idTurma);
    	    			if(turma.isPresent()) {
    	    				System.out.println("NOvooooooooooooooooooooooo");
    	    				lancarNotas(notaDtos, idDisciplina, turma.get(), idProf, permissao.getTipoDeProva());
    	    			}else {
    	    				retorno = "Não Estás Cadastrado Na Turma Que Pretendes Lançar Essas Notas";
    	    			}
    	    			
    	    			
    	    		}else {
    	    			retorno = "Nao Tens Autorizacao Para Lancar as Provas, Dirija-se a Directoria";
    	    		}
    	    		 		
    	    	}else {
    	    		retorno = "Esse Professor Não Tem A Permissão de Lançar as Notas";
    	    	}
    		
    	}
    	return retorno;
    	
    }
    
    public List<Nota> listarNotasDoAluno(Long alunoId) {
        // Verifique se o aluno com o ID especificado existe no banco de dados
    	
    	List<Nota> n2 = null;
    	ArrayList<NotaDTO3> notasDTOs3 = new ArrayList<>();
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (!alunoOptional.isPresent()) {
            // Trate o caso em que o aluno não foi encontrado
        	 return null;
        }

        Aluno aluno = alunoOptional.get();
       
        // Consulte todas as notas associadas a este aluno
        n2 =  nr.findByTurmaAndIdAluno(  aluno.getTurma(),alunoId);
        
        ArrayList<Disciplina> disciplinasDaTurma = dr.findByCursoAndNivel(aluno.getTurma().getCurso(), aluno.getTurma().getNivel());
		
        
        if(n2 != null) {

        	/*for(Nota cadaC : n2) {
        		NotaDTO3 notaDTO3 = new NotaDTO3();
    			sair:
    			for(Disciplina cadaC2: disciplinasDaTurma) {
    				
    				if(cadaC.getIdDisciplina() == cadaC2.getId()) {
    					notaDTO3.setDisciplina(cadaC2.getNome());
    					notaDTO3.setNotaPorDisciplina(cadaC);
    					
    					notasDTOs3.add(notaDTO3);
    					break sair;
    				}
    			}
    		}
			*/
        	System.out.println("MMMMMMMMMMMMMMMM   TEM ALUNO ==================");
        	return n2;
        }else {
        	System.out.println("MMMMMMMMMMMMMMMM  NAO TEM ALUNO ==================");
        	return n2;
        }
        
    }
    
    public List<Nota> listarTodasAsNotas(Long idTurma) {
    	Optional<Turma> turma =  tr.findById(idTurma);
    	if(turma.isPresent()) {
    		System.out.println("tem turma");
    		return nr.findAllByTurma(turma.get());
    	}else { return null; }
        
    }

    // Outros métodos relacionados a notas, se necessário


   public boolean lancarNotas(List<NotaDTO> notaDtos, Long idDisciplina,
		Turma turma, Long idProf,String tipoDeProva) {

	boolean retorno = false;	
	int contador = 0;
	for(NotaDTO n :notaDtos) {
		
		Optional<Professor> prof =pr.findById(idProf);
		Optional<Nota>  nota = nr.findByIdAlunoAndTurmaAndIdDisciplina(n.getIdAluno(),turma,idDisciplina);
		
		if(nota.isPresent()) {
			Nota novaNota = nota.get();
			Nota novaNota2 = null;
			System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ\n\n\n");
			novaNota.setProfessor(prof.get());
				if(novaNota.getIdDisciplina()==idDisciplina) {
					if(turma.getNivel().equalsIgnoreCase("10") ||
					   turma.getNivel().equalsIgnoreCase("11") ||
					   turma.getNivel().equalsIgnoreCase("8") ||
					   turma.getNivel().equalsIgnoreCase("7") ||
					   turma.getNivel().equalsIgnoreCase("6") ||
					   turma.getNivel().equalsIgnoreCase("5") ||
					   turma.getNivel().equalsIgnoreCase("4") ||
					   turma.getNivel().equalsIgnoreCase("3") ||
					   turma.getNivel().equalsIgnoreCase("2") ||
					   turma.getNivel().equalsIgnoreCase("1")) {
						System.out.println( " =======================  Entrou nnesse NIVEL");
						novaNota2 = tipoDeProva(novaNota, idDisciplina, tipoDeProva, n.getNotaDoAluno());
						nr.saveAndFlush(novaNota2);
						
					}else {
						System.out.println( " =======================  OOOOOOOOOO");
						novaNota2 = tipoDeProva2(novaNota, idDisciplina, tipoDeProva, n.getNotaDoAluno());
						nr.saveAndFlush(novaNota2);
						
					}	
					
				    
				}
				
			
			
			retorno = true;
		}
		
		++contador;
		System.out.println(contador+"º Nota Lancada");
	}
	
	
	return retorno;
   }
    
   private Nota tipoDeProva(Nota n2, Long idDisciplina, String tipoDeProva,Double nota) {
	   

	        double calcularNota;
			if(tipoDeProva.equalsIgnoreCase("mac1")) {
				n2.setMac1(nota);
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			}
			
			if(tipoDeProva.equalsIgnoreCase("npp1")) {
				n2.setNpp1(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt1")) {
				n2.setNpt1(nota);
				calcularNota = (n2.getMac1() + n2.getNpp1() +n2.getNpt1())/3;
				n2.setNotaPrimeiroTrimestre(calcularNota);
			}else if(tipoDeProva.equalsIgnoreCase("mac2")) {
				n2.setMac2(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npp2")) {
				n2.setNpp2(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt2")) {
				n2.setNpt2(nota);
				calcularNota = (n2.getMac2() + n2.getNpp2() +n2.getNpt2())/3;
				n2.setNotaSegundoTrimestre(calcularNota);
			}else if(tipoDeProva.equalsIgnoreCase("mac3")) {
				n2.setMac3(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npp3")) {
				n2.setNpp3(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt3")) {
				n2.setNpt3(nota);
				calcularNota = (n2.getMac3() + n2.getNpp3() +n2.getNpt3())/3;
				n2.setNotaTerceiroTrimestre(calcularNota);
				
				double nfd2 = ( n2.getNotaPrimeiroTrimestre() +  n2.getNotaSegundoTrimestre() + n2.getNotaTerceiroTrimestre() ) /3;
				n2.setNfd(nfd2);
				n2.setNotaFinal(nfd2);
			}
			
		
	
		return n2;
   }
   
   
   private Nota tipoDeProva2(Nota n2, Long idDisciplina, String tipoDeProva,Double nota) {
	   

	    double calcularNota;
			if(tipoDeProva.equalsIgnoreCase("mac1")) {
				n2.setMac1(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npp1")) {
				n2.setNpp1(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt1")) {
				n2.setNpt1(nota);
				calcularNota = (n2.getMac1() + n2.getNpp1() +n2.getNpt1())/3;
				n2.setNotaPrimeiroTrimestre(calcularNota);
			}else if(tipoDeProva.equalsIgnoreCase("mac2")) {
				n2.setMac2(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npp2")) {
				n2.setNpp2(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt2")) {
				n2.setNpt2(nota);
				calcularNota = (n2.getMac2() + n2.getNpp2() +n2.getNpt2())/3;
				n2.setNotaSegundoTrimestre(calcularNota);
			}else if(tipoDeProva.equalsIgnoreCase("mac3")) {
				n2.setMac3(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npp3")) {
				n2.setNpp3(nota);
			}else if(tipoDeProva.equalsIgnoreCase("npt3")) {
				n2.setNpt3(nota);
				calcularNota = (n2.getMac3() + n2.getNpp3() +n2.getNpt3())/3;
				n2.setNotaTerceiroTrimestre(calcularNota);
				
				double nfd2 = ( n2.getNotaPrimeiroTrimestre() +  n2.getNotaSegundoTrimestre() + n2.getNotaTerceiroTrimestre() ) /3;
				n2.setNfd(nfd2);
				
			
			}else if(tipoDeProva.equalsIgnoreCase("mec")) {
				n2.setMec(nota);
				calcularNota = (n2.getNfd() * 0.6) + (n2.getMec() * 0.4);
				n2.setNotaFinal(calcularNota);
			}
			
		
	
		return n2;
  }
   
   public List<Nota> listarNotasPorTurmahDisciplina(Long idTurma, Long idDisciplina) {
	   
	   Optional<Turma> turma =  tr.findById(idTurma);
	   if(turma.isPresent()) {
	   		System.out.println("tem turma");
	   		return nr.findByTurmaAndIdDisciplina(turma.get(), idDisciplina);
	   	}else { return null; }
	   
	   
   	
   }

}
