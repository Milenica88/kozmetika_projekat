/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import niti.ServerNit;

/**
 *
 * @author Milena
 */
public class ServerskaForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerskaForma
     */
    private ServerNit threadServer;

    public ServerskaForma() {
        initComponents();
        setLocationRelativeTo(null);
        lblServerStatus.setText("Server je ugasen!");
        btnPokreniServer.setEnabled(true);
        btnUgasiServer.setEnabled(false);
        setTitle("Serverska forma");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServerStatus = new javax.swing.JLabel();
        btnPokreniServer = new javax.swing.JButton();
        btnUgasiServer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miKonfiguracija = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServerStatus.setText("Server status");

        btnPokreniServer.setText("Pokreni server");
        btnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniServerActionPerformed(evt);
            }
        });

        btnUgasiServer.setText("Ugasi server");
        btnUgasiServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUgasiServerActionPerformed(evt);
            }
        });

        jMenu1.setText("Konfiguracija baze");

        miKonfiguracija.setText("Izmeni konfiguraciju");
        miKonfiguracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonfiguracijaActionPerformed(evt);
            }
        });
        jMenu1.add(miKonfiguracija);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUgasiServer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblServerStatus)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreniServer)
                    .addComponent(btnUgasiServer))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniServerActionPerformed
          if (threadServer == null || !threadServer.isAlive()) {
            threadServer = new ServerNit();
            threadServer.start();
            lblServerStatus.setText("Server je pokrenut");
            btnUgasiServer.setEnabled(true);
            btnPokreniServer.setEnabled(false);
        }
    }//GEN-LAST:event_btnPokreniServerActionPerformed

    private void miKonfiguracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonfiguracijaActionPerformed
        new FrmKonfiguracija(this, true).setVisible(true);
    }//GEN-LAST:event_miKonfiguracijaActionPerformed

    private void btnUgasiServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUgasiServerActionPerformed
           if (threadServer.getServerSocket() != null && threadServer.getServerSocket().isBound()) {
            try {
                threadServer.getServerSocket().close();
                JOptionPane.showMessageDialog(this, "Server je ugasen, gasenje programa...");
                this.dispose();
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUgasiServerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreniServer;
    private javax.swing.JButton btnUgasiServer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JMenuItem miKonfiguracija;
    // End of variables declaration//GEN-END:variables
}
