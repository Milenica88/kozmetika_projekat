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
public class TipProizvoda extends OpstiDomenskiObjekat {
    
     private Long tipProizvodaID;
    private String nazivTipaProizvoda;

    @Override
    public String toString() {
        return nazivTipaProizvoda;
    }

    public TipProizvoda(Long tipProizvodaID, String nazivTipaProizvoda) {
        this.tipProizvodaID = tipProizvodaID;
        this.nazivTipaProizvoda = nazivTipaProizvoda;
    }

    public TipProizvoda() {
    }
    
    @Override
    public String nazivTabele() {
        return " tipProizvoda ";
    }

    @Override
    public String alijas() {
        return " tp ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            TipProizvoda tp = new TipProizvoda(rs.getLong("TipProizvodaID"),
                    rs.getString("NazivTipaProizvoda"));

            lista.add(tp);
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
        return " TipProizvodaID = " + tipProizvodaID;
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

    public Long getTipProizvodaID() {
        return tipProizvodaID;
    }

    public void setTipProizvodaID(Long tipProizvodaID) {
        this.tipProizvodaID = tipProizvodaID;
    }

    public String getNazivTipaProizvoda() {
        return nazivTipaProizvoda;
    }

    public void setNazivTipaProizvoda(String nazivTipaProizvoda) {
        this.nazivTipaProizvoda = nazivTipaProizvoda;
    }
}
