
package GUI;

import BO.MesaBO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Fachada.MesaFCD;
import Interfaces.IMesaBO;
import interfacesFachada.IMesaFCD;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
public class AgregarMesas extends javax.swing.JFrame {

    IMesaBO mesaBO;
    IMesaFCD mesaFCD;
    
    /**
     * Creates new form NewJFrame
     */
    public AgregarMesas() {
        initComponents();
        iniciarDependencias();
        cargarCantidadTipos();
        configuracionInicial();
    }

    /**
     * 
     */
    private void configuracionInicial(){
        this.setLocationRelativeTo(this);
        this.setSize(1200, 720);
        this.setBackground(Color.BLACK);
    }
    
    private void iniciarDependencias(){
        this.mesaBO = new MesaBO();
        this.mesaFCD = new MesaFCD();
    }
    
    /**
     * 
     */
    private void cargarCantidadTipos(){
        try{
           //recuperamos el numero de la base de datos. 
           int terraza = mesaBO.cantidadMesasPorUbicacion("TERRAZA");
           int ventana = mesaBO.cantidadMesasPorUbicacion("VENTANA");
           int general = mesaBO.cantidadMesasPorUbicacion("GENERAL");
           
           // se los asignamos a sus respectivos TextFields
           this.txfTerraza.setText(String.valueOf(terraza));
           this.txfVentana.setText(String.valueOf(ventana));
           this.txfGeneral.setText(String.valueOf(general));
           
        }
        catch(BOException be){
            JOptionPane.showMessageDialog(this, be.getMessage());
        }
    }
    
    private void limpiarEntradas(){
        this.txfNumMesas.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txfNumMesas = new javax.swing.JTextField();
        agregarMesaPn = new Control.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();
        cbxTamaño = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxUbicacion = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        timePicker1 = new com.raven.swing.TimePicker();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txfGeneral = new javax.swing.JTextField();
        txfTerraza = new javax.swing.JTextField();
        txfVentana = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ubicacion:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        txfNumMesas.setBackground(new java.awt.Color(102, 102, 102));
        txfNumMesas.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txfNumMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 300, 40));

        agregarMesaPn.setBackground(new java.awt.Color(51, 51, 51));
        agregarMesaPn.setCursorHandEnabled(true);
        agregarMesaPn.setMinimumSize(new java.awt.Dimension(320, 90));
        agregarMesaPn.setRoundBottomLeft(50);
        agregarMesaPn.setRoundBottomRight(50);
        agregarMesaPn.setRoundTopLeft(50);
        agregarMesaPn.setRoundTopRight(50);
        agregarMesaPn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMesaPnMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Mesas");

        javax.swing.GroupLayout agregarMesaPnLayout = new javax.swing.GroupLayout(agregarMesaPn);
        agregarMesaPn.setLayout(agregarMesaPnLayout);
        agregarMesaPnLayout.setHorizontalGroup(
            agregarMesaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarMesaPnLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        agregarMesaPnLayout.setVerticalGroup(
            agregarMesaPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarMesaPnLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(agregarMesaPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 590, -1));

        regresarBtn.setBackground(new java.awt.Color(102, 102, 102));
        regresarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        regresarBtn.setForeground(new java.awt.Color(255, 255, 255));
        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 140, 50));

        agregarBtn.setBackground(new java.awt.Color(102, 102, 102));
        agregarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        agregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 140, 50));

        cbxTamaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PEQUEÑA", "MEDIANA", "GRANDE" }));
        getContentPane().add(cbxTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 300, 40));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 20, 480));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horario restaurante");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tamaño de mesa:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        cbxUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERRAZA", "VENTANA", "GENERAL" }));
        getContentPane().add(cbxUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 300, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("General:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 610, -1, -1));
        getContentPane().add(timePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, 290));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 400, 10));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Numero de mesas:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Numero de mesas por ubicacion");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Terraza:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 510, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ventana:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 560, -1, -1));

        txfGeneral.setEditable(false);
        getContentPane().add(txfGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 110, 30));

        txfTerraza.setEditable(false);
        getContentPane().add(txfTerraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 110, 30));

        txfVentana.setEditable(false);
        getContentPane().add(txfVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMesaPnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMesaPnMouseClicked
        new AgregarMesas().setVisible(true);
        dispose();
    }//GEN-LAST:event_agregarMesaPnMouseClicked

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        new Admistrador().setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        try{
            
            //recolectamos datos
            int numero = Integer.parseInt(this.txfNumMesas.getText());
            String tamaño = String.valueOf(this.cbxTamaño.getSelectedItem());
            String ubicacion = String.valueOf(this.cbxUbicacion.
                    getSelectedItem());

            System.out.println(numero);
            System.out.println(tamaño);
            System.out.println(ubicacion);

            // lo pasamos a la fachada
            mesaFCD.agregarMesas(numero, tamaño, ubicacion);

            //actualizamos el contador 
            cargarCantidadTipos();

            //limpio las entradas
            limpiarEntradas();
        
        }
        catch(FacadeException fe){
            JOptionPane.showMessageDialog(this, fe.getMessage());
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Introduzca numeros validos");
        }
    }//GEN-LAST:event_agregarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private Control.PanelRound agregarMesaPn;
    private javax.swing.JComboBox<String> cbxTamaño;
    private javax.swing.JComboBox<String> cbxUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton regresarBtn;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JTextField txfGeneral;
    private javax.swing.JTextField txfNumMesas;
    private javax.swing.JTextField txfTerraza;
    private javax.swing.JTextField txfVentana;
    // End of variables declaration//GEN-END:variables
}
