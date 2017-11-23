/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_ejer02;

import java.sql.DriverManager;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chern007
 */
public class AD02_Ejer02 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            String reportSource = "./reports/templates/template_ejer02.jrxml";
            String reportDest = "./reports/results/output.html";        
        
    Map<String, Object> params = new HashMap<String, Object>();
    
    params.put("reportTitle", "Informe Hola Mundo");
    params.put("author", "Carlos Hernández Crespo");
    params.put("startDate", (new java.util.Date()).toString());    
    
        try {
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            java.sql.Connection conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                        
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conexion);
            
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
                    
            JasperViewer.viewReport(jasperPrint);
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
