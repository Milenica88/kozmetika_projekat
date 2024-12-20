/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recenzija;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Recenzija;
import so.AbstractSO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Milena
 */
public class SOAddRecenzija extends AbstractSO {
    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Recenzija!");
        }

        Recenzija s = (Recenzija) ado;
       
        if (s.getOcena() < 1 || s.getOcena() > 5) {
            throw new Exception("Ocena mora biti u opsegu od 1 do 5!");
        }

        if (s.getProizvod() == null) {
            throw new Exception("Proizvod ne moze biti null!");
        }
        if (s.getKupac() == null) {
            throw new Exception("Kupac ne moze biti null!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long recenzijaID = tableKeys.getLong(1);

        
        Recenzija r = (Recenzija) ado;
        r.setRecenzijaID(recenzijaID);

        
    }
}
