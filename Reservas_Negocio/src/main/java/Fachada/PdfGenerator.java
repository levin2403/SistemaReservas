package Fachada;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

/**
 *
 * @author Sebastian Murrieta
 */
public class PdfGenerator {

    public boolean generarPDFDesdeFormulario(String fechaInicio, String fechaFin, String tipoMesa, String ubicacion) {
        // Se solicita al usuario la ubicación donde guardar el PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("Reporte_" + System.currentTimeMillis() + ".pdf")); // Nombre por defecto

        // Abre el diálogo de guardado y obtiene la selección del usuario
        int userSelection = fileChooser.showSaveDialog(null);

        // Verifica si el usuario seleccionó un archivo para guardar
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            System.out.println("Guardado cancelado.");
            return false; // Indica que el usuario canceló la operación
        }

        // Se obtiene el archivo seleccionado por el usuario
        File archivoDestino = fileChooser.getSelectedFile();

        // Se asegura de que el archivo tenga la extensión .pdf
        if (!archivoDestino.getName().toLowerCase().endsWith(".pdf")) {
            archivoDestino = new File(archivoDestino.getAbsolutePath() + ".pdf");
        }

        try {
            // Se crea el documento PDF en la ubicación especificada por el usuario
            PdfWriter writer = new PdfWriter(archivoDestino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agrega título y filtros aplicados al documento
            document.add(new Paragraph("Reporte de Reservas").setFontSize(20));
            document.add(new Paragraph("Filtros aplicados:").setFontSize(16));

            // Solo agrega información si el filtro correspondiente no está vacío
            agregarParrafoSiNoVacio(document, "Fecha de Inicio: ", fechaInicio);
            agregarParrafoSiNoVacio(document, "Fecha de Fin: ", fechaFin);
            agregarParrafoSiNoVacio(document, "Tipo de Mesa: ", tipoMesa);
            agregarParrafoSiNoVacio(document, "Ubicación: ", ubicacion);

            // Cierra el documento
            document.close();

            return true; // Indica que el PDF se generó correctamente
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            return false; // Indica que hubo un error al generar el PDF
        } catch (Exception e) { // Captura cualquier otra excepción
            System.err.println("Error inesperado: " + e.getMessage());
            return false; // Indica que hubo un error al generar el PDF
        }
    }

    // Método auxiliar para agregar un párrafo si el contenido no está vacío
    private void agregarParrafoSiNoVacio(Document document, String etiqueta, String contenido) {
        if (contenido != null && !contenido.trim().isEmpty()) {
            document.add(new Paragraph(etiqueta + contenido));
        }
    }
}
