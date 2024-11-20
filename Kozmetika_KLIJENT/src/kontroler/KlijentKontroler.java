/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Administrator;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacije;
import transfer.util.StatusOdgovora;

/**
 *
 * @author Milena
 */
public class KlijentKontroler {
    private static KlijentKontroler instance;

    private KlijentKontroler() {
    }

    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }
    
    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) posaljiZahtev(Operacije.LOGIN, administrator);
    }


    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev zahtev = new  KlijentskiZahtev(operacija, parametar);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(zahtev);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        ServerskiOdgovor odgovor = (ServerskiOdgovor) in.readObject();

        if (odgovor.getStatusOdgovora().equals(StatusOdgovora.Error)) {
            throw odgovor.getException();
        } else {
            return odgovor.getOdgovor();
        }

    }

    
}
