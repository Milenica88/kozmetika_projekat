/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.proizvod;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.util.ArrayList;
import so.OpstaSO;

/**
 *
 * @author Milena
 */
public class SOGetAllProizvod extends OpstaSO {
    
     private ArrayList<Proizvod> listaProizvoda;

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Proizvod)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Proizvod!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        ArrayList<OpstiDomenskiObjekat> proizvodi = DBBroker.getInstance().select(ado);
        listaProizvoda = (ArrayList<Proizvod>) (ArrayList<?>) proizvodi;
    }

    public ArrayList<Proizvod> getLista() {
        return listaProizvoda;
    }

}
