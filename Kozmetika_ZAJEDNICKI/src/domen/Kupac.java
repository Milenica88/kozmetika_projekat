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
public class Kupac extends OpstiDomenskiObjekat {
    
    private Long kupacID;
    private String imeKupca;
    private String prezimeKupca;
    private String email;
    private String telefon;

    @Override
    public String toString() {
        return imeKupca + " " + prezimeKupca;
    }

    public Kupac(Long kupacID, String imeKupca, String prezimeKupca, String email, String telefon) {
        this.kupacID = kupacID;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.email = email;
        this.telefon = telefon;
    }

    public Kupac() {
    }
    
    @Override
    public String nazivTabele() {
        return " kupac ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Kupac k = new Kupac(rs.getLong("KupacID"),
                    rs.getString("imeKupca"), rs.getString("prezimeKupca"),
                    rs.getString("email"), rs.getString("telefon"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imeKupca, prezimeKupca, email, telefon) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KupacID = " + kupacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeKupca + "', '" + prezimeKupca + "', "
                + "'" + email + "', '" + telefon + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " email = '" + email + "', "
                + "telefon = '" + telefon +  "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getKupacID() {
        return kupacID;
    }

    public void setKupacID(Long kupacID) {
        this.kupacID = kupacID;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
