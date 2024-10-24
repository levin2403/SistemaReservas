package GUI;

import BO.MesaBO;
import BO.ReservaBO;
import DTO.ClienteDTO;
import DTO.MesaDTO;
import DTO.ReservaDTO;
import java.awt.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        confirmarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        costoTxt = new javax.swing.JTextField();
        nombreClienteCB = new javax.swing.JComboBox<>();
        panelRound1 = new Control.PanelRound();
        Titulo = new javax.swing.JLabel();
        panelRound2 = new Control.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        mesasTabla = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        timePicker1 = new com.raven.swing.TimePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(22, 22, 22));
        Fondo.setForeground(new java.awt.Color(51, 51, 51));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mesas para la reservacion");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Costo:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cliente:");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Numero de personas");
        Fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        costoTxt.setEditable(false);
        costoTxt.setBackground(new java.awt.Color(102, 102, 102));
        costoTxt.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.add(costoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 300, 40));

        nombreClienteCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Fondo.add(nombreClienteCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 300, 40));

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
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(73, 73, 73))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Fondo.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 380, 60));

        panelRound2.setBackground(new java.awt.Color(51, 51, 51));
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

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

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        Fondo.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 520, 560));
        Fondo.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 300, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        Fondo.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 300, 40));
        Fondo.add(timePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, 330));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora de reservación");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de reservación");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBtnActionPerformed
//        try {
//            // Crear la reserva con los datos del formulario
//            ReservaDTO reserva = new ReservaDTO();
//
//            // Obtener la fecha y hora seleccionadas
//            String fechaStr = fechaReservaCB.getSelectedItem().toString();
//            String horaStr = horaReservaCB.getSelectedItem().toString();
//            LocalDateTime fechaHora = parsearFechaHora(fechaStr, horaStr);
//            reserva.setFechaHoraReserva(fechaHora);
//
//            // Obtener el número de personas
//            int numeroPersonas = Integer.parseInt(numeroPersonasTxt.getText());
//            reserva.setNumeroPersonas(numeroPersonas);
//
//            // Obtener el cliente seleccionado
//            ClienteDTO cliente = (ClienteDTO) nombreClienteCB.getSelectedItem();
//            reserva.setCliente(cliente);
//
//            // Obtener la mesa seleccionada
//            int filaSeleccionada = mesasTabla.getSelectedRow();
//            if (filaSeleccionada == -1) {
//                JOptionPane.showMessageDialog(this,
//                        "Por favor, seleccione una mesa",
//                        "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            MesaDTO mesa = obtenerMesaSeleccionada(filaSeleccionada);
//            reserva.setMesa(mesa);
//
//            // Agregar la reserva
//            ReservaBO reservaBO = new ReservaBO();
//            reservaBO.agregarReserva(reserva);
//
//            // Actualizar la tabla de mesas
//            cargarDatosMesas();
//
//            // Mostrar mensaje de éxito
//            JOptionPane.showMessageDialog(this,
//                    "Reserva realizada con éxito",
//                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
//
//            // Limpiar formulario
//            limpiarFormulario();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this,
//                    "Error al realizar la reserva: " + e.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_confirmarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        new Admistrador().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed
//    private void cargarDatosMesas(JTable tabla) {
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
//    }

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
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mesasTabla;
    private javax.swing.JComboBox<String> nombreClienteCB;
    private Control.PanelRound panelRound1;
    private Control.PanelRound panelRound2;
    private com.raven.swing.TimePicker timePicker1;
    // End of variables declaration//GEN-END:variables
}
