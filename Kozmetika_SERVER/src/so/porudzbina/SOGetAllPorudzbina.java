/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Porudzbina;
import java.util.ArrayList;
import so.OpstaSO;

/**
 *
 * @author Milena
 */
public class SOGetAllPorudzbina extends OpstaSO {
    private ArrayList<Porudzbina> listaPor;

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        ArrayList<OpstiDomenskiObjekat> porudzbine = DBBroker.getInstance().select(ado);
        listaPor = (ArrayList<Porudzbina>) (ArrayList<?>) porudzbine;
    }

    public ArrayList<Porudzbina> getLista() {
        return listaPor;
    }

}
