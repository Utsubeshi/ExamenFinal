package com.akitoy.proyecto.controller;

import com.akitoy.proyecto.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

@Controller
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/reporte/{format}")
    public String generarReporte(@PathVariable String format) throws FileNotFoundException, JRException {

        return reportService.exportarReporte(format);
    }
}
