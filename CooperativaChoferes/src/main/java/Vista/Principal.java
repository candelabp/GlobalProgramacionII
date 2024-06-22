
package Vista;

import Controlador.Controladora;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {
Controladora control = new Controladora();

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnRegistro = new javax.swing.JButton();
        BtnInfoSoc = new javax.swing.JButton();
        BtnMayorKm = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnInfoCole = new javax.swing.JButton();
        BtnCambio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 234, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("MENÚ");

        BtnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnRegistro.setText("Registrar viaje");
        BtnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistroActionPerformed(evt);
            }
        });

        BtnInfoSoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnInfoSoc.setText("Ver información sobre choferes");
        BtnInfoSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInfoSocActionPerformed(evt);
            }
        });

        BtnMayorKm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnMayorKm.setText("Ver vehiculo con mayor kilometraje");
        BtnMayorKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMayorKmActionPerformed(evt);
            }
        });

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnInfoCole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnInfoCole.setText("Ver información sobre colectivos ");
        BtnInfoCole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInfoColeActionPerformed(evt);
            }
        });

        BtnCambio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnCambio.setText("Realizar cambio de colectivo");
        BtnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCambioActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\cande\\Downloads\\Diseño sin título(1).png")); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnMayorKm, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInfoSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnInfoCole, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSalir)
                .addGap(274, 274, 274))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(BtnInfoSoc)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnInfoCole)
                        .addGap(106, 106, 106)
                        .addComponent(BtnCambio)
                        .addGap(55, 55, 55)
                        .addComponent(BtnMayorKm)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(BtnRegistro))
                        .addGap(84, 84, 84)))
                .addComponent(BtnSalir)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistroActionPerformed
        Registro registro = new Registro();
        registro.setVisible(true);
        registro.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnRegistroActionPerformed

    private void BtnInfoSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoSocActionPerformed
               Informacion info = new Informacion();
    info.setVisible(true);
    info.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnInfoSocActionPerformed

    private void BtnMayorKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMayorKmActionPerformed
JOptionPane.showMessageDialog(this,control.Mayorkm());        
    }//GEN-LAST:event_BtnMayorKmActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnInfoColeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoColeActionPerformed
        InfoColectivos infocole = new InfoColectivos();
        infocole.setVisible(true);
        infocole.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnInfoColeActionPerformed

    private void BtnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambioActionPerformed
        control.realizarCambio();
        JOptionPane.showMessageDialog(this,"Se realizó un intercambio de colectivo");
    }//GEN-LAST:event_BtnCambioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCambio;
    private javax.swing.JButton BtnInfoCole;
    private javax.swing.JButton BtnInfoSoc;
    private javax.swing.JButton BtnMayorKm;
    private javax.swing.JButton BtnRegistro;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
