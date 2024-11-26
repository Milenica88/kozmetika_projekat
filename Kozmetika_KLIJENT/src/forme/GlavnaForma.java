/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Administrator;
import domen.Kupac;
import domen.Porudzbina;
import domen.Proizvod;
import domen.StavkaPorudzbine;
import formeKupca.FrmNoviKupac;
import formeKupca.FrmPretragaKupca;
import formePorudzbine.FrmPretragaPorudzbine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.KlijentKontroler;
import modeli.TabelaModelKupci;
import modeli.TabelaModelStavke;
import session.Session;

/**
 *
 * @author Milena
 */
public class GlavnaForma extends javax.swing.JFrame {

    Administrator ulogovani;
    double ukupnaCena;

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        this.ulogovani = Session.getInstance().getUlogovani();
        txtUlogovani.setText(ulogovani.toString());
        setTitle("Klijentska forma");
        popuniKupce();
        popuniProizvode();
        txtUkupnaCena.setEditable(false);
        txtCenaStavke.setEditable(false);
        tblStavke.setModel(new TabelaModelStavke());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUlogovani = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbKupci = new javax.swing.JComboBox();
        txtDatumIsporuke = new javax.swing.JTextField();
        txtUkupnaCena = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbProizvodi = new javax.swing.JComboBox();
        txtKolicina = new javax.swing.JTextField();
        txtCenaStavke = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNoviKupac = new javax.swing.JMenuItem();
        miPretragaKupca = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miPretragaPorudzbine = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ulogovani admin:");

        txtUlogovani.setBackground(new java.awt.Color(240, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos porudžbine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(81, 57, 31))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(702, 449));

        jLabel2.setText("Kupac:");

        jLabel3.setText("Datum isporuke:");

        jLabel4.setText("Ukupna cena:");

        cbKupci.setBackground(new java.awt.Color(204, 204, 204));
        cbKupci.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumIsporuke.setBackground(new java.awt.Color(240, 255, 255));

        txtUkupnaCena.setBackground(new java.awt.Color(240, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 176, 176));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos stavki porudžbine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(81, 57, 31))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(495, 295));

        jLabel5.setText("Proizvod:");

        jLabel6.setText("Količina:");

        jLabel7.setText("Cena stavke (din):");

        cbProizvodi.setBackground(new java.awt.Color(204, 204, 204));
        cbProizvodi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProizvodi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProizvodiItemStateChanged(evt);
            }
        });

        txtKolicina.setBackground(new java.awt.Color(240, 255, 255));
        txtKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKolicinaKeyReleased(evt);
            }
        });

        txtCenaStavke.setBackground(new java.awt.Color(240, 255, 255));

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(460, 410));

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProizvodi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKolicina)
                            .addComponent(txtCenaStavke)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnDodajStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiStavku)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbProizvodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCenaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(cbKupci, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSacuvaj)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbKupci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumIsporuke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnSacuvaj))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jMenu1.setText("Kupac");

        miNoviKupac.setText("Novi kupac");
        miNoviKupac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviKupacActionPerformed(evt);
            }
        });
        jMenu1.add(miNoviKupac);

        miPretragaKupca.setText("Pretraga kupca");
        miPretragaKupca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKupcaActionPerformed(evt);
            }
        });
        jMenu1.add(miPretragaKupca);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Porudžbina");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        miPretragaPorudzbine.setText("Pretraga porudžbine");
        miPretragaPorudzbine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaPorudzbineActionPerformed(evt);
            }
        });
        jMenu2.add(miPretragaPorudzbine);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Odjava");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        miOdjava.setText("Odjavi sa sistema");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu3.add(miOdjava);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miPretragaKupcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKupcaActionPerformed
        new FrmPretragaKupca(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKupcaActionPerformed

    private void miNoviKupacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviKupacActionPerformed
        new FrmNoviKupac(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviKupacActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

    }//GEN-LAST:event_jMenu3ActionPerformed

    private void miPretragaPorudzbineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaPorudzbineActionPerformed
        new FrmPretragaPorudzbine(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaPorudzbineActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new LoginForma().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_miOdjavaActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        if (txtKolicina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti kolicinu!");
            return;
        }

        Proizvod p = (Proizvod) cbProizvodi.getSelectedItem();
        int kolicina = Integer.parseInt(txtKolicina.getText());
        double cenaStavke = Double.parseDouble(txtCenaStavke.getText());

        StavkaPorudzbine sp = new StavkaPorudzbine(null, -1, kolicina, cenaStavke, p);

        TabelaModelStavke tm = (TabelaModelStavke) tblStavke.getModel();
        tm.dodajStavku(sp);

        ukupnaCena = tm.vratiUkupnuCenu();
        txtUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");

    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
            TabelaModelStavke tm = (TabelaModelStavke) tblStavke.getModel();
            tm.obrisiStavku(row);

            ukupnaCena = tm.vratiUkupnuCenu();
            txtUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");

        }

    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void txtKolicinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKolicinaKeyReleased
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {

            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }

            Proizvod p = (Proizvod) cbProizvodi.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());

            txtCenaStavke.setText(String.valueOf(p.getCenaPoJedinici() * kolicina));

        } else {

            txtKolicina.setText("");
            txtCenaStavke.setText("");

        }
    }//GEN-LAST:event_txtKolicinaKeyReleased

    private void cbProizvodiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProizvodiItemStateChanged
        if (cbProizvodi.getSelectedItem() != null) {
            if (txtKolicina.getText().isEmpty()) {
                txtCenaStavke.setText("");
                return;
            }

            Proizvod p = (Proizvod) cbProizvodi.getSelectedItem();
            int kolicina = Integer.parseInt(txtKolicina.getText());

            txtCenaStavke.setText(String.valueOf(p.getCenaPoJedinici() * kolicina));
        }
    }//GEN-LAST:event_cbProizvodiItemStateChanged

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {

            if (txtDatumIsporuke.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate popuniti datum isporuke!");
                return;
            }

            Kupac kupac = (Kupac) cbKupci.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumIsporuke = sdf.parse(txtDatumIsporuke.getText());
            TabelaModelStavke tm = (TabelaModelStavke) tblStavke.getModel();

            Porudzbina p = new Porudzbina(null, new Date(), datumIsporuke,
                    ukupnaCena, kupac, ulogovani, tm.getLista());

            KlijentKontroler.getInstance().addPorudzbina(p);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvana porudzbina!");

        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cbKupci;
    private javax.swing.JComboBox cbProizvodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miNoviKupac;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPretragaKupca;
    private javax.swing.JMenuItem miPretragaPorudzbine;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtCenaStavke;
    private javax.swing.JTextField txtDatumIsporuke;
    private javax.swing.JTextField txtKolicina;
    private javax.swing.JTextField txtUkupnaCena;
    private javax.swing.JTextField txtUlogovani;
    // End of variables declaration//GEN-END:variables

    private void popuniProizvode() {
        try {
            ArrayList<Proizvod> proizvodi = KlijentKontroler.getInstance().getAllProizvod();

            cbProizvodi.removeAllItems();

            for (Proizvod proizvod : proizvodi) {
                cbProizvodi.addItem(proizvod);
            }

        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniKupce() {
        try {
            ArrayList<Kupac> kupci = KlijentKontroler.getInstance().getAllKupac();

            cbKupci.removeAllItems();

            for (Kupac kupac : kupci) {
                cbKupci.addItem(kupac);
            }

        } catch (Exception ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void resetujFormu() {
        txtDatumIsporuke.setText("");
        txtUkupnaCena.setText("");
        tblStavke.setModel(new TabelaModelStavke());
        txtKolicina.setText("");
        txtCenaStavke.setText("");
    }
}
