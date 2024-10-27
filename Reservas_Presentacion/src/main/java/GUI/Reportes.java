/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BO.ReservaBO;
import DTOs.ReservaDTO;
import Fachada.ClienteFCD;
import Fachada.FiltrosFCD;
import Fachada.PdfGenerator;
import Interfaces.IReservaBO;
import interfacesFachada.IClienteFCD;
import interfacesFachada.IFiltrosFCD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * This class represents a GUI window for generating reports based on
 * reservations. It extends JFrame and provides functionalities to display,
 * filter, and generate reports in PDF format.
 *
 * @author Sebastian Murrieta
 */
public class Reportes extends javax.swing.JFrame {

    private IFiltrosFCD filtros;
    private IClienteFCD clienteFCD;
    private List<ReservaDTO> reservas;
    private IReservaBO reservaBO;

    /**
     * Creates a new instance of the Reportes class, initializing components and
     * fetching reservation data.
     */
    public Reportes() {
        initComponents();
        filtros = new FiltrosFCD(); // Initialize the filters facade
        clienteFCD = new ClienteFCD(); // Initialize the client facade
        this.reservaBO = new ReservaBO(); // Initialize the reservation business object

        // Fetch and initialize the reservas before updating the table
        obtenerReservas(); // This method fetches the reservations
        actualizarTablaReservas(); // Now you can update the table with the fetched data
    }

    /**
     * Displays an error message dialog with the given message.
     *
     * @param mensaje The error message to display.
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog with the given message.
     *
     * @param mensaje The success message to display.
     */
    private void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Validates the start and end dates for the reservation report.
     *
     * @return true if the dates are valid, false otherwise.
     */
    private boolean validarFechas() {
        if (fechaInicioDC.getDate().after(fechaFinDC.getDate())) {
            mostrarError("La fecha de inicio no puede ser posterior a la fecha de fin.");
            return false;
        }
        return true;
    }

    /**
     * Fetches the list of reservations from the database using the business
     * object.
     *
     * @return A list of Reservation Data Transfer Objects (ReservaDTO).
     */
    private List<ReservaDTO> obtenerReservas() {
        try {
            // Calls reservaBO to obtain the reservations from the database.
            this.reservas = reservaBO.obtenerReservas();
        } catch (Exception e) {
            mostrarError("Error al obtener las reservas: " + e.getMessage());
        }
        return reservas;
    }

    /**
     * Updates the table displaying the reservations with the current data.
     */
    private void actualizarTablaReservas() {
        String[] columnas = {"No.Mesa", "Fecha y hora", "Tamaño de mesa", "Lugar", "Cliente"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (ReservaDTO reserva : reservas) {
            model.addRow(new Object[]{
                reserva.getMesa().getCodigoMesa(),
                reserva.getFechaHoraReserva(),
                reserva.getMesa().getTipoMesa(),
                reserva.getMesa().getUbicacion(),
                reserva.getCliente().getNombre()
            });
        }
        tblMesas.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mostrarPDF = new Control.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        tituloPanel = new Control.PanelRound();
        Titulo = new javax.swing.JLabel();
        generarPDFBtn = new javax.swing.JButton();
        atrasBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ubicacionTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fechaInicioDC = new com.toedter.calendar.JDateChooser();
        fechaFinDC = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tipoMesaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 25, 25));
        setMaximumSize(new java.awt.Dimension(1290, 730));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarPDF.setBackground(new java.awt.Color(51, 51, 51));
        mostrarPDF.setRoundBottomLeft(50);
        mostrarPDF.setRoundBottomRight(50);
        mostrarPDF.setRoundTopLeft(50);
        mostrarPDF.setRoundTopRight(50);

        tblMesas.setBackground(new java.awt.Color(102, 102, 102));
        tblMesas.setForeground(new java.awt.Color(255, 255, 255));
        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.Mesa", "Tamaño de mesa", "Cliente", "Lugar", "Fehca de reservacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMesas);

        javax.swing.GroupLayout mostrarPDFLayout = new javax.swing.GroupLayout(mostrarPDF);
        mostrarPDF.setLayout(mostrarPDFLayout);
        mostrarPDFLayout.setHorizontalGroup(
            mostrarPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mostrarPDFLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        mostrarPDFLayout.setVerticalGroup(
            mostrarPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mostrarPDFLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(mostrarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 6, 700, 660));

        tituloPanel.setBackground(new java.awt.Color(102, 102, 102));
        tituloPanel.setRoundBottomLeft(50);
        tituloPanel.setRoundBottomRight(50);
        tituloPanel.setRoundTopLeft(50);
        tituloPanel.setRoundTopRight(50);

        Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Titulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Generacion de Reportes");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(Titulo)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Titulo)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        generarPDFBtn.setBackground(new java.awt.Color(102, 102, 102));
        generarPDFBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        generarPDFBtn.setForeground(new java.awt.Color(255, 255, 255));
        generarPDFBtn.setText("Generar PDF");
        generarPDFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarPDFBtnActionPerformed(evt);
            }
        });
        getContentPane().add(generarPDFBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 591, 180, 60));

        atrasBtn.setBackground(new java.awt.Color(102, 102, 102));
        atrasBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        atrasBtn.setForeground(new java.awt.Color(255, 255, 255));
        atrasBtn.setText("Cancelar");
        atrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBtnActionPerformed(evt);
            }
        });
        getContentPane().add(atrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 523, 134, 50));

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hasta el");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        ubicacionTxt.setBackground(new java.awt.Color(51, 51, 51));
        ubicacionTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(ubicacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 220, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reporte del");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        fechaInicioDC.setBackground(new java.awt.Color(51, 51, 51));
        fechaInicioDC.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel1.add(fechaInicioDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, 40));

        fechaFinDC.setBackground(new java.awt.Color(51, 51, 51));
        fechaFinDC.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel1.add(fechaFinDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 130, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de mesa");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ubicacion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 30));

        tipoMesaTxt.setBackground(new java.awt.Color(51, 51, 51));
        tipoMesaTxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tipoMesaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 220, 40));

        buscarBtn.setBackground(new java.awt.Color(102, 102, 102));
        buscarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buscarBtn.setForeground(new java.awt.Color(255, 255, 255));
        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBtnActionPerformed
        new Admistrador().setVisible(true);
        dispose();

    }//GEN-LAST:event_atrasBtnActionPerformed
    /**
     * Handles the action of generating the PDF report when the button is
     * clicked. It validates the dates and generates the report if valid.
     *
     * @param evt The action event triggered by clicking the button.
     */
    private void generarPDFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarPDFBtnActionPerformed
        try {
            // Validar fechas y campos obligatorios
            if (!validarFechas()) {
                return;
            }

            // Formatear fechas
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = dateFormat.format(fechaInicioDC.getDate());
            String fechaFin = dateFormat.format(fechaFinDC.getDate());

            // Obtener valores de campos de texto
            String tipoMesa = tipoMesaTxt.getText().trim();
            String ubicacion = ubicacionTxt.getText().trim();

            // Obtener reservas filtradas
            List<ReservaDTO> reservasFiltradas = obtenerReservas();

            // Llamar a la clase PdfGenerator para crear el PDF
            PdfGenerator pdfGenerator = new PdfGenerator();
            boolean exito = pdfGenerator.generarPDFDesdeFormulario(fechaInicio, fechaFin, tipoMesa, ubicacion, reservasFiltradas);

            // Mostrar mensaje según el resultado
            if (exito) {
                mostrarExito("Reporte generado exitosamente.");
            } else {
                mostrarError("Error al generar el reporte.");
            }
        } catch (Exception e) {
            mostrarError("Error inesperado: " + e.getMessage());
        }

    }//GEN-LAST:event_generarPDFBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        try {
            // Obtener los filtros del formulario
            String tipoMesa = tipoMesaTxt.getText().trim();
            String ubicacion = ubicacionTxt.getText().trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = dateFormat.format(fechaInicioDC.getDate());
            String fechaFin = dateFormat.format(fechaFinDC.getDate());

            // Filtrar las reservas usando la clase FiltrosFCD y el nuevo método
            FiltrosFCD filtros = new FiltrosFCD();
            List<ReservaDTO> reservasFiltradas = filtros.filtrarReservasPorMesaUbicacionFecha(tipoMesa, ubicacion, fechaInicio, fechaFin);

            // Actualizar la tabla con las reservas filtradas
            reservas = reservasFiltradas;
            actualizarTablaReservas();
        } catch (Exception e) {
            mostrarError("Error al filtrar las reservas: " + e.getMessage());
        }

    }//GEN-LAST:event_buscarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton atrasBtn;
    private javax.swing.JButton buscarBtn;
    private com.toedter.calendar.JDateChooser fechaFinDC;
    private com.toedter.calendar.JDateChooser fechaInicioDC;
    private javax.swing.JButton generarPDFBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Control.PanelRound mostrarPDF;
    private javax.swing.JTable tblMesas;
    private javax.swing.JTextField tipoMesaTxt;
    private Control.PanelRound tituloPanel;
    private javax.swing.JTextField ubicacionTxt;
    // End of variables declaration//GEN-END:variables
}
