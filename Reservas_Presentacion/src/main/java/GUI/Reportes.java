/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Fachada.PdfGenerator;
import java.text.SimpleDateFormat;

/**
 *
 * @author Sebastian Murrieta
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Confirmacion
     */
    public Reportes() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 25, 25));
        setMaximumSize(new java.awt.Dimension(1290, 730));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarPDF.setBackground(new java.awt.Color(255, 102, 102));
        mostrarPDF.setRoundBottomLeft(50);
        mostrarPDF.setRoundBottomRight(50);
        mostrarPDF.setRoundTopLeft(50);
        mostrarPDF.setRoundTopRight(50);

        javax.swing.GroupLayout mostrarPDFLayout = new javax.swing.GroupLayout(mostrarPDF);
        mostrarPDF.setLayout(mostrarPDFLayout);
        mostrarPDFLayout.setHorizontalGroup(
            mostrarPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        mostrarPDFLayout.setVerticalGroup(
            mostrarPDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloPanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(43, 43, 43))
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Titulo)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        generarPDFBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        generarPDFBtn.setText("Generar PDF");
        generarPDFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarPDFBtnActionPerformed(evt);
            }
        });
        getContentPane().add(generarPDFBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 591, 180, 60));

        atrasBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jPanel1.add(ubicacionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 220, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Reporte del");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        fechaInicioDC.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jPanel1.add(fechaInicioDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, 40));

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
        jPanel1.add(tipoMesaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 220, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBtnActionPerformed
        new Admistrador().setVisible(true);
        dispose();

    }//GEN-LAST:event_atrasBtnActionPerformed

    private void generarPDFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarPDFBtnActionPerformed
        // Validaciones
        if (fechaInicioDC.getDate() == null || fechaFinDC.getDate() == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione las fechas.");
            return;
        }

        // Obtener los valores de los campos
        String fechaInicio = new SimpleDateFormat("dd/MM/yyyy").format(fechaInicioDC.getDate());
        String fechaFin = new SimpleDateFormat("dd/MM/yyyy").format(fechaFinDC.getDate());
        String tipoMesa = tipoMesaTxt.getText().trim();
        String ubicacion = ubicacionTxt.getText().trim();

        // Crear instancia de PDF y generar el reporte
        PdfGenerator pdf = new PdfGenerator();

        // Generar el reporte aplicando filtros solo si se ingresaron valores
        if (pdf.generarPDFDesdeFormulario(fechaInicio, fechaFin, tipoMesa, ubicacion)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Reporte generado exitosamente.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar el reporte.");
        }
    }//GEN-LAST:event_generarPDFBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton atrasBtn;
    private com.toedter.calendar.JDateChooser fechaFinDC;
    private com.toedter.calendar.JDateChooser fechaInicioDC;
    private javax.swing.JButton generarPDFBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Control.PanelRound mostrarPDF;
    private javax.swing.JTextField tipoMesaTxt;
    private Control.PanelRound tituloPanel;
    private javax.swing.JTextField ubicacionTxt;
    // End of variables declaration//GEN-END:variables
}
