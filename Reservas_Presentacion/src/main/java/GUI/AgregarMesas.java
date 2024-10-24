
package GUI;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
public class AgregarMesas extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public AgregarMesas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mesasTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lugarMesaCB = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numeroMesaTxt = new javax.swing.JTextField();
        agregarMesaPn = new Control.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        regresarBtn = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();
        tamañoMesaCB1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mesasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.Mesa", "Tamaño de mesa", "Lugar", "Codigo de mesa"
            }
        ));
        jScrollPane1.setViewportView(mesasTabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 29, 527, 565));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tamaño de mesa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        lugarMesaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(lugarMesaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 300, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lugar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Numero de mesa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        numeroMesaTxt.setBackground(new java.awt.Color(102, 102, 102));
        numeroMesaTxt.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(numeroMesaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 300, 40));

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
                .addContainerGap(204, Short.MAX_VALUE))
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
        getContentPane().add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 140, 50));

        agregarBtn.setBackground(new java.awt.Color(102, 102, 102));
        agregarBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        agregarBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 140, 50));

        tamañoMesaCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(tamañoMesaCB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 300, 40));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private Control.PanelRound agregarMesaPn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lugarMesaCB;
    private javax.swing.JTable mesasTabla;
    private javax.swing.JTextField numeroMesaTxt;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JComboBox<String> tamañoMesaCB1;
    // End of variables declaration//GEN-END:variables
}
