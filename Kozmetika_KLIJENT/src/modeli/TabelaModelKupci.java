/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Kupac;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kontroler.KlijentKontroler;

/**
 *
 * @author Milena
 */
public class TabelaModelKupci extends AbstractTableModel implements Runnable {
      private ArrayList<Kupac> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Email", "Telefon"};
    private String parametar = "";

    public TabelaModelKupci() {
        try {
            lista = KlijentKontroler.getInstance().getAllKupac();
        } catch (Exception ex) {
            Logger.getLogger(TabelaModelKupci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Kupac k = lista.get(row);

        switch (column) {
            case 0:
                return k.getKupacID();
            case 1:
                return k.getImeKupca();
            case 2:
                return k.getPrezimeKupca();
            case 3:
                return k.getEmail();
            case 4:
                return k.getTelefon();

            default:
                return null;
        }
    }

    public Kupac getSelectedKlijent(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TabelaModelKupci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentKontroler.getInstance().getAllKupac();
            if (!parametar.equals("")) {
                ArrayList<Kupac> novaLista = new ArrayList<>();
                for (Kupac k : lista) {
                    if (k.getImeKupca().toLowerCase().contains(parametar.toLowerCase())
                            || k.getPrezimeKupca().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
