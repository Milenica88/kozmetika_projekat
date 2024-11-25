/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kupac;

import db.DBBroker;
import domen.Kupac;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Milena
 */
public class SOUpdateKupac extends AbstractSO {

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac!");
        }

        Kupac izmenjeniKupac = (Kupac) ado;

        ArrayList<Kupac> kupci = (ArrayList<Kupac>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Kupac kupac : kupci) {
            if (!kupac.getKupacID().equals(izmenjeniKupac.getKupacID())) {
                if (kupac.getEmail().equals(izmenjeniKupac.getEmail())) {
                    throw new Exception("Vec postoji kupac s tim emailom!");
                }
                if (kupac.getTelefon().equals(izmenjeniKupac.getTelefon())) {
                    throw new Exception("Vec postoji kupac s tim brojem telefona!");
                }
            }
        }

    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
}
