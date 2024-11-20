/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import db.DBBroker;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import kontroler.ServerKontroler;
import so.AbstractSO;

/**
 *
 * @author Milena
 */
public class SOLogin extends AbstractSO {
    Administrator ulogovani;

    @Override
    protected void validate(OpstiDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
        
        Administrator a=(Administrator) ado;
        /*if(ServerController.getInstance().getUlogovaniRadnici().size()==2){
            throw new Exception("Vec su ulogovana dva radnika na sistem, ne moze vise da ih primi...");
        }*/
        
        for (Administrator admin : ServerKontroler.getInstance().getUlogovaniAdministratori()) {
            if(a.getUsername().equals(admin.getUsername()) || a.getPassword().equals(admin.getPassword())){
                throw new Exception("Vec postoji ulogovan administrator sa tim kredencijalima...");
            }
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat ado) throws Exception {
        Administrator a = (Administrator) ado;

        ArrayList<Administrator> admini
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Administrator admin : admini) {
            if (admin.getUsername().equals(a.getUsername())
                    && admin.getPassword().equals(a.getPassword())) {
                ulogovani = admin;
                ServerKontroler.getInstance().getUlogovaniAdministratori().add(a);
                return;
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
    }
    
    public Administrator getUlogovani() {
        return ulogovani;
    }
}
