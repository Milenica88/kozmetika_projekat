/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.recenzija;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Recenzija;
import so.AbstractSO;

/**
 *
 * @author Milena
 */
public class SODeleteRecenzija extends AbstractSO {
    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
