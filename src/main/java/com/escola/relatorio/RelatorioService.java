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
	
   
   
   public byte[] gerarRelatorioAlunoMatricula(Aluno aluno) throws Exception {
       // Carregue o modelo do relatório .jrxml
       InputStream inputStream = getClass().getResourceAsStream("/relatorio/propina.jasper");

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
   
   
   
   
   public byte[] gerarRelatorioAlunoPropina(Aluno aluno) throws Exception {
       // Carregue o modelo do relatório .jrxml
       InputStream inputStream = getClass().getResourceAsStream("/relatorio/propina.jasper");

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
   
   
   
   

/*
public byte[] gerarRelatorioPropinas(
       String nome,
       String curso, String turno, String nivel, ArrayList<String> mesesPagos) throws Exception {

   // Lógica para obter dados do banco de dados com base nos parâmetros
   List<Propina> propinas = propinaService.obterPropinas(alunoId, cursoId, nivel);

   // Carregar o modelo do relatório
   InputStream jasperStream = this.getClass().getResourceAsStream("/relatorio/propina.jasper");
   JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);

   // Configurar o DataSource
   JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(propinas);

   // Parâmetros do relatório
   Map<String, Object> params = new HashMap<>();
   params.put("nome", nome);
   params.put("curso", curso);
   params.put("nivel", nivel);
   params.put("turno", turno);

   // Gerar o relatório em formato byte[]
   byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, params, dataSource);

   
   return bytes;
} */
	
	
	
}
