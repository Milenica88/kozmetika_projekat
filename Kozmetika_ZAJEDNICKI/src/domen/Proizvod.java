/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Milena
 */
public class Proizvod extends OpstiDomenskiObjekat{
    
    private Long proizvodID;
    private String nazivProizvoda;
    private String opisProizvoda;
    private double cenaPoJedinici;
    private TipProizvoda tipProizvoda;

    @Override
    public String toString() {
        return nazivProizvoda + " (Tip proizvoda: " + tipProizvoda 
                + ", Cena po jedinici: " + cenaPoJedinici + "din)";
    }

    public Proizvod(Long proizvodID, String nazivProizvoda, String opisProizvoda, double cenaPoJedinici, TipProizvoda tipProizvoda) {
        this.proizvodID = proizvodID;
        this.nazivProizvoda = nazivProizvoda;
        this.opisProizvoda = opisProizvoda;
        this.cenaPoJedinici = cenaPoJedinici;
        this.tipProizvoda = tipProizvoda;
    }

    public Proizvod() {
    }

    @Override
    public String nazivTabele() {
        return " proizvod ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return " JOIN TIPPROIZVODA TP ON (TP.TIPPROIZVODAID = P.TIPPROIZVODAID) ";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            
            TipProizvoda tp = new TipProizvoda(rs.getLong("TipProizvodaID"),
                    rs.getString("NazivTipaProizvoda"));
            
            Proizvod p = new Proizvod(rs.getLong("proizvodID"), 
                    rs.getString("nazivProizvoda"), rs.getString("opisProizvoda"), 
                    rs.getDouble("cenaPoJedinici"), tp);

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " proizvodID = " + proizvodID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(Long proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getOpisProizvoda() {
        return opisProizvoda;
    }

    public void setOpisProizvoda(String opisProizvoda) {
        this.opisProizvoda = opisProizvoda;
    }

    public double getCenaPoJedinici() {
        return cenaPoJedinici;
    }

    public void setCenaPoJedinici(double cenaPoJedinici) {
        this.cenaPoJedinici = cenaPoJedinici;
    }

    public TipProizvoda getTipProizvoda() {
        return tipProizvoda;
    }

    public void setTipProizvoda(TipProizvoda tipProizvoda) {
        this.tipProizvoda = tipProizvoda;
    }
}
