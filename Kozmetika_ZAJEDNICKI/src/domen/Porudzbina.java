/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Milena
 */
public class Porudzbina extends OpstiDomenskiObjekat {
    
    private Long porudzbinaID;
    private Date datumVreme;
    private Date datumIsporuke;
    private double ukupnaCena;
    private Kupac kupac;
    private Administrator administrator;
    private ArrayList<StavkaPorudzbine> stavkePorudzbine;

    public Porudzbina(Long porudzbinaID, Date datumVreme, Date datumIsporuke, double ukupnaCena, Kupac kupac, Administrator administrator, ArrayList<StavkaPorudzbine> stavkePorudzbine) {
        this.porudzbinaID = porudzbinaID;
        this.datumVreme = datumVreme;
        this.datumIsporuke = datumIsporuke;
        this.ukupnaCena = ukupnaCena;
        this.kupac = kupac;
        this.administrator = administrator;
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public Porudzbina() {
    }

    @Override
    public String nazivTabele() {
        return " porudzbina ";
    }

    @Override
    public String alijas() {
        return " por ";
    }

    @Override
    public String join() {
        return " JOIN KUPAC K ON (K.KUPACID = POR.KUPACID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = POR.ADMINISTRATORID) ";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Kupac k = new Kupac(rs.getLong("KupacID"),
                    rs.getString("imeKupca"), rs.getString("prezimeKupca"),
                    rs.getString("email"), rs.getString("telefon"));

            Porudzbina por = new Porudzbina(rs.getLong("porudzbinaID"),
                    rs.getTimestamp("datumVreme"), rs.getDate("datumIsporuke"),
                    rs.getDouble("ukupnaCena"), k, a, null);

            lista.add(por);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, datumIsporuke, ukupnaCena, kupacID, administratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " porudzbinaID = " + porudzbinaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', "
                + "'" + new java.sql.Date(datumIsporuke.getTime()) + "', "
                + " " + ukupnaCena + " ,  " + kupac.getKupacID()+ ", "
                + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " datumIsporuke = '" + new java.sql.Date(datumIsporuke.getTime()) + "', "
                + "ukupnaCena = " + ukupnaCena + " ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getPorudzbinaID() {
        return porudzbinaID;
    }

    public void setPorudzbinaID(Long porudzbinaID) {
        this.porudzbinaID = porudzbinaID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Date getDatumIsporuke() {
        return datumIsporuke;
    }

    public void setDatumIsporuke(Date datumIsporuke) {
        this.datumIsporuke = datumIsporuke;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<StavkaPorudzbine> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(ArrayList<StavkaPorudzbine> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }

}
