package com.hbsis.boletim.report;

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
    private final AlunoRepository alunoRepository;
    private final NotasRepository notasRepository;

    public ReportService(AlunoService alunoService, AlunoRepository alunoRepository, NotasRepository notasRepository) {
        this.alunoService = alunoService;
        this.alunoRepository = alunoRepository;
        this.notasRepository = notasRepository;
    }

    public String export(String response, long id) throws FileNotFoundException, JRException {
        List<Notas> notas = notasRepository.findByAluno(alunoService.findByIdAluno(id));
        String path = "C:\\Users\\matheus.furtado\\Desktop\\Reports";
        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(notas);
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("createdBy", "Matheus");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);
            if(response.equalsIgnoreCase("html")){
                JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\boletim" + id + ".html"); }
            if (response.equalsIgnoreCase("pdf")){
                JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\boletim" + id + ".pdf");
        }
        return "Gerado no caminho: " + path;
    }
}