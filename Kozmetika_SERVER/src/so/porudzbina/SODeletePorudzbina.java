/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Porudzbina;
import so.OpstaSO;

/**
 *
 * @author Milena
 */
public class SODeletePorudzbina extends OpstaSO {

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
}
