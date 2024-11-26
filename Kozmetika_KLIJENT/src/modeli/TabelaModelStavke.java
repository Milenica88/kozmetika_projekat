/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Porudzbina;
import domen.StavkaPorudzbine;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kontroler.KlijentKontroler;

/**
 *
 * @author Milena
 */
public class TabelaModelStavke extends AbstractTableModel {

    private ArrayList<StavkaPorudzbine> lista;
    private String[] kolone = {"Rb", "Proizvod", "Kolicina", "Cena"};
    private int rb = 0;

    public TabelaModelStavke() {
        lista = new ArrayList<>();
    }

    public TabelaModelStavke(Porudzbina p) {
        try {
            lista = KlijentKontroler.getInstance().getAllStavkaPorudzbine(p);
        } catch (Exception ex) {
            Logger.getLogger(TabelaModelStavke.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaPorudzbine sp = lista.get(row);

        switch (column) {
            case 0:
                return sp.getRbStavke();
            case 1:
                return sp.getProizvod().getNazivProizvoda();
            case 2:
                return sp.getKolicinaStavke();
            case 3:
                return sp.getCenaStavke() + "din";

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaPorudzbine sp) {

        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            if (sp.getProizvod().getProizvodID().equals(stavkaPorudzbine.getProizvod().getProizvodID())) {
                stavkaPorudzbine.setCenaStavke(stavkaPorudzbine.getCenaStavke() + sp.getCenaStavke());
                stavkaPorudzbine.setKolicinaStavke(stavkaPorudzbine.getKolicinaStavke() + sp.getKolicinaStavke());
                fireTableDataChanged();
                return;
            }
        }

        rb = lista.size();
        sp.setRbStavke(++rb);
        lista.add(sp);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            stavkaPorudzbine.setRbStavke(++rb);
        }

        fireTableDataChanged();
    }

    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;

        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            ukupnaCena += stavkaPorudzbine.getCenaStavke();
        }

        return ukupnaCena;
    }

    public ArrayList<StavkaPorudzbine> getLista() {
        return lista;
    }
}
