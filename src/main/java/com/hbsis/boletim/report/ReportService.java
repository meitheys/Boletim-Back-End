package com.hbsis.boletim.report;

import com.hbsis.boletim.aluno.Aluno;
import com.hbsis.boletim.aluno.AlunoRepository;
import com.hbsis.boletim.aluno.AlunoService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private final AlunoService alunoService;
    private final AlunoRepository alunoRepository;

    public ReportService(AlunoService alunoService, AlunoRepository alunoRepository) {
        this.alunoService = alunoService;
        this.alunoRepository = alunoRepository;
    }

    public String export(String response) throws FileNotFoundException, JRException {
        List<Aluno> alunoList = alunoRepository.findAll();
        String path = "C:\\Users\\matheus.furtado\\Desktop\\Reports";
        File file = ResourceUtils.getFile("classpath:alunos.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunoList);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("createdBy", "Aluno");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
        if(response.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\alunos.html"); }
        if (response.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\alunos.pdf");
        }
        return "Gerado no caminho: " + path;
    }
}