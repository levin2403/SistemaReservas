package Fachada;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Sebastian Murrieta
 */
public class PDF {

    public void generarPDF(JTable reportTable, String fechaInicio, String fechaFin) {
        // Crear un JFileChooser para que el usuario elija la ubicación y el nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Configuración inicial de nombre sugerido del archivo
        fileChooser.setSelectedFile(new File("ReporteReservas.pdf"));

        // Mostrar el diálogo de guardado
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String pdfPath = fileToSave.getAbsolutePath();

            // Verificar si el archivo termina en ".pdf", y agregarlo si no lo tiene
            if (!pdfPath.endsWith(".pdf")) {
                pdfPath += ".pdf";
            }

            try (PdfWriter writer = new PdfWriter(pdfPath); PdfDocument pdf = new PdfDocument(writer); Document document = new Document(pdf)) {

                // Título del PDF
                document.add(new Paragraph("Reporte de Reservas").setFontSize(20).setBold());

                // Agregar rango de fechas
                document.add(new Paragraph("Rango de fechas: " + fechaInicio + " a " + fechaFin));

                // Crear tabla con anchos de columna relativos
                Table table = new Table(new float[]{1, 3, 2, 2, 2, 2, 2});
                table.setWidth(UnitValue.createPercentValue(100));

                // Agregar encabezados de la tabla
                table.addHeaderCell(new Cell().add(new Paragraph("Fecha y Hora")));
                table.addHeaderCell(new Cell().add(new Paragraph("Nombre del Cliente")));
                table.addHeaderCell(new Cell().add(new Paragraph("Número de Personas")));
                table.addHeaderCell(new Cell().add(new Paragraph("Tipo de Mesa")));
                table.addHeaderCell(new Cell().add(new Paragraph("Ubicación")));
                table.addHeaderCell(new Cell().add(new Paragraph("Costo")));
                table.addHeaderCell(new Cell().add(new Paragraph("Multas")));

                // Agregar datos de la tabla desde el JTable
                for (int i = 0; i < reportTable.getRowCount(); i++) {
                    for (int j = 0; j < reportTable.getColumnCount(); j++) {
                        Object value = reportTable.getValueAt(i, j);
                        table.addCell(new Cell().add(new Paragraph(value != null ? value.toString() : "")));
                    }
                }

                // Agregar la tabla al documento
                document.add(table);

                // Mensaje de confirmación
                JOptionPane.showMessageDialog(null, "PDF exportado exitosamente en: " + pdfPath);

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al exportar a PDF: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Exportación cancelada por el usuario.");
        }
    }
}
