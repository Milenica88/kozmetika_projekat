/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Administrator;
import domen.Kupac;
import domen.Porudzbina;
import domen.Proizvod;
import domen.Recenzija;
import domen.StavkaPorudzbine;
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

    public void addKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.ADD_KUPAC, kupac);
    }

    public void addPorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operacije.ADD_PORUDZBINA, porudzbina);
    }

    public void addRecenzija(Recenzija recenzija) throws Exception {
        posaljiZahtev(Operacije.ADD_RECENZIJA, recenzija);
    }

    public void deleteKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.DELETE_KUPAC, kupac);
    }

    public void deletePorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operacije.DELETE_PORUDZBINA, porudzbina);
    }
    
    public void deleteStatistika(Recenzija recenzija) throws Exception {
        posaljiZahtev(Operacije.DELETE_RECENZIJA, recenzija);
    }

    public void updateKupac(Kupac kupac) throws Exception {
        posaljiZahtev(Operacije.UPDATE_KUPAC, kupac);
    }

    public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        posaljiZahtev(Operacije.UPDATE_PORUDZBINA, porudzbina);
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        return (ArrayList<Kupac>) posaljiZahtev(Operacije.GET_ALL_KUPAC, null);
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        return (ArrayList<Porudzbina>) posaljiZahtev(Operacije.GET_ALL_PORUDZBINA, null);
    }

    public ArrayList<Proizvod> getAllProizvod() throws Exception {
        return (ArrayList<Proizvod>) posaljiZahtev(Operacije.GET_ALL_PROIZVOD, null);
    }

    public ArrayList<StavkaPorudzbine> getAllStavkaPorudzbine(Porudzbina p) throws Exception {
        return (ArrayList<StavkaPorudzbine>) posaljiZahtev(Operacije.GET_ALL_STAVKA_PORUDZBINE, p);
    }

    public ArrayList<Recenzija> getAllRecenzija() throws Exception {
        return (ArrayList<Recenzija>) posaljiZahtev(Operacije.GET_ALL_RECENZIJA,null);
    }

    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(operacija, parametar);

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
