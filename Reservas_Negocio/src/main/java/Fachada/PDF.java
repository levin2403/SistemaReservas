/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PDF {

    // Ruta donde se guardará el PDF
    private String pdfPath = "ReporteReservas.pdf";

    public void generarPDF(JTable reportTable, String fechaInicio, String fechaFin) {
        try (PdfWriter writer = new PdfWriter(pdfPath); PdfDocument pdf = new PdfDocument(writer); Document document = new Document(pdf)) {

            // Título del PDF
            document.add(new Paragraph("Reporte de Reservas").setFontSize(20).setBold());

            // Agregar rango de fechas
            document.add(new Paragraph("Rango de fechas: " + fechaInicio + " a " + fechaFin));

//            // Crear tabla
//            Table table = new Table(new float[]{1, 3, 2, 2, 2, 2, 2}); // Columnas con anchos relativos
//// Establecer el ancho de la tabla como porcentaje del ancho del documento
//            table.setWidthPercent(100);
//// Agregar encabezados de la tabla
//            table.addHeaderCell(new Cell().add("Fecha y Hora"));
//            table.addHeaderCell(new Cell().add("Nombre del Cliente"));
//            table.addHeaderCell(new Cell().add("Número de Personas"));
//            table.addHeaderCell(new Cell().add("Tipo de Mesa"));
//            table.addHeaderCell(new Cell().add("Ubicación"));
//            table.addHeaderCell(new Cell().add("Costo"));
//            table.addHeaderCell(new Cell().add("Multas"));
//
//            // Agregar datos de la tabla
//            for (int i = 0; i < reportTable.getRowCount(); i++) {
//                for (int j = 0; j < reportTable.getColumnCount(); j++) {
//                    Object value = reportTable.getValueAt(i, j);
//                    table.addCell(new Cell().add(value != null ? value.toString() : ""));
//                }
//            }

//            document.add(table);
//            // Mensaje de confirmación
//            JOptionPane.showMessageDialog(null, "PDF exportado exitosamente en: " + new File(pdfPath).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al exportar a PDF: " + e.getMessage());
        }
    }
}
