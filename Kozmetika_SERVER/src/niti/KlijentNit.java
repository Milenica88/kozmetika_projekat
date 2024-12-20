/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Administrator;
import domen.Kupac;
import domen.Porudzbina;
import domen.Recenzija;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import kontroler.ServerKontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacije;
import transfer.util.StatusOdgovora;

/**
 *
 * @author Milena
 */
public class KlijentNit extends Thread {

    private Socket socket;

    KlijentNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev zahtev = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor odgovor = handleRequest(zahtev);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(odgovor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor handleRequest(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor(null, null, StatusOdgovora.Success);
        try {
            switch (zahtev.getOperacija()) {
                case Operacije.ADD_KUPAC:
                    ServerKontroler.getInstance().addKupac((Kupac) zahtev.getParametar());
                    break;
                case Operacije.ADD_PORUDZBINA:
                    ServerKontroler.getInstance().addPorudzbina((Porudzbina) zahtev.getParametar());
                    break;
                case Operacije.ADD_RECENZIJA:
                    ServerKontroler.getInstance().addRecenzija((Recenzija) zahtev.getParametar());
                    break;
                case Operacije.DELETE_KUPAC:
                    ServerKontroler.getInstance().deleteKupac((Kupac) zahtev.getParametar());
                    break;
                case Operacije.DELETE_PORUDZBINA:
                    ServerKontroler.getInstance().deletePorudzbina((Porudzbina) zahtev.getParametar());
                    break;
                case Operacije.DELETE_RECENZIJA:
                    ServerKontroler.getInstance().deleteRecenzija((Recenzija) zahtev.getParametar());
                    break;
                case Operacije.UPDATE_KUPAC:
                    ServerKontroler.getInstance().updateKupac((Kupac) zahtev.getParametar());
                    break;
                case Operacije.UPDATE_PORUDZBINA:
                    ServerKontroler.getInstance().updatePorudzbina((Porudzbina) zahtev.getParametar());
                    break;
                /*case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;*/
                case Operacije.GET_ALL_KUPAC:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllKupac());
                    break;
                case Operacije.GET_ALL_PORUDZBINA:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllPorudzbina());
                    break;
                case Operacije.GET_ALL_PROIZVOD:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllProizvod());
                    break;
                case Operacije.GET_ALL_STAVKA_PORUDZBINE:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllStavkaPorudzbine((Porudzbina) zahtev.getParametar()));
                    break;
                case Operacije.GET_ALL_RECENZIJA:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllRecenzija());
                    break;
                /*case Operation.GET_ALL_TIP_PROIZVODA:
                    response.setData(ServerController.getInstance().getAllTipProizvoda());
                    break;*/
                case Operacije.LOGIN:
                    Administrator administrator = (Administrator) zahtev.getParametar();
                    Administrator ulogovani = ServerKontroler.getInstance().login(administrator);
                    odgovor.setOdgovor(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            odgovor.setStatusOdgovora(StatusOdgovora.Error);
            odgovor.setException(e);
        }
        return odgovor;
    }
}
