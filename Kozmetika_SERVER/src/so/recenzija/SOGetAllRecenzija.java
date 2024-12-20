/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recenzija;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Recenzija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Milena
 */
public class SOGetAllRecenzija extends AbstractSO {
    private ArrayList<Recenzija> lista;

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        ArrayList<OpstiDomenskiObjekat> statistike = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Recenzija>) (ArrayList<?>) statistike;
    }

    public ArrayList<Recenzija> getLista() {
        return lista;
    }
}
