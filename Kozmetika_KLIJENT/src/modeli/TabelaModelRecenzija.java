/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Recenzija;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kontroler.KlijentKontroler;

/**
 *
 * @author Milena
 */
public class TabelaModelRecenzija extends AbstractTableModel implements Runnable {

    private ArrayList<Recenzija> lista;
    private String[] kolone = {"Proizvod", "Kupac", "Ocena"};
    private String parametar = "";

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public TabelaModelRecenzija() {
        try {
            lista = KlijentKontroler.getInstance().getAllRecenzija();
        } catch (Exception ex) {
            Logger.getLogger(TabelaModelRecenzija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TabelaModelRecenzija(ArrayList<Recenzija> statistika) {
        lista = statistika;
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
        Recenzija s = lista.get(row);

        switch (column) {
            case 0:
                return s.getProizvod().getNazivProizvoda(); // Display product name
            case 1:
                return s.getKupac().getImeKupca() + " " + s.getKupac().getPrezimeKupca(); // Display customer full name
            case 2:
                return s.getOcena(); // Display rating

            default:
                return null;
        }
    }

    public Recenzija getSelectedStatistika(int row) {
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
            Logger.getLogger(TabelaModelRecenzija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public void refreshTable() {
        try {
            lista = KlijentKontroler.getInstance().getAllRecenzija();
            if (!parametar.equals("")) {
                ArrayList<Recenzija> novaLista = new ArrayList<>();
                for (Recenzija s : lista) {
                    if (s.getProizvod().getNazivProizvoda().toLowerCase().contains(parametar.toLowerCase())
                            || (s.getKupac().getImeKupca() + " " + s.getKupac().getPrezimeKupca()).toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
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
