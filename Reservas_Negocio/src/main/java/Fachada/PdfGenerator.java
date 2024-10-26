package Fachada;

import DTOs.ReservaDTO;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Sebastian Murrieta
 */
public class PdfGenerator {

    public boolean generarPDFDesdeFormulario(String fechaInicio, String fechaFin, String tipoMesa, String ubicacion, List<ReservaDTO> reservas) {
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

            // Formateador para fechas
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Agrega las reservas al documento
            document.add(new Paragraph("Reservaciones:").setFontSize(16));
            for (ReservaDTO reserva : reservas) {
                // Filtrar reservas directamente durante la adición al PDF
                if (filtrarReserva(reserva, fechaInicio, fechaFin, tipoMesa, ubicacion)) {
                    document.add(new Paragraph("Cliente: " + reserva.getCliente().getNombre()
                            + ", Fecha: " + reserva.getFechaHoraReserva().format(formatter)
                            + ", Número de Personas: " + reserva.getNumeroPersonas()
                            + ", Tipo de Mesa: " + reserva.getMesa().getTipoMesa()
                            + ", Ubicación: " + reserva.getMesa().getUbicacion()));
                }
            }
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

    // Método para filtrar reservas basadas en los criterios
    private boolean filtrarReserva(ReservaDTO reserva, String fechaInicio, String fechaFin, String tipoMesa, String ubicacion) {
        boolean fechaValida = true;
        boolean tipoMesaValido = true;
        boolean ubicacionValida = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime inicio = LocalDate.parse(fechaInicio, formatter).atStartOfDay();
        LocalDateTime fin = LocalDate.parse(fechaFin, formatter).atTime(23, 59);

        // Filtrar por fechas
        if (reserva.getFechaHoraReserva().isBefore(inicio) || reserva.getFechaHoraReserva().isAfter(fin)) {
            fechaValida = false;
        }

        // Filtrar por tipo de mesa
        if (!tipoMesa.isEmpty() && !reserva.getMesa().getTipoMesa().equalsIgnoreCase(tipoMesa)) {
            tipoMesaValido = false;
        }

        // Filtrar por ubicación
        if (!ubicacion.isEmpty() && !reserva.getMesa().getUbicacion().equalsIgnoreCase(ubicacion)) {
            ubicacionValida = false;
        }

        return fechaValida && tipoMesaValido && ubicacionValida;
    }
}
