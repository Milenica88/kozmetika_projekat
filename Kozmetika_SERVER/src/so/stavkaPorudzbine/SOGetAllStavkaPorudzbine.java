/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaPorudzbine;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.StavkaPorudzbine;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Milena
 */
public class SOGetAllStavkaPorudzbine extends AbstractSO {
     private ArrayList<StavkaPorudzbine> listaStavkiPor;

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof StavkaPorudzbine)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaPorudzbine!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        ArrayList<OpstiDomenskiObjekat> stavkePorudzbine = DBBroker.getInstance().select(ado);
        listaStavkiPor = (ArrayList<StavkaPorudzbine>) (ArrayList<?>) stavkePorudzbine;
    }

    public ArrayList<StavkaPorudzbine> getLista() {
        return listaStavkiPor;
    }

}
