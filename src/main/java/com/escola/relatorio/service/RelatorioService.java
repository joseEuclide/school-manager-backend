package com.escola.relatorio.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.escola.dto.TesourariaDTO;
import com.escola.model.Aluno;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.Resource;


@Service
public class RelatorioService {
	
	
	@Autowired
    private ResourceLoader resourceLoader;
	
	 public byte[] gerarRelatorioMAtricula(List<TesourariaDTO> dados,Aluno aluno,String tipoDeRelatorio) throws JRException {
	        // Carrega o arquivo .jrxml (modelo do relatório)
	        InputStream inputStream = getClass().getResourceAsStream("/relatorios/matricula.jrxml");

	        
	        // Compila o modelo
	        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

	        
	        // Cria uma fonte de dados a partir da lista de dados
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);

	        // Parâmetros, se houver
	        Map<String, Object> parametros = new HashMap<>();
	        
	         parametros.put("instituicao", "Colegio Jonas");
	         parametros.put("curso", aluno.getTurma().getCurso().getNome());
	         parametros.put("turno", aluno.getTurma().getTurno());
	         parametros.put("nivel", aluno.getTurma().getNivel());
	         parametros.put("estudante", aluno.getNome());
	         parametros.put("id", aluno.getId()+"");
	         parametros.put("turma", aluno.getTurma().getId()+""); 
	         parametros.put("lista", dados);

	        // Gera o relatório
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

	        // Visualize o relatório
            //JasperViewer.viewReport(jasperPrint, false);
	        // Exporta para o formato desejado (PDF no caso)
	        //byte[] relatorioPDF = JasperExportManager.exportReportToPdf(jasperPrint);
	        
	        // Gerar Relatorio e Armazenar no Destino
	        
	        
	        
	        RelatorioService rs = new RelatorioService();
	        String destino = rs.caminhoRelatorio(tipoDeRelatorio);
	        JasperExportManager.exportReportToPdfFile(jasperPrint, destino);
	        
	        
	        System.out.println("Relatorio Gerado");

	        return null;
	    }
	 
	    
	    public String caminhoRelatorio(String tipoDeRelatorio){
	    	
	    	String destino = "C:\\Users\\AJCC\\Documents\\Nova pasta\\Nova pasta (6)\\projecto\\src\\assets\\pdfs\\";
	    	
	    	if(tipoDeRelatorio.equalsIgnoreCase("propina")) {
	    		destino = destino+"propina.pdf";
	    		
	    	}else if(tipoDeRelatorio.equalsIgnoreCase("matricula")) {
	    		destino = destino+"matricula.pdf";
	    	}
	    	
	    	
	    	
	    	return destino;
	    }
	    
	    
	    public void setResourceLoader(ResourceLoader resourceLoader) {
	    	//Resourcep
	    }
	    
	    public String getResourcePath(String folderName) throws IOException {
	        Resource resource = resourceLoader.getResource("classpath:" + folderName);
	        return resource.getFile().getAbsolutePath();
	    }
	 

}
