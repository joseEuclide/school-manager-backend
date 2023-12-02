package com.escola.relatorio;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.escola.model.Aluno;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class RelatorioService {
   public byte[] gerarRelatorioAluno(Aluno aluno) throws Exception {
       // Carregue o modelo do relatório .jrxml
       InputStream inputStream = getClass().getResourceAsStream("/caminho/para/seu/modelo.jrxml");

       // Compile o modelo do relatório
       JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

       // Crie um objeto de parâmetros para passar os dados do aluno para o relatório
       Map<String, Object> params = new HashMap<>();
       params.put("nome", aluno.getNome());
       params.put("matricula", aluno.getBi());
       // Adicione outros parâmetros conforme necessário

       // Crie uma fonte de dados vazia, pois não estamos usando um banco de dados aqui
       JRDataSource dataSource = new JREmptyDataSource();

       // Preencha o relatório com os dados
       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

       // Exporte o relatório em formato PDF
       byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

       return pdfBytes;
   }
	
	
	
}
