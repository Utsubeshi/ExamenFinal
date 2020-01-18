package com.akitoy.proyecto.service;

import com.akitoy.proyecto.model.Producto;
import com.akitoy.proyecto.repository.ProductoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternUtils;
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
    private ProductoRepository productoRepository;

    public String exportarReporte(String reportFormat) throws FileNotFoundException, JRException {
        List<Producto> productoList = (List<Producto>) productoRepository.findAll();  //verificar

        //File plantilla = ResourceUtils.getFile("classpath:ListaProducto.jrxml)");

        //JasperReport reporte = JasperCompileManager.compileReport(plantilla.getAbsolutePath());
        JasperReport reporte = JasperCompileManager.compileReport("C:\\repoJavaWeb\\ProyectoSpring\\src\\main\\resources\\ListaProducto.jrxml");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productoList);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("creado por:", "Juan Niño");

        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte , parametros , dataSource);
        String ruta =  "C:\\Users\\JuanK\\Desktop";

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, ruta + "\\ListaProductos.html" );
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "\\ListaProductos.pdf" );
        }
        return "reporteOK";
    }
}
