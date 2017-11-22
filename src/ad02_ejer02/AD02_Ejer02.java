/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_ejer02;

import java.io.File;
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
    
        try {
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
            
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
                    
            JasperViewer.viewReport(jasperPrint);
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
