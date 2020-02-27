package com.hbsis.boletim.report;

import com.hbsis.boletim.aluno.Aluno;
import com.hbsis.boletim.aluno.AlunoRepository;
import com.hbsis.boletim.aluno.AlunoService;
import com.hbsis.boletim.notas.Notas;
import com.hbsis.boletim.notas.NotasRepository;
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
    private final NotasRepository notasRepository;

    public ReportService(AlunoService alunoService, NotasRepository notasRepository) {
        this.alunoService = alunoService;
        this.notasRepository = notasRepository;
    }

    public String export(String response, long id, String semestre) throws FileNotFoundException, JRException {
        List<Notas> notas = notasRepository.findByAlunoAndSemestre(alunoService.findByIdAluno(id), semestre);
        String path = "C:\\Users\\matheus.furtado\\Desktop\\Reports";
        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(notas);
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("createdBy", "Matheus");
            String extensao = "";
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
            if(response.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\boletim" + "Aluno" + id + "Semestre" + semestre + ".html");
                extensao = "HTML";
            }
            if (response.equalsIgnoreCase("pdf")){
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\boletim" + "Aluno" + id + "Semestre" + semestre + ".pdf");
                extensao = "PDF";
        }
        return "O " + extensao + " foi gerado no caminho: " + path;
    }
}