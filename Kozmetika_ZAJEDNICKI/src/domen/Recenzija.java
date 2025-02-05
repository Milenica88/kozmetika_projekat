/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Milena
 */
public class Recenzija extends OpstiDomenskiObjekat {

    private Long recenzijaID;
    private Proizvod proizvod;
    private Kupac kupac;
    private int ocena;

    @Override
    public String toString() {
        return "Recenzija ID: " + recenzijaID + ", Proizvod: " + proizvod
                + ", Kupac: " + kupac + ", Ocena: " + ocena;
    }

    public Recenzija(Long recenzijaID, Proizvod proizvod, Kupac kupac, int ocena) {
        this.recenzijaID = recenzijaID;
        this.proizvod = proizvod;
        this.kupac = kupac;
        this.ocena = ocena;
    }

    public Recenzija() {
    }

    @Override
    public String nazivTabele() {
        return " recenzija ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN proizvod p ON (r.proizvodID = p.proizvodID) "
                + " JOIN kupac k ON (r.kupacID = k.kupacID) ";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Proizvod p = new Proizvod(rs.getLong("proizvodID"),
                    rs.getString("nazivProizvoda"),
                    rs.getString("opisProizvoda"),
                    rs.getDouble("cenaPoJedinici"), null);

            Kupac k = new Kupac(rs.getLong("kupacID"),
                    rs.getString("imeKupca"),
                    rs.getString("prezimeKupca"),
                    rs.getString("email"),
                    rs.getString("telefon"));

            Recenzija r = new Recenzija(rs.getLong("recenzijaID"), p, k, rs.getInt("ocena"));
            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (proizvodID, kupacID, ocena) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " recenzijaID = " + recenzijaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return proizvod.getProizvodID() + ", "
                + kupac.getKupacID() + ", " + ocena;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getRecenzijaID() {
        return recenzijaID;
    }

    public void setRecenzijaID(Long recenzijaID) {
        this.recenzijaID = recenzijaID;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

}
