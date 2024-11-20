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
public class StavkaPorudzbine extends OpstiDomenskiObjekat{
    private Porudzbina porudzbina;
    private int rbStavke;
    private int kolicinaStavke;
    private double cenaStavke;
    private Proizvod proizvod;

    public StavkaPorudzbine(Porudzbina porudzbina, int rbStavke, int kolicinaStavke, double cenaStavke, Proizvod proizvod) {
        this.porudzbina = porudzbina;
        this.rbStavke = rbStavke;
        this.kolicinaStavke = kolicinaStavke;
        this.cenaStavke = cenaStavke;
        this.proizvod = proizvod;
    }

    public StavkaPorudzbine() {
    }

    @Override
    public String nazivTabele() {
        return " stavkaPorudzbine ";
    }

    @Override
    public String alijas() {
        return " sp ";
    }

    @Override
    public String join() {
        return " JOIN PORUDZBINA POR USING (PORUDZBINAID) "
                + "JOIN KUPAC K ON (K.KUPACID = POR.KUPACID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = POR.ADMINISTRATORID) "
                + "JOIN PROIZVOD P USING (PROIZVODID) "
                + "JOIN TIPPROIZVODA TP ON (TP.TIPPROIZVODAID = P.TIPPROIZVODAID) ";
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
            
            TipProizvoda tp = new TipProizvoda(rs.getLong("TipProizvodaID"),
                    rs.getString("NazivTipaProizvoda"));
            
            Proizvod p = new Proizvod(rs.getLong("proizvodID"), 
                    rs.getString("nazivProizvoda"), rs.getString("opisProizvoda"), 
                    rs.getDouble("cenaPoJedinici"), tp);
            
            StavkaPorudzbine sp = new StavkaPorudzbine(por, rs.getInt("rbStavke"), 
                    rs.getInt("kolicinaStavke"), rs.getDouble("cenaStavke"), p);
           
            lista.add(sp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (porudzbinaID, rbStavke, kolicinaStavke, cenaStavke, proizvodID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " porudzbinaID = " + porudzbina.getPorudzbinaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + porudzbina.getPorudzbinaID() + " ,  " + rbStavke + " , "
                + " " + kolicinaStavke + " ,  " + cenaStavke + " , " + proizvod.getProizvodID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE POR.PORUDZBINAID = " + porudzbina.getPorudzbinaID();
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicinaStavke() {
        return kolicinaStavke;
    }

    public void setKolicinaStavke(int kolicinaStavke) {
        this.kolicinaStavke = kolicinaStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
