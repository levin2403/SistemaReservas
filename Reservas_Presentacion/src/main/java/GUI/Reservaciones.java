package GUI;

import BO.MesaBO;
import DTO.MesaDTO;
import java.awt.List;
import java.time.LocalDate;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Clase para la ventana principal
 */
public class Reservaciones extends javax.swing.JFrame {

    public Reservaciones() {
        initComponents();
//        cargarDatosMesas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesasTabla = new javax.swing.JTable();
        confirmarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        fechaReservaCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroPersonasTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        horaReservaCB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        estadoTxt = new javax.swing.JTextField();
        costoTxt = new javax.swing.JTextField();
        nombreClienteCB = new javax.swing.JComboBox<>();
        panelRound1 = new Control.PanelRound();
        Titulo = new javax.swing.JLabel();
        panelRound2 = new Control.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(22, 22, 22));
        Fondo.setForeground(new java.awt.Color(51, 51, 51));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mesasTabla.setBackground(new java.awt.Color(102, 102, 102));
        mesasTabla.setForeground(new java.awt.Color(255, 255, 255));
        mesasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.Mesa", "Tamaño de mesa", "Disponibilidad", "Lugar"
            }
        ));
        jScrollPane1.setViewportView(mesasTabla);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, -1, 500));

        confirmarBtn.setBackground(new java.awt.Color(102, 102, 102));
        confirmarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confirmarBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmarBtn.setText("Confirmar");
        confirmarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBtnActionPerformed(evt);
            }
        });
        Fondo.add(confirmarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 140, 50));

        cancelarBtn.setBackground(new java.awt.Color(102, 102, 102));
        cancelarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cancelarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });
        Fondo.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, 140, 50));

        fechaReservaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Fondo.add(fechaReservaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 300, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de reservación");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Costo");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        numeroPersonasTxt.setBackground(new java.awt.Color(102, 102, 102));
        numeroPersonasTxt.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(numeroPersonasTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 300, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora de reservación");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        horaReservaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Fondo.add(horaReservaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 300, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Disponibilidad");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre del cliente");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Numero de personas");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        estadoTxt.setBackground(new java.awt.Color(102, 102, 102));
        estadoTxt.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(estadoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 300, 40));

        costoTxt.setBackground(new java.awt.Color(102, 102, 102));
        costoTxt.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(costoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 300, 40));

        nombreClienteCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Fondo.add(nombreClienteCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 300, 40));

        panelRound1.setBackground(new java.awt.Color(51, 51, 51));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        Titulo.setBackground(new java.awt.Color(255, 255, 255));
        Titulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Reservaciones");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(71, 71, 71))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Titulo)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 380, -1));

        panelRound2.setBackground(new java.awt.Color(51, 51, 51));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        Fondo.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 520, 560));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtnActionPerformed
     
        LocalDate fecha = (LocalDate)fechaReservaCB.getSelectedItem();
        
        String nombre = numeroPersonasTxt.getText();
        
        

    }//GEN-LAST:event_confirmarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed
    private void cargarDatosMesas(JTable tabla) {
//        // Crear el modelo de tabla personalizado
//        DefaultTableModel modelo = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false; // Hacer la tabla no editable
//            }
//        };
//
//        // Definir las columnas
//        modelo.addColumn("No. Mesa");
//        modelo.addColumn("Tamaño de mesa");
//        modelo.addColumn("Disponibilidad");
//        modelo.addColumn("Lugar");
//
//        // Obtener los datos de las mesas
//        MesaBO mesaBO = new MesaBO();
//        List<MesaDTO> mesas = mesaBO.consultarMesas();
//
//        // Agregar los datos al modelo
//        for (MesaDTO mesa : mesas) {
//            Object[] fila = new Object[4];
//            fila[0] = mesa.getCodigoMesa();
//            fila[1] = mesa.getCapacidadMinima() + " - " + mesa.getCapacidadMaxima() + " personas";
//            // Aquí puedes implementar la lógica para determinar la disponibilidad
//            fila[2] = determinarDisponibilidad(mesa);
//            fila[3] = mesa.getUbicacion();
//            modelo.addRow(fila);
//        }
//
//        // Aplicar el modelo a la tabla
//        mesasTabla.setModel(modelo);
//
//        // Configurar el aspecto de la tabla
//        configurarTabla();
    }

    private String determinarDisponibilidad(MesaDTO mesa) {
        // Implementa aquí la lógica para determinar si la mesa está disponible
        // basándote en las reservas existentes
        if (mesa.getReservas() == null || mesa.getReservas().isEmpty()) {
            return "Disponible";
        }
        // Aquí puedes agregar más lógica para verificar las reservas actuales
        return "No disponible";
    }

    private void configurarTabla() {
        // Configurar el aspecto de la tabla
        mesasTabla.setRowHeight(25);
        mesasTabla.getTableHeader().setReorderingAllowed(false);

        // Configurar el renderizador para centrar el texto
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < mesasTabla.getColumnCount(); i++) {
            mesasTabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Ajustar el ancho de las columnas
        mesasTabla.getColumnModel().getColumn(0).setPreferredWidth(80);  // No. Mesa
        mesasTabla.getColumnModel().getColumn(1).setPreferredWidth(120); // Tamaño
        mesasTabla.getColumnModel().getColumn(2).setPreferredWidth(100); // Disponibilidad
        mesasTabla.getColumnModel().getColumn(3).setPreferredWidth(150); // Lugar
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JButton confirmarBtn;
    private javax.swing.JTextField costoTxt;
    private javax.swing.JTextField estadoTxt;
    private javax.swing.JComboBox<String> fechaReservaCB;
    private javax.swing.JComboBox<String> horaReservaCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mesasTabla;
    private javax.swing.JComboBox<String> nombreClienteCB;
    private javax.swing.JTextField numeroPersonasTxt;
    private Control.PanelRound panelRound1;
    private Control.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
