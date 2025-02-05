/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Porudzbina;
import domen.StavkaPorudzbine;
import java.util.Date;
import so.OpstaSO;

/**
 *
 * @author Milena
 */
public class SOUpdatePorudzbina extends OpstaSO {
     @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Porudzbina)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina!");
        }

        Porudzbina p = (Porudzbina) ado;

        if (!p.getDatumIsporuke().after(new Date())) {
            throw new Exception("Datum isporuke mora biti posle danasnjeg datuma!");
        }

        if (p.getStavkePorudzbine().isEmpty()) {
            throw new Exception("Porudzbina mora imati barem jednu stavku!");
        }

    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        // updatujemo porudzbinu
        DBBroker.getInstance().update(ado);

        // brisemo stare stavke
        Porudzbina p = (Porudzbina) ado;
        StavkaPorudzbine prvaStavka = p.getStavkePorudzbine().get(0);
        // sledeca linija koda izvrsava naredbu 
        // DELETE FROM STAVKAPORUDZBINE WHERE PORUDZBINAID = nasID
        // cime se brisu SVE stavke nase porudzbine ODJEDNOM !!!
        DBBroker.getInstance().delete(prvaStavka);

        // dodajemo nove
        for (StavkaPorudzbine stavkaPorudzbine : p.getStavkePorudzbine()) {
            DBBroker.getInstance().insert(stavkaPorudzbine);
        }
    }

}
