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
import java.util.ArrayList;
import java.util.List;
import so.kupac.SOAddKupac;
import so.kupac.SODeleteKupac;
import so.kupac.SOGetAllKupac;
import so.kupac.SOUpdateKupac;
import so.login.SOLogin;
import so.porudzbina.SOAddPorudzbina;
import so.porudzbina.SODeletePorudzbina;
import so.porudzbina.SOGetAllPorudzbina;
import so.porudzbina.SOUpdatePorudzbina;
import so.proizvod.SOGetAllProizvod;
import so.recenzija.SOAddRecenzija;
import so.recenzija.SODeleteRecenzija;
import so.recenzija.SOGetAllRecenzija;
import so.stavkaPorudzbine.SOGetAllStavkaPorudzbine;

/**
 *
 * @author Milena
 */
public class ServerKontroler {

    private static ServerKontroler instance;
    private List<Administrator> ulogovaniAdministratori = new ArrayList<>();

    private ServerKontroler() {
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public List<Administrator> getUlogovaniAdministratori() {
        return ulogovaniAdministratori;
    }

    public void addKupac(Kupac kupac) throws Exception {
        (new SOAddKupac()).templateExecute(kupac);
    }

    public void addPorudzbina(Porudzbina porudzbina) throws Exception {
        (new SOAddPorudzbina()).templateExecute(porudzbina);
    }

    public void addRecenzija(Recenzija recenzija) throws Exception {
        (new SOAddRecenzija()).templateExecute(recenzija);
    }

    public void deleteKupac(Kupac kupac) throws Exception {
        (new SODeleteKupac()).templateExecute(kupac);
    }

    public void deletePorudzbina(Porudzbina porudzbina) throws Exception {
        (new SODeletePorudzbina()).templateExecute(porudzbina);
    }

    public void deleteRecenzija(Recenzija recenzija) throws Exception {
        (new SODeleteRecenzija()).templateExecute(recenzija);
    }

    public void updateKupac(Kupac kupac) throws Exception {
        (new SOUpdateKupac()).templateExecute(kupac);
    }

    public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        (new SOUpdatePorudzbina()).templateExecute(porudzbina);
    }

    public ArrayList<Kupac> getAllKupac() throws Exception {
        SOGetAllKupac so = new SOGetAllKupac();
        so.templateExecute(new Kupac());
        return so.getLista();
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        SOGetAllPorudzbina so = new SOGetAllPorudzbina();
        so.templateExecute(new Porudzbina());
        return so.getLista();
    }

    public ArrayList<Proizvod> getAllProizvod() throws Exception {
        SOGetAllProizvod so = new SOGetAllProizvod();
        so.templateExecute(new Proizvod());
        return so.getLista();
    }

    public ArrayList<Recenzija> getAllRecenzija() throws Exception {
        SOGetAllRecenzija so = new SOGetAllRecenzija();
        so.templateExecute(new Recenzija());
        return so.getLista();
    }

    public ArrayList<StavkaPorudzbine> getAllStavkaPorudzbine(Porudzbina p) throws Exception {
        SOGetAllStavkaPorudzbine so = new SOGetAllStavkaPorudzbine();

        StavkaPorudzbine sp = new StavkaPorudzbine();
        sp.setPorudzbina(p);

        so.templateExecute(sp);
        return so.getLista();
    }
}
