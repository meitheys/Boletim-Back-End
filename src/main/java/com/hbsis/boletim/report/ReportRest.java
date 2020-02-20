package com.hbsis.boletim.report;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/jrxml")
public class ReportRest {

    private final ReportService reportService;

    @Autowired
    public ReportRest(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/{format}/{id}")
    public String gerarReport(@PathVariable(name = "format") String format, @PathVariable(name = "id") long id) throws FileNotFoundException, JRException {
        return reportService.export(format, id);
    }
}