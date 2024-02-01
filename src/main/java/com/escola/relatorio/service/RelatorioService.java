package com.escola.relatorio.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.escola.model.Aluno;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelatorioService {
	
	 public byte[] gerarRelatorioMAtricula(List<String> dados,Aluno aluno) throws JRException {
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

	        // Gera o relatório
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

	        // Visualize o relatório
            //JasperViewer.viewReport(jasperPrint, false);
	        // Exporta para o formato desejado (PDF no caso)
	        byte[] relatorioPDF = JasperExportManager.exportReportToPdf(jasperPrint);
	        
	        // Gerar Relatorio e Armazenar no Destino
	        //String destino = "C:\\Users\\AJCC\\Documents\\projecto\\Backend\\ficheiros\\matricula.pdf";
	        //JasperExportManager.exportReportToPdfFile(jasperPrint, destino);
	        
	        System.out.println("Relatorio Gerado");

	        return relatorioPDF;
	    }
	 

}
